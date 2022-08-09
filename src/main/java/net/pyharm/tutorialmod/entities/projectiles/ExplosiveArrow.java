package net.pyharm.tutorialmod.entities.projectiles;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.pyharm.tutorialmod.entities.EntityInit;
import net.pyharm.tutorialmod.item.ModItems;

public class ExplosiveArrow extends AbstractArrow {
    private final Item referenceItem;
    private int life;
    public ExplosiveArrow(EntityType<ExplosiveArrow> entityType, Level level) {
        super(entityType, level);
        this.setCritArrow(true);
        this.referenceItem = ModItems.EXPLOSIVE_ARROW.get();
    }

    public ExplosiveArrow(LivingEntity shooter, Level level, Item referenceItem) {
        super(EntityInit.EXPLOSIVE_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
    }


    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }

    @Override
    protected void onHitEntity(EntityHitResult hit) {
        super.onHitEntity(hit);
        this.level.explode(this, this.getX(), this.getY(), this.getZ(), 4.0f, true, Explosion.BlockInteraction.BREAK);
    }

    @Override
    protected void onHitBlock(BlockHitResult hit) {
        super.onHitBlock(hit);
        this.level.explode(this, this.getX(), this.getY(), this.getZ(), 4.0f, true, Explosion.BlockInteraction.BREAK);
    }
}
