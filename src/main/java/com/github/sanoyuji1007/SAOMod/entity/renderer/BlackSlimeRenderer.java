package com.github.sanoyuji1007.SAOMod.entity.renderer;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.entity.custom.BlackSlime;
import com.github.sanoyuji1007.SAOMod.entity.model.BlackSlimeModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class BlackSlimeRenderer extends MobRenderer <BlackSlime, BlackSlimeModel<BlackSlime>> {
    private static final ResourceLocation BLACK_SLIME_LOCATION =
            ResourceLocation.fromNamespaceAndPath(
                    SaoMod.MOD_ID,
                    "textures/entity/black_slime.png"
            );

    public BlackSlimeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,
                new BlackSlimeModel<>(pContext.bakeLayer(BlackSlimeModel.LAYER_LOCATION)),
                0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(BlackSlime pEntity) {
        return null;
    }
}
