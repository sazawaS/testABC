package com.withtutorial.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.item.ItemStack;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.withtutorial.MujiMod;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin
{
    @Inject(at = @At("HEAD"), method = "renderEntity", cancellable = true)
    public void renderEntity(Entity entity, double tf, double tf1, double tf2, float tf3, MatrixStack matrixStack,
                          VertexConsumerProvider vertexConsumerProvider, CallbackInfo ci)
    {
        if (entity instanceof PlayerEntity || entity instanceof RaiderEntity) {
            if (MinecraftClient.getInstance().player == null) {return;}
            if (entity == MinecraftClient.getInstance().player) {return;}
            ItemStack handItems = MinecraftClient.getInstance().player.getMainHandStack();

            double X = entity.getX();
            double Y = entity.getY();
            double Z = entity.getZ();

            Box defaultBox = new Box(X-0.3F, Y, Z-0.3F, X+0.3F,Y+entity.getHeight(), Z +0.3F);

            if (MujiMod.hitboxModule.isEnabled() && handItems.getItem().isDamageable())
            {
                //Increase size
                double size = MujiMod.hitboxModule.getSize();

                entity.setBoundingBox(new Box(
                        defaultBox.minX - size,
                        defaultBox.minY,
                        defaultBox.minZ - size,
                        defaultBox.maxX + size,
                        defaultBox.maxY,
                        defaultBox.maxZ + size
                ));
            }
            else {entity.setBoundingBox(defaultBox);}

        }
    }
}
