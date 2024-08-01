package net.diabelov.arcanemod.item;

import net.diabelov.arcanemod.ArcaneMod;
import net.diabelov.arcanemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArcaneMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ARCANE_TAB = CREATIVE_MODE_TABS.register("arcane_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.hexite_crystal.get()))
                    .title(Component.translatable("creativetab.arcane_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.hexite_crystal.get());
                        output.accept(Moditems.galsite.get());
                        output.accept(ModBlocks.HEXITE_BLOCK.get());
                        output.accept(ModBlocks.GALSITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_GALSITE_ORE.get());
                        output.accept(Moditems.galsite_detector.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
