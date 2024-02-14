package com.withtutorial.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

import com.withtutorial.MujiMod;

public class ModuleBase {

    private int key;
    private boolean enabled;

    protected MinecraftClient minecraftClient;
    protected PlayerEntity playerInstance;
    private boolean init = false;

    public void doInit() {
        this.minecraftClient = MinecraftClient.getInstance();
        this.playerInstance = this.minecraftClient.player;

        if (this.playerInstance == null) {
            this.init = false;
        }
        else {
            this.init = true;
        }

    }

    public boolean isInit() {return this.init;}

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if (enabled) {
            onEnabled();
        }
        else {
            onDisabled();
        }
    }

    public void toggle() {
        this.enabled = !this.enabled;
        if (enabled) {
            onEnabled();
        }
        else {
            onDisabled();
        }
    }

    public void onEnabled() {

    }

    public void onDisabled() {

    }

    public void onTick()
    {

    }
}
