package net.pyharm.tutorialmod.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pyharm.tutorialmod.TutorialMod;
import net.pyharm.tutorialmod.entities.projectiles.Grenade;

@OnlyIn(Dist.CLIENT)
public class GrenadeRenderer extends EntityRenderer<Grenade> {
    public GrenadeRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Grenade grenade) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/item/grenade.png");
    }
}
