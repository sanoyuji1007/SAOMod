package com.github.sanoyuji1007.SAOMod.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.projectile.Snowball;

public class CrystalliteItem extends Item {

    private final CrystalType type;

    public CrystalliteItem(Properties properties, CrystalType type) {
        super(properties);
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // 効果発動
        switch (type) {
            case HEAL -> heal(player);
            case FIRE -> castFire(world, player);
            case ICE -> castIce(world, player);
            case THUNDER -> castThunder(world, player);
            case SPEED -> player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
            case JUMP -> player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 2));
            case INVISIBLE -> player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0));
            case EXPLOSION -> castExplosion(world, player);
        }

        // 音
        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.PLAYERS, 1.5F, 1.5F);

        // 消費
        if (!player.isCreative()) stack.shrink(1);

        // クールダウン
        player.getCooldowns().addCooldown(this, 20);

        return InteractionResultHolder.success(stack);
    }

    // -------------------------
    // 効果メソッド
    // -------------------------

    private void heal(Player player) {
        player.heal(6.0F);
    }

    private void castFire(Level world, Player player) {
        if (!world.isClientSide) {
            LargeFireball fireball = new LargeFireball(world, player, 0, 0, 0, 2); // 威力2.0
            fireball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(fireball);
        }
    }



//    private void castIce(Level world, Player player) {
//        if (!world.isClientSide) {
//
//            Snowball snowball = new Snowball(world, player);
//
//            // プレイヤーの向きベクトルを取得
//            var look = player.getLookAngle();
//
//            // 発射（速度 1.5、精度 1.0）
//            snowball.shoot(look.x, look.y, look.z, 1.5F, 1.0F);
//
//            world.addFreshEntity(snowball);
//        }
//    }



    private void castThunder(Level world, Player player) {
        if (!world.isClientSide) {
            // 10m先の座標
            var look = player.getLookAngle().scale(10);
            double x = player.getX() + look.x;
            double y = player.getY() + look.y;
            double z = player.getZ() + look.z;

            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
            bolt.moveTo(x, y, z);
            world.addFreshEntity(bolt);
        }
    }

    private void castExplosion(Level world, Player player) {
        if (!world.isClientSide) {
            var look = player.getLookAngle().scale(10);
            double x = player.getX() + look.x;
            double y = player.getY() + look.y;
            double z = player.getZ() + look.z;

            world.explode(null, x, y, z, 5.0F, Level.ExplosionInteraction.TNT);
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
