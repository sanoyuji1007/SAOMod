package com.github.sanoyuji1007.SAOMod.entity.renderer;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.entity.custom.FrenzyBoar;
import com.github.sanoyuji1007.SAOMod.entity.model.FrenzyBoarModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FrenzyBoarRenderer extends MobRenderer<FrenzyBoar, FrenzyBoarModel<FrenzyBoar>> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(
                    SaoMod.MOD_ID,
                    "textures/entity/frenzy_boar.png"
            );

    public FrenzyBoarRenderer(EntityRendererProvider.Context context) {
        super(context,
                new FrenzyBoarModel<>(context.bakeLayer(FrenzyBoarModel.LAYER_LOCATION)),
                0.5f); // 影サイズ
    }

    @Override
    public ResourceLocation getTextureLocation(FrenzyBoar entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(FrenzyBoar entity, PoseStack poseStack, float partialTickTime) {
        // 必要ならサイズ調整（基本はそのままでOK）
        poseStack.scale(1.0f, 1.0f, 1.0f);
    }
}