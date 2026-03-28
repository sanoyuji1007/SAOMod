package com.github.sanoyuji1007.SAOMod.datagen;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.item.SaoModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SaoModItemModelProvider extends ItemModelProvider {

    public SaoModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, SaoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(SaoModItems.RAW_ORIHALCON.get());
        basicItem(SaoModItems.ORIHALCON_INGOT.get());
    }
}
