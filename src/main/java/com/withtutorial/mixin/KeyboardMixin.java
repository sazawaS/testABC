package com.withtutorial.mixin;

import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.withtutorial.MujiMod;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(at = @At("HEAD"), method = "onKey")
    public void _onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci)
    {
        MujiMod.INSTANCE.onKey(key, action);
    }
}
