package net.diabelov.arcanemod.block;

import net.diabelov.arcanemod.ArcaneMod;
import net.diabelov.arcanemod.item.Moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArcaneMod.MOD_ID);

    public static final RegistryObject<Block> HEXITE_BLOCK = registerBlock("hexite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> GALSITE_ORE = registerBlock("galsite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(1, 5)));

    public static final RegistryObject<Block> DEEPSLATE_GALSITE_ORE = registerBlock("deepslate_galsite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4f).
                    requiresCorrectToolForDrops(), UniformInt.of(1, 5)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

        private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
            return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
