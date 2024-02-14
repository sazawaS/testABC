package com.withtutorial.modules;

import com.withtutorial.MujiMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

import com.withtutorial.modules.ModuleBase;

public class SprintModule extends ModuleBase{

    @Override
    public void onTick()
    {
        if (!isInit())
        {
            doInit();
        }
        if (isInit() && this.isEnabled() && !this.playerInstance.isSprinting())
        {
            this.playerInstance.setSprinting(true);
        }
    }
}
