package net.diabelov.arcanemod.datagen;

import net.diabelov.arcanemod.ArcaneMod;
import net.diabelov.arcanemod.block.ModBlocks;
import net.diabelov.arcanemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ArcaneMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.GALSITE_DETECTOR)
                .add(ModBlocks.GALSITE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GALSITE_ORE.get(),
                        ModBlocks.HEXITE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_GALSITE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GALSITE_ORE.get(),
                        ModBlocks.HEXITE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_GALSITE_ORE.get());


        this.tag(BlockTags.NEEDS_STONE_TOOL);
        // .add(ModBlocks.NAZWA.get());
    }
}
