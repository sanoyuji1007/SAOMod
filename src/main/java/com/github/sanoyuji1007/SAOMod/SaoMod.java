package com.github.sanoyuji1007.SAOMod;

import com.github.sanoyuji1007.SAOMod.block.SaoModBlocks;
import com.github.sanoyuji1007.SAOMod.entity.SaoModEntities;
import com.github.sanoyuji1007.SAOMod.item.SaoModItems;
import com.github.sanoyuji1007.SAOMod.item.SaoModTabs;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

//TODO: コメントの追加

@Mod(SaoMod.MOD_ID)
public class SaoMod
{

    public static final String MOD_ID = "saomod";

    private static final Logger LOGGER = LogUtils.getLogger();

    public SaoMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        //  アイテムレジストリをイベントバスに登録
        SaoModItems.register(modEventBus);
        //  クリエイティブタブレジストリをイベントバスに登録
        SaoModTabs.register(modEventBus);
        //  ブロックレジストリをイベントバスに登録
        SaoModBlocks.reister(modEventBus);
        // エンティティレジストリをイベントバスに登録
        SaoModEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    //  クリエイティブタブにアイテムを追加
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        //  もし開いているタブが「材料」タブだったら、アイテムを表示
//        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
//            event.accept(SaoModItems.RAW_ORIHALCON);
//            event.accept(SaoModItems.ORIHALCON_INGOT);
//            event.accept(SaoModItems.HEAL_CRYSTAL);
//            event.accept(SaoModItems.FIRE_CRYSTAL);
//            event.accept(SaoModItems.ICE_CRYSTAL);
//            event.accept(SaoModItems.THUNDER_CRYSTAL);
//            event.accept(SaoModItems.SPEED_CRYSTAL);
//            event.accept(SaoModItems.JUMP_CRYSTAL);
//            event.accept(SaoModItems.INVISIBLE_CRYSTAL);
//            event.accept(SaoModItems.EXPLOSION_CRYSTAL);
//            event.accept(SaoModBlocks.ORIHALCON_BLOCK);
//            event.accept(SaoModBlocks.RAW_ORIHALCON_BLOCK);
//        }
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
