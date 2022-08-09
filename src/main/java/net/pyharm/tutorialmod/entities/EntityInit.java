package net.pyharm.tutorialmod.entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pyharm.tutorialmod.TutorialMod;
import net.pyharm.tutorialmod.entities.projectiles.ExplosiveArrow;


public class EntityInit {
    public static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<ExplosiveArrow>> EXPLOSIVE_ARROW =
            ENTITIES.register("explosive_arrow", () ->
                    EntityType.Builder.<ExplosiveArrow>of(ExplosiveArrow::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(TutorialMod.MOD_ID, "explosive_arrow").toString()));

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
