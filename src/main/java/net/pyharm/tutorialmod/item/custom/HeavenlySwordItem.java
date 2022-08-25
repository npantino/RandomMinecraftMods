package net.pyharm.tutorialmod.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class HeavenlySwordItem extends SwordItem {
    public HeavenlySwordItem(Tier tier, int addDmg, float addSpd, Properties properties) {
        super(tier, addDmg, addSpd, properties);
    }

    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity attacked, LivingEntity attacker) {
        p_43278_.hurtAndBreak(1, attacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        MobEffectInstance speed = new MobEffectInstance(MobEffect.byId(1), 300, 3, false,
                false, false);
        MobEffectInstance strength = new MobEffectInstance(MobEffect.byId(5), 300, 3, false,
                false, false);
        MobEffectInstance health = new MobEffectInstance(MobEffect.byId(6), 1, (int) (this.getDamage()/10), false,
                false, false);
        MobEffectInstance jumpBoost = new MobEffectInstance(MobEffect.byId(8), 300,3, false,
                false, false);
        MobEffectInstance resistance = new MobEffectInstance(MobEffect.byId(11), 300, 3, false,
                false, false);
        MobEffectInstance saturation = new MobEffectInstance(MobEffect.byId(23), 300, 1, false,
                false, false);


        MobEffectInstance slowness = new MobEffectInstance(MobEffect.byId(2), 300, 3, false,
                false, false);
        MobEffectInstance nausea = new MobEffectInstance(MobEffect.byId(9), 300, 1, false,
                false, false);
        MobEffectInstance hunger = new MobEffectInstance(MobEffect.byId(17), 300, 3, false,
                false, false);
        MobEffectInstance weakness = new MobEffectInstance(MobEffect.byId(18), 300, 3, false,
                false, false);
        MobEffectInstance wither = new MobEffectInstance(MobEffect.byId(20), 300, 3, false,
                false, false);
        MobEffectInstance glowing = new MobEffectInstance(MobEffect.byId(24), 300, 1, false,
                false, false);
        MobEffectInstance darkness = new MobEffectInstance(MobEffect.byId(33), 300, 1, false,
                false, false);

        attacker.addEffect(speed);
        attacker.addEffect(strength);
        attacker.addEffect(health);
        attacker.addEffect(jumpBoost);
        attacker.addEffect(resistance);

        attacked.addEffect(slowness);
        attacked.addEffect(nausea);
        attacked.addEffect(hunger);
        attacked.addEffect(weakness);
        attacked.addEffect(wither);
        attacked.addEffect(glowing);
        attacked.addEffect(darkness);
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            Vec3 finalPos = getEndVec(player, 8);
            player.teleportTo(finalPos.x, finalPos.y, finalPos.z);
            player.setInvulnerable(true);
            level.explode(player, player.getX(), player.getY(), player.getZ(),
                    3f, false, Explosion.BlockInteraction.NONE);
            player.setInvulnerable(false);
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
