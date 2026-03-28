package com.github.sanoyuji1007.SAOMod.datagen;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.block.SaoModBlocks;
import com.github.sanoyuji1007.SAOMod.item.SaoModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, SaoMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        //Item
        addItem(SaoModItems.RAW_ORIHALCON, "オリハルコンの原石");
        addItem(SaoModItems.ORIHALCON_INGOT, "オリハルコンインゴット");
        //creativetab
        add("creativetabs.sao_mod_tab", "SAOMod");
        //block
        addBlock(SaoModBlocks.ORIHALCON_BLOCK, "オリハルコンブロック");
        addBlock(SaoModBlocks.RAW_ORIHALCON_BLOCK, "オリハルコンの原石ブロック");
    }
}
