package com.github.sanoyuji1007.SAOMod.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SaoModChunkGenerator extends NoiseBasedChunkGenerator {

    /**
     * ChunkGeneratorのCodecを登録するレジストリ
     * → JSONの "type": "saomod:sao_chunk_generator" と紐づく
     */
    public static final DeferredRegister<Codec<? extends ChunkGenerator>> CHUNK_GENERATORS =
            DeferredRegister.create(Registries.CHUNK_GENERATOR, "saomod");

    /**
     * 自作ChunkGeneratorの登録
     * → JSONからこのクラスを生成するための情報
     */
    public static final RegistryObject<Codec<SaoModChunkGenerator>> SAO =
            CHUNK_GENERATORS.register("sao_chunk_generator", () ->
                    RecordCodecBuilder.create(instance ->
                            instance.group(
                                    // バイオーム情報（必須）
                                    BiomeSource.CODEC.fieldOf("biome_source").forGetter(gen -> gen.biomeSource),

                                    // ノイズ設定（形式的に必要）
                                    NoiseGeneratorSettings.CODEC.fieldOf("settings").forGetter(gen -> gen.settings)
                            ).apply(instance, SaoModChunkGenerator::new)
                    )
            );

    /**
     * settingsを自分で保持（親クラスのはprivateで取れないため）
     */
    private final Holder<NoiseGeneratorSettings> settings;

    /**
     * コンストラクタ
     * → JSONの内容から呼ばれる
     */
    public SaoModChunkGenerator(BiomeSource biomeSource, Holder<NoiseGeneratorSettings> settings) {
        super(biomeSource, settings);
        this.settings = settings; // ← これ重要（Codec用）
    }

    /**
     * 地表生成処理
     * → チャンクごとに呼ばれる
     */
    @Override
    public void buildSurface(WorldGenRegion region, StructureManager structureManager, RandomState randomState, ChunkAccess chunk) {

        ChunkPos chunkPos = chunk.getPos();
        int chunkX = chunkPos.x;
        int chunkZ = chunkPos.z;

        // =========================
        // 中央チャンク以外は全部消す
        // =========================
//        if (chunkX != 0 || chunkZ != 0) {
//            for (int x = 0; x < 16; x++) {
//                for (int y = 0; y < 256; y++) {
//                    for (int z = 0; z < 16; z++) {
//                        region.setBlock(new BlockPos(
//                                chunkX * 16 + x,
//                                y,
//                                chunkZ * 16 + z
//                        ), Blocks.AIR.defaultBlockState(), 3);
//                    }
//                }
//            }
//            return;
//        }

        // =========================
        // 中央チャンク（16×16の床）
        // =========================
//        for (int x = 0; x < 16; x++) {
//            for (int z = 0; z < 16; z++) {
//
//                // 高さ100に石の床を生成
//                region.setBlock(new BlockPos(x, 100, z),
//                        Blocks.STONE.defaultBlockState(), 3);
//            }
//        }
    }
}