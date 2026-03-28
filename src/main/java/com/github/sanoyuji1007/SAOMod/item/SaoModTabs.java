package com.github.sanoyuji1007.SAOMod.item;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.block.SaoModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SaoModTabs {
    //  レジストリの作成
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SaoMod.MOD_ID);
    // レジストリにタブを登録
    public static final RegistryObject<CreativeModeTab> SAO_MOD_TAB = TABS.register("sao_mod_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.sao_mod_tab"))
                    .icon(SaoModItems.RAW_ORIHALCON.get()::getDefaultInstance)
                    .displayItems(((pParameters, pOutput) -> {
                        //item
                        pOutput.accept(SaoModItems.RAW_ORIHALCON.get());
                        pOutput.accept(SaoModItems.ORIHALCON_INGOT.get());
                        pOutput.accept(SaoModItems.HEAL_CRYSTAL.get());
                        pOutput.accept(SaoModItems.FIRE_CRYSTAL.get());
                        pOutput.accept(SaoModItems.ICE_CRYSTAL.get());
                        pOutput.accept(SaoModItems.THUNDER_CRYSTAL.get());
                        pOutput.accept(SaoModItems.SPEED_CRYSTAL.get());
                        pOutput.accept(SaoModItems.JUMP_CRYSTAL.get());
                        pOutput.accept(SaoModItems.INVISIBLE_CRYSTAL.get());
                        pOutput.accept(SaoModItems.EXPLOSION_CRYSTAL.get());
                        pOutput.accept(SaoModItems.ELUCIDATOR.get());
                        //block
                        pOutput.accept(SaoModBlocks.ORIHALCON_BLOCK.get());
                        pOutput.accept(SaoModBlocks.RAW_ORIHALCON_BLOCK.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        // クリエイティブタブをイベントバスに登録
        TABS.register(eventBus);
    }
}
