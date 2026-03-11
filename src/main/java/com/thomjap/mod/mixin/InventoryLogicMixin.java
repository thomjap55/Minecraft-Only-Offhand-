package com.tonnom.mod.mixin;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerInventory.class)
public class InventoryLogicMixin {
    @Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
    private void restrictSlots(int slot, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        boolean isAllowed = (slot >= 36 && slot <= 40);
        if (!isAllowed) {
            cir.setReturnValue(false);
        }
    }
}