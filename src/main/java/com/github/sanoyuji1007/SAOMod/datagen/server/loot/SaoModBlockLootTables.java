package com.github.sanoyuji1007.SAOMod.datagen.server.loot;

import com.github.sanoyuji1007.SAOMod.block.SaoModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class SaoModBlockLootTables extends BlockLootSubProvider {
    protected SaoModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(SaoModBlocks.ORIHALCON_BLOCK.get());
        this.dropSelf(SaoModBlocks.RAW_ORIHALCON_BLOCK.get());
        this.dropSelf(SaoModBlocks.SAO_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SaoModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
