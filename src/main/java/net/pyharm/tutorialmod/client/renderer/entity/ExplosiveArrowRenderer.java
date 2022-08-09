package net.pyharm.tutorialmod.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pyharm.tutorialmod.TutorialMod;
import net.pyharm.tutorialmod.entities.projectiles.ExplosiveArrow;

@OnlyIn(Dist.CLIENT)
public class ExplosiveArrowRenderer extends ArrowRenderer<ExplosiveArrow> {
    public ExplosiveArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ExplosiveArrow entity) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/item/explosive_arrow.png");
    }
}
