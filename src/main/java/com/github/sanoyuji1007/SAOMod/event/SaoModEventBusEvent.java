package com.github.sanoyuji1007.SAOMod.event;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.entity.SaoModEntities;
import com.github.sanoyuji1007.SAOMod.entity.custom.BlackSlime;
import com.github.sanoyuji1007.SAOMod.entity.custom.FrenzyBoar;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SaoModEventBusEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SaoModEntities.BLACK_SLIME.get(), BlackSlime.createAttributes().build());
        event.put(SaoModEntities.FRENZY_BOAR.get(), FrenzyBoar.createAttributes().build());
    }
}