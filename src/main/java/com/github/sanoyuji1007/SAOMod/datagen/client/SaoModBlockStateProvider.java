package com.github.sanoyuji1007.SAOMod.datagen.client;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.block.SaoModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SaoModBlockStateProvider extends BlockStateProvider {

    public SaoModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SaoMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(SaoModBlocks.ORIHALCON_BLOCK);
        simpleBlockWithItem(SaoModBlocks.RAW_ORIHALCON_BLOCK);
        simpleBlockWithItem(SaoModBlocks.SAO_BLOCK);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

}
