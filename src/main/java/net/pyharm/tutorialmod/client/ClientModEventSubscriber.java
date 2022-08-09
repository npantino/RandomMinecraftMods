package net.pyharm.tutorialmod.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pyharm.tutorialmod.TutorialMod;
import net.pyharm.tutorialmod.client.renderer.entity.ExplosiveArrowRenderer;
import net.pyharm.tutorialmod.entities.EntityInit;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.EXPLOSIVE_ARROW.get(), ExplosiveArrowRenderer::new);
    }
}
