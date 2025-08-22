package net.dedog103.tieredshafts.block;

import net.dedog103.tieredshafts.TieredShafts;
import net.dedog103.tieredshafts.block.custom.SoundBlock;
import net.dedog103.tieredshafts.item.ModItems;
import com.simibubi.create.AllBlocks;
import net.minecraft.sounds.SoundEvents;
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

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TieredShafts.MODID);

    public static final RegistryObject<Block> DOGE_BLOCK = registerBlock("doge_block",
        ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(new SoundType(1.0F, 1.0F, SoundEvents.WOLF_DEATH, SoundEvents.WOLF_WHINE, SoundEvents.WOLF_HOWL, SoundEvents.WOLF_HURT, SoundEvents.WOLF_WHINE))));

    public static final RegistryObject<Block> DOGE_ORE = registerBlock("doge_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .sound(new SoundType(1.0F, 1.0F, SoundEvents.WOLF_DEATH, SoundEvents.WOLF_WHINE, SoundEvents.WOLF_HOWL, SoundEvents.WOLF_HURT, SoundEvents.WOLF_WHINE))
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            ()-> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
