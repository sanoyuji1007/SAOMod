package com.github.sanoyuji1007.SAOMod.datagen.client;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.block.SaoModBlocks;
import com.github.sanoyuji1007.SAOMod.entity.SaoModEntities;
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
        addItem(SaoModItems.HEAL_CRYSTAL, "回復結晶");
        addItem(SaoModItems.FIRE_CRYSTAL, "炎魔法結晶");
        addItem(SaoModItems.ICE_CRYSTAL, "氷魔法結晶");
        addItem(SaoModItems.THUNDER_CRYSTAL, "雷魔法結晶");
        addItem(SaoModItems.SPEED_CRYSTAL, "移動速度上昇結晶");
        addItem(SaoModItems.JUMP_CRYSTAL, "飛翔結晶");
        addItem(SaoModItems.INVISIBLE_CRYSTAL, "透明化結晶");
        addItem(SaoModItems.EXPLOSION_CRYSTAL, "爆発結晶");
        addItem(SaoModItems.ELUCIDATOR, "エリシュデータ");
        addItem(SaoModItems.BLACK_SLIME_SPWAN_EGG, "ブラックスライムのスポーンエッグ");
        //creativetab
        add("creativetabs.sao_mod_tab", "SAOMod");
        //block
        addBlock(SaoModBlocks.ORIHALCON_BLOCK, "オリハルコンブロック");
        addBlock(SaoModBlocks.RAW_ORIHALCON_BLOCK, "オリハルコンの原石ブロック");
        addBlock(SaoModBlocks.SAO_BLOCK, "SAOブロック");
        //entity
        addEntityType(SaoModEntities.BLACK_SLIME,"ブラックスライム");
    }
}
