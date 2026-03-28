package com.github.sanoyuji1007.SAOMod.datagen.server.loot;

import com.github.sanoyuji1007.SAOMod.entity.SaoModEntities;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SlimePredicate;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

import static net.minecraft.world.level.storage.loot.LootPool.lootPool;

public class CustomEntityLootProvider extends EntityLootSubProvider {
    protected CustomEntityLootProvider() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        // ブラックスライムにアイテムドロップを追加
        this.add(SaoModEntities.BLACK_SLIME.get(), LootTable.lootTable().withPool(
                lootPool().setRolls(ConstantValue.exactly(1.0f))
                        // 羊毛をドロップ
                        .add(LootItem.lootTableItem(Items.ENDER_PEARL)
                                // １～３個ドロップ
                                .apply(SetItemCountFunction.setCount(
                                        UniformGenerator.between(1.0f, 3.0f)
                                ))
                                // ドロップ増加エンチャント付きの場合、レベルごとにドロップが１増える
                                .apply(LootingEnchantFunction.lootingMultiplier(
                                        UniformGenerator.between(0.0f, 1.0f))))
                        // ブラックスライムの大きさが最小の場合のみ、アイテムをドロップする
                        .when(LootItemEntityPropertyCondition.hasProperties(
                                LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.entity().subPredicate(
                                        SlimePredicate.sized(MinMaxBounds.Ints.exactly(1)))))));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return SaoModEntities.ENTITY_TYPES.getEntries()
                .stream().map(RegistryObject::get);
    }
}
