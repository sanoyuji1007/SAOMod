package com.github.sanoyuji1007.SAOMod.event;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.item.SaoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaoMod.MOD_ID)
public class SaoModOnPlayerTick {

    // ■ 寝たとき（フラグセット）
    @SubscribeEvent
    public static void onSleep(PlayerSleepInBedEvent event) {
        Player player = event.getEntity();

        if (player.level().isClientSide) return;

        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        if (helmet.getItem() == SaoModItems.NERVE_GEAR.get()) {
            player.getPersistentData().putInt("sao_delay", 40); // 1秒
        }
    }

    // ■ tickで遅延処理
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;

        if (player.level().isClientSide) return;

        int delay = player.getPersistentData().getInt("sao_delay");

        if (delay > 0) {
            player.getPersistentData().putInt("sao_delay", delay - 1);
        }

        // ■ 0になった瞬間にTP
        if (delay == 1) {

            ServerPlayer serverPlayer = (ServerPlayer) player;
            MinecraftServer server = serverPlayer.server;

            ServerLevel targetLevel = server.getLevel(
                    ResourceKey.create(Registries.DIMENSION,
                            ResourceLocation.fromNamespaceAndPath("saomod", "sao_world"))
            );

            if (targetLevel == null) return;

            // ① ディメンション移動
            serverPlayer.changeDimension(targetLevel);
            serverPlayer.teleportTo(targetLevel, 0.5, 150, 0.5, 0, 0);

            // ② 次tickで安全TP
            server.execute(() -> {
                BlockPos pos = targetLevel.getHeightmapPos(
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                        new BlockPos(0, 0, 0)
                );

                serverPlayer.teleportTo(
                        targetLevel,
                        pos.getX() + 0.5,
                        pos.getY(),
                        pos.getZ() + 0.5,
                        serverPlayer.getYRot(),
                        serverPlayer.getXRot()
                );
            });
        }
    }
}