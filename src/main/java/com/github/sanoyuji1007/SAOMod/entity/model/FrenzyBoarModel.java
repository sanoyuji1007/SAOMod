package com.github.sanoyuji1007.SAOMod.entity.model;// Made with Blockbench 5.1.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class FrenzyBoarModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(
                    ResourceLocation.fromNamespaceAndPath(SaoMod.MOD_ID, "frenzy_boar_layer"),
                    "main"
            );
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart right_ear;
    private final ModelPart left_ear;
    private final ModelPart leg_back_right;
    private final ModelPart leg_back_left;
    private final ModelPart leg_front_right;
    private final ModelPart leg_front_left;

    public FrenzyBoarModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.right_ear = this.head.getChild("right_ear");
        this.left_ear = this.head.getChild("left_ear");
        this.leg_back_right = root.getChild("leg_back_right");
        this.leg_back_left = root.getChild("leg_back_left");
        this.leg_front_right = root.getChild("leg_front_right");
        this.leg_front_left = root.getChild("leg_front_left");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(1, 1).addBox(-8.0F, -6.0F, -4.0F, 16.0F, 14.0F, 26.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 5.0F, -3.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(61, 1).addBox(-7.0F, -5.0F, -19.0F, 14.0F, 6.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(-8.0F, -11.0F, -14.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(6.0F, -11.0F, -14.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -2.0F, 0.8727F, 0.0F, 0.0F));

        PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(1, 1).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -5.0F, -2.0F, 0.0F, 0.0F, -0.8727F));

        PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(1, 6).addBox(0.0F, 0.0F, -3.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -5.0F, -2.0F, 0.0F, 0.0F, 0.8727F));

        PartDefinition leg_back_right = partdefinition.addOrReplaceChild("leg_back_right", CubeListBuilder.create().texOffs(21, 45).addBox(-14.0F, -3.0F, -4.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 16.0F, 17.0F));

        PartDefinition leg_back_left = partdefinition.addOrReplaceChild("leg_back_left", CubeListBuilder.create().texOffs(0, 45).addBox(9.0F, -3.0F, -4.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 16.0F, 17.0F));

        PartDefinition leg_front_right = partdefinition.addOrReplaceChild("leg_front_right", CubeListBuilder.create().texOffs(66, 42).addBox(-2.0F, -2.0F, -3.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 12.0F, -3.0F));

        PartDefinition leg_front_left = partdefinition.addOrReplaceChild("leg_front_left", CubeListBuilder.create().texOffs(41, 42).addBox(-4.0F, -2.0F, -3.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 12.0F, -3.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg_back_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg_back_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg_front_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg_front_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}