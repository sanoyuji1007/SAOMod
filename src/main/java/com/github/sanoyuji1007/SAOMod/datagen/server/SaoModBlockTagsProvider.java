package com.github.sanoyuji1007.SAOMod.datagen.server;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.block.SaoModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SaoModBlockTagsProvider extends BlockTagsProvider {

    public SaoModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SaoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // 適正ツール：ツルハシ
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SaoModBlocks.ORIHALCON_BLOCK.get(),
                        SaoModBlocks.RAW_ORIHALCON_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(SaoModBlocks.ORIHALCON_BLOCK.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(SaoModBlocks.RAW_ORIHALCON_BLOCK.get());
    }
}
