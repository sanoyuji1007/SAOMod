package com.github.sanoyuji1007.SAOMod.datagen;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.datagen.client.ENUSLanguageProvider;
import com.github.sanoyuji1007.SAOMod.datagen.client.JAJPLanguageProvider;
import com.github.sanoyuji1007.SAOMod.datagen.client.SaoModBlockStateProvider;
import com.github.sanoyuji1007.SAOMod.datagen.client.SaoModItemModelProvider;
import com.github.sanoyuji1007.SAOMod.datagen.server.SaoModBlockTagsProvider;
import com.github.sanoyuji1007.SAOMod.datagen.server.SaoModRecipeProvider;
import com.github.sanoyuji1007.SAOMod.datagen.server.loot.SaoModLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid= SaoMod.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class SaoModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        // アイテム用のモデルファイルの生成
        generator.addProvider(event.includeClient(), new SaoModItemModelProvider(packOutput
                , existingFileHelper));
        // ブロック用のモデルファイルの生成
        generator.addProvider(event.includeClient(),
                new SaoModBlockStateProvider(packOutput, existingFileHelper));
        // 言語ファイル（英語）
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        // 言語ファイル（日本語）
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));
        // レシピ
        generator.addProvider(event.includeServer(), new SaoModRecipeProvider(packOutput));
        //  ルートテーブル
        generator.addProvider(event.includeServer(), SaoModLootTables.create(packOutput));
        // ブロックタグ
        generator.addProvider(event.includeServer(), new SaoModBlockTagsProvider(packOutput
                ,lookUpProvider, existingFileHelper));

    }
}
