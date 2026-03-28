package com.github.sanoyuji1007.SAOMod.datagen.client;

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
        basicItem(SaoModItems.HEAL_CRYSTAL.get());
        basicItem(SaoModItems.FIRE_CRYSTAL.get());
        basicItem(SaoModItems.ICE_CRYSTAL.get());
        basicItem(SaoModItems.THUNDER_CRYSTAL.get());
        basicItem(SaoModItems.SPEED_CRYSTAL.get());
        basicItem(SaoModItems.JUMP_CRYSTAL.get());
        basicItem(SaoModItems.INVISIBLE_CRYSTAL.get());
        basicItem(SaoModItems.EXPLOSION_CRYSTAL.get());
        basicItem(SaoModItems.ELUCIDATOR.get());

        withExistingParent(SaoModItems.BLACK_SLIME_SPWAN_EGG.getId().getPath(),
                mcLoc("item/template_spawn_egg"));
    }
}
