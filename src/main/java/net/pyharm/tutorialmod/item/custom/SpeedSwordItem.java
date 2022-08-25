package net.pyharm.tutorialmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class SpeedSwordItem extends SwordItem {
    public SpeedSwordItem(Tier tier, int addDmg, float speed, Properties properties) {
        super(tier, addDmg, speed, properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            Vec3 finalPos = getEndVec(player, 8);
            player.setDeltaMovement(finalPos);
            player.resetFallDistance();
            player.getCooldowns().addCooldown(this, 3);
        }
        return super.use(level, player, hand);
    }

    private Vec3 getEndVec(Player player, double reach) {
        Vec3 headVec = player.getEyePosition();
        Vec3 lookVec = player.getLookAngle();
        return headVec.add(lookVec.x * reach, lookVec.y * reach, lookVec.z * reach);
    }
}
