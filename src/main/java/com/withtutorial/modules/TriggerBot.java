package com.withtutorial.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.EntityHitResult;

import com.withtutorial.MujiMod;


public class TriggerBot extends ModuleBase
{
    public boolean isREnabled = false;

    @Override
    public void onTick()
    {
        if (this.isEnabled() && isREnabled)
        {
            HitResult ray = MinecraftClient.getInstance().crosshairTarget;

            // If the target is an Entity, attack it.
            if (ray != null && ray.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityResult = (EntityHitResult) ray;
                Entity ent = entityResult.getEntity();
                if (!(ent instanceof PlayerEntity || ent instanceof Monster))
                    return;

                if (MinecraftClient.getInstance().player.getAttackCooldownProgress(0) == 1) {

                    if (!minecraftClient.getInstance().player.isUsingItem())
                    {
                        assert MinecraftClient.getInstance().interactionManager != null;
                        MinecraftClient.getInstance().interactionManager.attackEntity(MinecraftClient.getInstance().player, entityResult.getEntity());
                        assert MinecraftClient.getInstance().player != null;
                        MinecraftClient.getInstance().player.swingHand(Hand.MAIN_HAND);
                    }

                }
            }
        }

    }
}
