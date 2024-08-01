package net.diabelov.arcanemod.datagen.loot;

import net.diabelov.arcanemod.block.ModBlocks;
import net.diabelov.arcanemod.item.Moditems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.HEXITE_BLOCK.get());

        this.add(ModBlocks.GALSITE_ORE.get(),
                block -> createOreDrop(ModBlocks.GALSITE_ORE.get(), Moditems.galsite.get()));

        this.add(ModBlocks.DEEPSLATE_GALSITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_GALSITE_ORE.get(), Moditems.galsite.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
