package net.pyharm.tutorialmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {

    public static final ForgeTier JADE = new ForgeTier(3, 1200, 8f, 3.5f,
            22, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.JADE_INGOT.get()));

}
