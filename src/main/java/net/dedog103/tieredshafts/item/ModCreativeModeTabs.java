package net.dedog103.tieredshafts.item;

import net.dedog103.tieredshafts.TieredShafts;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TieredShafts.MODID);

    public static final RegistryObject<CreativeModeTab> TIERED_SHAFTS_TAB = CREATIVE_MODE_TABS.register("tiered_shafts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DOGE.get()))
                    .title(Component.translatable("creativetab.tiered_shafts_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DOGE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
