package com.buuz135.repeatabletrialvaults.mixin;

import com.buuz135.repeatabletrialvaults.Constants;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.VaultBlock;
import net.minecraft.world.level.block.entity.vault.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VaultBlock.class)
public class MixinVaultBlock {


    @Inject(at = @At("HEAD"), method = "useItemOn", cancellable = true)
    private void useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult, CallbackInfoReturnable<ItemInteractionResult> cir) {
        if (level instanceof ServerLevel && level.getBlockEntity(pos) instanceof VaultBlockEntity vaultblockentity) {
            if (stack.is(Constants.CAN_RESET_TRIAL_VAULTS) && vaultblockentity.getServerData().hasRewardedPlayer(player)){
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                stack.consume(vaultblockentity.getConfig().keyItem().getCount(), player);
                vaultblockentity.getServerData().rewardedPlayers.remove(player.getUUID());
                vaultblockentity.getServerData().markChanged();
                cir.setReturnValue(ItemInteractionResult.SUCCESS);
            }
        }
    }

}
