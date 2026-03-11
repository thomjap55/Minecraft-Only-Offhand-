package com.tonnom.mod.mixin;

import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public class InventoryScreenMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private void hideUselessSlots(CallbackInfo ci) {
        InventoryScreen screen = (InventoryScreen)(Object)this;
        for (Slot slot : screen.getScreenHandler().slots) {
            boolean isArmor = (slot.id >= 5 && slot.id <= 8);
            boolean isOffhand = (slot.id == 45);
            if (!isArmor && !isOffhand) {
                slot.x = -5000;
            }
        }
    }
}