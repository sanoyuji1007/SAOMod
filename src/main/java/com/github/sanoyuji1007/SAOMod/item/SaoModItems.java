package com.github.sanoyuji1007.SAOMod.item;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SaoModItems {
    //  レジストリを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SaoMod.MOD_ID);

    //  レジストリにアイテムを追加
    public static final RegistryObject<Item> RAW_ORIHALCON = ITEMS.register("raw_orihalcon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORIHALCON_INGOT = ITEMS.register("orihalcon_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELUCIDATOR= ITEMS.register("elucidator", () -> new Item(new Item.Properties()));

    //  結晶シリーズの登録
    public static final RegistryObject<Item> HEAL_CRYSTAL = ITEMS.register("heal_crystal", () -> new CrystalliteItem(new Item.Properties(), CrystalType.HEAL));

    public static final RegistryObject<Item> FIRE_CRYSTAL = ITEMS.register("fire_crystal", () -> new CrystalliteItem(new Item.Properties(), CrystalType.FIRE));

    public static final RegistryObject<Item> ICE_CRYSTAL = ITEMS.register("ice_crystal", () -> new CrystalliteItem(new Item.Properties(), CrystalType.ICE));

    public static final RegistryObject<Item> THUNDER_CRYSTAL = ITEMS.register("thunder_crystal", () -> new CrystalliteItem(new Item.Properties(), CrystalType.THUNDER));

    public static final RegistryObject<Item> SPEED_CRYSTAL = ITEMS.register("speed_crystal", () -> new CrystalliteItem(new Item.Properties(), CrystalType.SPEED));

    public static final RegistryObject<Item> JUMP_CRYSTAL = ITEMS.register("jump_crystal", () -> new CrystalliteItem(new Item.Properties(), CrystalType.JUMP));

    public static final RegistryObject<Item> INVISIBLE_CRYSTAL = ITEMS.register("invisible_crystal", () -> new CrystalliteItem(new Item.Properties(), CrystalType.INVISIBLE));

    public static final RegistryObject<Item> EXPLOSION_CRYSTAL = ITEMS.register("explosion_crystal", () -> new CrystalliteItem(new Item.Properties(), CrystalType.EXPLOSION));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
