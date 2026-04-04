package com.github.sanoyuji1007.SAOMod.entity;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.entity.custom.BlackSlime;
import com.github.sanoyuji1007.SAOMod.entity.custom.FrenzyBoar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SaoModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
                    SaoMod.MOD_ID);
    //  ブラックスライムをレジストリに追加
    public static final RegistryObject<EntityType<BlackSlime>> BLACK_SLIME =
            ENTITY_TYPES.register("black_slime",
                    () -> EntityType.Builder.of(BlackSlime::new, MobCategory.MONSTER)
                            .build("black_slime"));
    //  フレンジーボアをレジストリに追加
    public static final RegistryObject<EntityType<FrenzyBoar>> FRENZY_BOAR =
            ENTITY_TYPES.register("frenzy_boar",
                    () -> EntityType.Builder.of(FrenzyBoar::new, MobCategory.MONSTER)
                            .sized(0.9f, 0.9f)
                            .build("frenzy_boar"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
