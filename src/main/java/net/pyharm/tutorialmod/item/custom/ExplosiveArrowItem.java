package net.pyharm.tutorialmod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.pyharm.tutorialmod.entities.projectiles.ExplosiveArrow;
import net.pyharm.tutorialmod.item.ModItems;

public class ExplosiveArrowItem extends ArrowItem {
    public final float damage;

    public ExplosiveArrowItem(Properties properties, float damage) {
        super(properties);
        this.damage = damage;
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
        ExplosiveArrow arrow = new ExplosiveArrow(shooter, level, ModItems.EXPLOSIVE_ARROW.get());
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
        int enchant = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false: this.getClass() == ExplosiveArrowItem.class;
    }
}
