package com.withtutorial.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class ModuleBase {

    private String name;
    private int key;
    private boolean enabled;

    protected MinecraftClient minecraftClient;
    protected PlayerEntity playerInstance;


    public ModuleBase(String _name)
    {
        this.name = _name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
