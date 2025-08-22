package net.dedog103.tieredshafts.item;

import net.dedog103.tieredshafts.TieredShafts;
import net.dedog103.tieredshafts.item.custom.FuelItem;
import net.dedog103.tieredshafts.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TieredShafts.MODID);

    public static final RegistryObject<Item> DOGE = ITEMS.register("doge",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> PINECONE = ITEMS.register("pinecone",
            () -> new FuelItem(new Item.Properties().food(ModFoods.PINECONE), 400));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
