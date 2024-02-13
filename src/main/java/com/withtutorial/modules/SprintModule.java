package com.withtutorial.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

import com.withtutorial.modules.ModuleBase;

public class SprintModule extends ModuleBase{


    public SprintModule(String _name) {
        super(_name);

        this.minecraftClient = MinecraftClient.getInstance();
        this.playerInstance = this.minecraftClient.player;
    }

    @Override
    public void onTick()
    {
        if (isEnabled() && !playerInstance.isSprinting())
        {
            playerInstance.setSprinting(true);
        }
    }
}
