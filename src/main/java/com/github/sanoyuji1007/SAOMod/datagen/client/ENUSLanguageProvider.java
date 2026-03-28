package com.github.sanoyuji1007.SAOMod.datagen.client;

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
        addItem(SaoModItems.HEAL_CRYSTAL, "Healing Crystal");
        addItem(SaoModItems.FIRE_CRYSTAL, "Fire Crystal");
        addItem(SaoModItems.ICE_CRYSTAL, "Ice Crystal");
        addItem(SaoModItems.THUNDER_CRYSTAL, "Thunder Crystal");
        addItem(SaoModItems.SPEED_CRYSTAL, "Speed Crystal");
        addItem(SaoModItems.JUMP_CRYSTAL, "Jump Crystal");
        addItem(SaoModItems.INVISIBLE_CRYSTAL, "Invisible Crystal");
        addItem(SaoModItems.EXPLOSION_CRYSTAL, "Explosion Crystal");
        addItem(SaoModItems.ELUCIDATOR, "Elucidator");
        //creativetab
        add("creativetabs.sao_mod_tab", "SAOMod");
        //block
        addBlock(SaoModBlocks.ORIHALCON_BLOCK, "Orihalcon Block");
        addBlock(SaoModBlocks.RAW_ORIHALCON_BLOCK, "Raw Orihalcon Block");
        addBlock(SaoModBlocks.SAO_BLOCK, "SAO Block");
    }
}
