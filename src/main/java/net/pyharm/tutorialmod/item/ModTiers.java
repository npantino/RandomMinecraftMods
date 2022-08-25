package net.pyharm.tutorialmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {

    public static final ForgeTier JADE = new ForgeTier(3, 1200, 6f, 3.5f,
            22, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.JADE_INGOT.get()));

    public static final ForgeTier HEAVENLY = new ForgeTier(4, 2500, 5f, 4f,
            30, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.HEAVENLY_INGOT.get()));

}
