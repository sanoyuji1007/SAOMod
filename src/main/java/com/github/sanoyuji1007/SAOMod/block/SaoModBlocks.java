package com.github.sanoyuji1007.SAOMod.block;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SaoModBlocks {
    //  レジストリの作成
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, SaoMod.MOD_ID);

    //  レジストリにブロックを登録
    //  ダイヤモンドブロックの設定をコピー
    //  金床の設置音を設定
    public static final RegistryObject<Block>ORIHALCON_BLOCK = BLOCKS.register("orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));

    //  レジストリをイベントバスに登録する
    public static void reister(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
