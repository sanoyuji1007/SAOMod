package com.github.sanoyuji1007.SAOMod.datagen;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.item.SaoModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= SaoMod.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class SaoModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

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
        generator.addProvider(event.includeClient(), new SaoModRecipeProvider(packOutput));
    }
}
