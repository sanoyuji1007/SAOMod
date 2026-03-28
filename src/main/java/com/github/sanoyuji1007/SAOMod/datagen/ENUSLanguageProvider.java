package com.github.sanoyuji1007.SAOMod.datagen;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.block.SaoModBlocks;
import com.github.sanoyuji1007.SAOMod.item.SaoModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, SaoMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        //Item
        addItem(SaoModItems.RAW_ORIHALCON, "Raw Orihalcon");
        addItem(SaoModItems.ORIHALCON_INGOT, "Orihalcon Ingot");
        //creativetab
        add("creativetabs.sao_mod_tab", "SAOMod");
        //block
        addBlock(SaoModBlocks.ORIHALCON_BLOCK, "Orihalcon Block");
        addBlock(SaoModBlocks.RAW_ORIHALCON_BLOCK, "Raw Orihalcon Block");
    }
}
