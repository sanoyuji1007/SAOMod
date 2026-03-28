package com.github.sanoyuji1007.SAOMod.event;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.entity.SaoModEntities;
import com.github.sanoyuji1007.SAOMod.entity.model.BlackSlimeModel;
import com.github.sanoyuji1007.SAOMod.entity.renderer.BlackSlimeRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaoMod.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT)
public class SaoModEventBusClientEvent {
    @SubscribeEvent
    public static void registerLayerDefinitions(
            EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BlackSlimeModel.LAYER_LOCATION,
                BlackSlimeModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderer(
            EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SaoModEntities.BLACK_SLIME.get(),
                BlackSlimeRenderer::new);
    }
}