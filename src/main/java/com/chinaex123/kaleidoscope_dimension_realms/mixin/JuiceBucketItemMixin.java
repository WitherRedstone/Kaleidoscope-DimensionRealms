package com.chinaex123.kaleidoscope_dimension_realms.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.item.JuiceBucketItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(JuiceBucketItem.class)
public abstract class JuiceBucketItemMixin extends BucketItem {

    public JuiceBucketItemMixin(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Inject(method = "use", at = @At("HEAD"), cancellable = true, remap = false, require = 1)
    private void kaleidoscope$injectPlaceFluid(Level level, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        if (!player.isShiftKeyDown()) {
            return;
        }

        cir.setReturnValue(super.use(level, player, hand));
    }
}