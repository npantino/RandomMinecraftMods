package net.pyharm.tutorialmod.entities.projectiles;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.pyharm.tutorialmod.item.ModItems;

public class Grenade extends Snowball {
    private final Item referenceItem;
    public Grenade(EntityType<? extends Snowball> entityType, Level level) {
        super(entityType, level);
        this.referenceItem = ModItems.GRENADE.get();
    }

    public Grenade(LivingEntity shooter, Level level, Item referenceItem) {
        super(level, shooter);
        this.referenceItem = referenceItem;
    }

    @Override
    protected void onHitEntity(EntityHitResult hit) {
        super.onHitEntity(hit);

        this.level.explode(this, this.getX(), this.getY(), this.getZ(), 2.2f, true, Explosion.BlockInteraction.BREAK);
    }

    @Override
    protected void onHit(HitResult hit) {
        super.onHit(hit);
        this.level.explode(this, this.getX(), this.getY(), this.getZ(), 1.0f, true, Explosion.BlockInteraction.BREAK);
    }
}
