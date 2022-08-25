package net.pyharm.tutorialmod.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pyharm.tutorialmod.TutorialMod;
import net.pyharm.tutorialmod.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> JADE_INGOT = ITEMS.register("jade_ingot",
            () -> new Item(new Item.Properties().fireResistant().tab(ModCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> JADE_SWORD = ITEMS.register("jade_sword",
            () -> new SwordItem(ModTiers.JADE, 4, 1f,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> HEAVENLY_INGOT = ITEMS.register("heavenly_ingot",
            () -> new Item(new Item.Properties().fireResistant().tab(ModCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> HEAVENLY_SWORD = ITEMS.register("heavenly_sword",
            () -> new HeavenlySwordItem(ModTiers.HEAVENLY, 26, 3f,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> HEAVENLY_HELMET = ITEMS.register("heavenly_helmet",
            () -> new HeavenlyArmorItem(ModArmorMaterials.HEAVENLY, EquipmentSlot.HEAD,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> HEAVENLY_CHESTPLATE = ITEMS.register("heavenly_chestplate",
            () -> new HeavenlyArmorItem(ModArmorMaterials.HEAVENLY, EquipmentSlot.CHEST,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> HEAVENLY_LEGGINGS = ITEMS.register("heavenly_leggings",
            () -> new HeavenlyArmorItem(ModArmorMaterials.HEAVENLY, EquipmentSlot.LEGS,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> HEAVENLY_BOOTS = ITEMS.register("heavenly_boots",
            () -> new HeavenlyArmorItem(ModArmorMaterials.HEAVENLY, EquipmentSlot.FEET,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.TUTORIAL_TAB)));


    public static final RegistryObject<Item> SPEED_SWORD = ITEMS.register("speed_sword",
            () -> new SpeedSwordItem(Tiers.DIAMOND, 4, 1f,
                    new Item.Properties().tab(ModCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> EXPLOSIVE_ARROW = ITEMS.register("explosive_arrow", () ->
            new ExplosiveArrowItem(new Item.Properties().tab(ModCreativeModTab.TUTORIAL_TAB), 1F));

    public static final RegistryObject<Item> ANCIENT_BOW = ITEMS.register("ancient_bow",
            () -> new AncientBowItem(new Item.Properties().tab(ModCreativeModTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> DICE = ITEMS.register("dice",
            () -> new DiceItem(new Item.Properties().tab(ModCreativeModTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> TELEPORT = ITEMS.register("teleport",
            () -> new TeleportItem(new Item.Properties().tab(ModCreativeModTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> GRENADE = ITEMS.register("grenade",
            () -> new GrenadeItem(new Item.Properties().tab(ModCreativeModTab.TUTORIAL_TAB).stacksTo(16)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
