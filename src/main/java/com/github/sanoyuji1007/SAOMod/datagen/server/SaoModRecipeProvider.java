package com.github.sanoyuji1007.SAOMod.datagen.server;

import com.github.sanoyuji1007.SAOMod.block.SaoModBlocks;
import com.github.sanoyuji1007.SAOMod.item.SaoModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class SaoModRecipeProvider extends RecipeProvider {

    public SaoModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                SaoModItems.ORIHALCON_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                SaoModBlocks.ORIHALCON_BLOCK.get());
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                SaoModItems.RAW_ORIHALCON.get(),
                RecipeCategory.BUILDING_BLOCKS,
                SaoModBlocks.RAW_ORIHALCON_BLOCK.get());
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pWriter,
                                                  RecipeCategory pUnpackedCategory,
                                                  ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory,
                                                  ItemLike pPacked) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked)).save(pWriter);

        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked)
                .pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pWriter);
    }
}
