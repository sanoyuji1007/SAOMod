package com.github.sanoyuji1007.SAOMod.entity.renderer;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.entity.custom.BlackSlime;
import com.github.sanoyuji1007.SAOMod.entity.model.BlackSlimeModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Slime;
import org.jetbrains.annotations.Nullable;

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

    public void render(BlackSlime pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.shadowRadius = 0.25F * (float)pEntity.getSize();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    protected void scale(BlackSlime pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        float f = 0.999F;
        pPoseStack.scale(0.999F, 0.999F, 0.999F);
        pPoseStack.translate(0.0F, 0.001F, 0.0F);
        float f1 = (float)pLivingEntity.getSize();
        float f2 = Mth.lerp(pPartialTickTime, pLivingEntity.oSquish, pLivingEntity.squish) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        pPoseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Override
    protected @Nullable RenderType getRenderType(BlackSlime pLivingEntity, boolean pBodyVisible, boolean pTranslucent, boolean pGlowing) {
        ResourceLocation resourceLocation=
                this.getTextureLocation(pLivingEntity);
        return RenderType.entityTranslucent(resourceLocation, true);
    }

    @Override
    public ResourceLocation getTextureLocation(BlackSlime pEntity) {
        return BLACK_SLIME_LOCATION;
    }
}
