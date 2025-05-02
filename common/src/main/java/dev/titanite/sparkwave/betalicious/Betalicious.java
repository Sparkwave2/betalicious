package dev.titanite.sparkwave.betalicious;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public final class Betalicious {
    public static final String MOD_ID = "betalicious";

    //Define the logger:
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> TIME_MACHINE = ITEMS.register("time_machine", () ->
            new Item(new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<CreativeModeTab> BETALICIOUS_TAB = TABS.register("betalicious_tab", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + MOD_ID + ".betalicious_tab"),
                    () -> new ItemStack(Betalicious.TIME_MACHINE.get())));

    public static final RegistrySupplier<Block> BETA_STONE = BLOCKS.register("beta_stone", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final RegistrySupplier<BlockItem> BETA_STONE_ITEM = ITEMS.register("beta_stone", () ->
            new BlockItem(BETA_STONE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_COBBLESTONE = BLOCKS.register("beta_cobblestone", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final RegistrySupplier<BlockItem> BETA_COBBLESTONE_ITEM = ITEMS.register("beta_cobblestone", () ->
            new BlockItem(BETA_COBBLESTONE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_IRON_BLOCK = BLOCKS.register("beta_iron_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistrySupplier<BlockItem> BETA_IRON_BLOCK_ITEM = ITEMS.register("beta_iron_block", () ->
            new BlockItem(BETA_IRON_BLOCK.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_GOLD_BLOCK = BLOCKS.register("beta_gold_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final RegistrySupplier<BlockItem> BETA_GOLD_BLOCK_ITEM = ITEMS.register("beta_gold_block", () ->
            new BlockItem(BETA_GOLD_BLOCK.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_DIAMOND_BLOCK = BLOCKS.register("beta_diamond_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final RegistrySupplier<BlockItem> BETA_DIAMOND_BLOCK_ITEM = ITEMS.register("beta_diamond_block", () ->
            new BlockItem(BETA_DIAMOND_BLOCK.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static void init() {
        //Write a message with the logger:
        LOGGER.info("Initializing Betalicious...");
        BLOCKS.register();
        TABS.register();
        ITEMS.register();
        LOGGER.info("Initialization successful!");
    }
}
