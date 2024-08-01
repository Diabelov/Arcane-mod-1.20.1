package net.diabelov.arcanemod.item;

import net.diabelov.arcanemod.ArcaneMod;
import net.diabelov.arcanemod.item.custom.GalsiteDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArcaneMod.MOD_ID);

    public static final RegistryObject<Item> hexite_crystal = ITEMS.register("hexite_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> galsite = ITEMS.register("galsite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> galsite_detector = ITEMS.register("galsite_detector",
            () -> new GalsiteDetectorItem(new Item.Properties().durability(25)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
