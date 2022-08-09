package net.pyharm.tutorialmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class TeleportItem extends Item {
    public TeleportItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            Vec3 finalPos = getEndVec(player, 8);
            player.teleportTo(finalPos.x, finalPos.y, finalPos.z);
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
