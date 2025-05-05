package dev.titanite.sparkwave.betalicious;

import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.advancements.critereon.FluidPredicate;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.material.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public final class Betalicious {
    // Mod ID
    public static final String MOD_ID = "betalicious";
    // Logger
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);




    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> TIME_MACHINE = ITEMS.register("time_machine", () ->
            new TimeMachine(new Item.Properties()
                    .arch$tab(Betalicious.BETALICIOUS_TAB)
                    .rarity(Rarity.RARE)
                    .stacksTo(1)
                    .durability(64)));

    public static final RegistrySupplier<CreativeModeTab> BETALICIOUS_TAB = TABS.register("betalicious_tab", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + MOD_ID + ".betalicious_tab"),
                    () -> new ItemStack(Betalicious.BETA_ROSE_ITEM.get())));

    public static final RegistrySupplier<Block> BETA_GRASS_BLOCK = BLOCKS.register("beta_grass_block", () ->
            new GrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final RegistrySupplier<BlockItem> BETA_GRASS_BLOCK_ITEM = ITEMS.register("beta_grass_block", () ->
            new BlockItem(BETA_GRASS_BLOCK.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_STONE = BLOCKS.register("beta_stone", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final RegistrySupplier<BlockItem> BETA_STONE_ITEM = ITEMS.register("beta_stone", () ->
            new BlockItem(BETA_STONE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_STONE_PRESSURE_PLATE = BLOCKS.register("beta_stone_pressure_plate", () ->
            new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE)));
    public static final RegistrySupplier<BlockItem> BETA_STONE_PRESSURE_PLATE_ITEM = ITEMS.register("beta_stone_pressure_plate", () ->
            new BlockItem(BETA_STONE_PRESSURE_PLATE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_PLANKS = BLOCKS.register("beta_planks", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<BlockItem> BETA_PLANKS_ITEM = ITEMS.register("beta_planks", () ->
            new BlockItem(BETA_PLANKS.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    /* Refuses to work, disregard for now
    public static final RegistrySupplier<Block> BETA_SIGN = BLOCKS.register("beta_sign", () ->
            new StandingSignBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final RegistrySupplier<Block> BETA_WALL_SIGN = BLOCKS.register("beta_wall_sign", () ->
            new WallSignBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final RegistrySupplier<BlockItem> BETA_SIGN_ITEM = ITEMS.register("beta_wall_sign", () ->
            new SignItem(new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB), BETA_SIGN.get(), BETA_WALL_SIGN.get()));
     */

    public static final RegistrySupplier<Block> BETA_WOODEN_STAIRS = BLOCKS.register("beta_wooden_stairs", () ->
            new StairBlock(BETA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final RegistrySupplier<BlockItem> BETA_WOODEN_STAIRS_ITEM = ITEMS.register("beta_wooden_stairs", () ->
            new BlockItem(BETA_WOODEN_STAIRS.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_WOODEN_PRESSURE_PLATE = BLOCKS.register("beta_wooden_pressure_plate", () ->
            new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistrySupplier<BlockItem> BETA_WOODEN_PRESSURE_PLATE_ITEM = ITEMS.register("beta_wooden_pressure_plate", () ->
            new BlockItem(BETA_WOODEN_PRESSURE_PLATE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_FENCE = BLOCKS.register("beta_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final RegistrySupplier<BlockItem> BETA_FENCE_ITEM = ITEMS.register("beta_fence", () ->
            new BlockItem(BETA_FENCE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_BRICKS = BLOCKS.register("beta_bricks", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final RegistrySupplier<BlockItem> BETA_BRICKS_ITEM = ITEMS.register("beta_bricks", () ->
            new BlockItem(BETA_BRICKS.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_TNT = BLOCKS.register("beta_tnt", () ->
            new TntBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TNT)));
    public static final RegistrySupplier<BlockItem> BETA_TNT_ITEM = ITEMS.register("beta_tnt", () ->
            new BlockItem(BETA_TNT.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_COBWEB = BLOCKS.register("beta_cobweb", () ->
            new WebBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBWEB)));
    public static final RegistrySupplier<BlockItem> BETA_COBWEB_ITEM = ITEMS.register("beta_cobweb", () ->
            new BlockItem(BETA_COBWEB.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_ROSE = BLOCKS.register("beta_rose", () ->
            new FlowerBlock(MobEffects.NIGHT_VISION, 5.0F, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));
    public static final RegistrySupplier<BlockItem> BETA_ROSE_ITEM = ITEMS.register("beta_rose", () ->
            new BlockItem(BETA_ROSE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_DANDELION = BLOCKS.register("beta_dandelion", () ->
            new FlowerBlock(MobEffects.SATURATION, 0.35F, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final RegistrySupplier<BlockItem> BETA_DANDELION_ITEM = ITEMS.register("beta_dandelion", () ->
            new BlockItem(BETA_DANDELION.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));


    public static final RegistrySupplier<Block> BETA_SAPLING = BLOCKS.register("beta_sapling", () ->
            new BetaSapling(TreeGrower.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final RegistrySupplier<BlockItem> BETA_SAPLING_ITEM = ITEMS.register("beta_sapling", () ->
            new BlockItem(BETA_SAPLING.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_COBBLESTONE = BLOCKS.register("beta_cobblestone", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final RegistrySupplier<BlockItem> BETA_COBBLESTONE_ITEM = ITEMS.register("beta_cobblestone", () ->
            new BlockItem(BETA_COBBLESTONE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_COBBLESTONE_STAIRS = BLOCKS.register("beta_cobblestone_stairs", () ->
            new StairBlock(BETA_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_STAIRS)));
    public static final RegistrySupplier<BlockItem> BETA_COBBLESTONE_STAIRS_ITEM = ITEMS.register("beta_cobblestone_stairs", () ->
            new BlockItem(BETA_COBBLESTONE_STAIRS.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_BEDROCK = BLOCKS.register("beta_bedrock", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK)));
    public static final RegistrySupplier<BlockItem> BETA_BEDROCK_ITEM = ITEMS.register("beta_bedrock", () ->
            new BlockItem(BETA_BEDROCK.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_SAND = BLOCKS.register("beta_sand", () ->
            new ColoredFallingBlock(new ColorRGBA(14406560), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)));
    public static final RegistrySupplier<BlockItem> BETA_SAND_ITEM = ITEMS.register("beta_sand", () ->
            new BlockItem(BETA_SAND.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_GRAVEL = BLOCKS.register("beta_gravel", () ->
            new ColoredFallingBlock(new ColorRGBA(-8356741), BlockBehaviour.Properties.ofFullCopy(Blocks.GRAVEL)));
    public static final RegistrySupplier<BlockItem> BETA_GRAVEL_ITEM = ITEMS.register("beta_gravel", () ->
            new BlockItem(BETA_GRAVEL.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_LOG = BLOCKS.register("beta_log", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistrySupplier<BlockItem> BETA_LOG_ITEM = ITEMS.register("beta_log", () ->
            new BlockItem(BETA_LOG.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

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

    public static final RegistrySupplier<Block> BETA_RED_MUSHROOM = BLOCKS.register("beta_red_mushroom", () ->
            new MushroomBlock(TreeFeatures.HUGE_RED_MUSHROOM, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)));
    public static final RegistrySupplier<BlockItem> BETA_RED_MUSHROOM_ITEM = ITEMS.register("beta_red_mushroom", () ->
            new BlockItem(BETA_RED_MUSHROOM.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_BROWN_MUSHROOM = BLOCKS.register("beta_brown_mushroom", () ->
            new MushroomBlock(TreeFeatures.HUGE_BROWN_MUSHROOM, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)));
    public static final RegistrySupplier<BlockItem> BETA_BROWN_MUSHROOM_ITEM = ITEMS.register("beta_brown_mushroom", () ->
            new BlockItem(BETA_BROWN_MUSHROOM.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_GOLD_ORE = BLOCKS.register("beta_gold_ore", () ->
            new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE)));
    public static final RegistrySupplier<BlockItem> BETA_GOLD_ORE_ITEM = ITEMS.register("beta_gold_ore", () ->
            new BlockItem(BETA_GOLD_ORE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_IRON_ORE = BLOCKS.register("beta_iron_ore", () ->
            new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final RegistrySupplier<BlockItem> BETA_IRON_ORE_ITEM = ITEMS.register("beta_iron_ore", () ->
            new BlockItem(BETA_IRON_ORE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_COAL_ORE = BLOCKS.register("beta_coal_ore", () ->
            new DropExperienceBlock(UniformInt.of(0, 2), BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE)));
    public static final RegistrySupplier<BlockItem> BETA_COAL_ORE_ITEM = ITEMS.register("beta_coal_ore", () ->
            new BlockItem(BETA_COAL_ORE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_BOOKSHELF = BLOCKS.register("beta_bookshelf", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF)));
    public static final RegistrySupplier<BlockItem> BETA_BOOKSHELF_ITEM = ITEMS.register("beta_bookshelf", () ->
            new BlockItem(BETA_BOOKSHELF.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_MOSSY_COBBLESTONE = BLOCKS.register("beta_mossy_cobblestone", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final RegistrySupplier<BlockItem> BETA_MOSSY_COBBLESTONE_ITEM = ITEMS.register("beta_mossy_cobblestone", () ->
            new BlockItem(BETA_MOSSY_COBBLESTONE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_OBSIDIAN = BLOCKS.register("beta_obsidian", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final RegistrySupplier<BlockItem> BETA_OBSIDIAN_ITEM = ITEMS.register("beta_obsidian", () ->
            new BlockItem(BETA_OBSIDIAN.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_CRAFTING_TABLE = BLOCKS.register("beta_crafting_table", () ->
            new BetaCraftingTable(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
    public static final RegistrySupplier<BlockItem> BETA_CRAFTING_TABLE_ITEM = ITEMS.register("beta_crafting_table", () ->
            new BlockItem(BETA_CRAFTING_TABLE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    /*
    public static final RegistrySupplier<Block> BETA_FURNACE = BLOCKS.register("beta_furnace", () ->
            new FurnaceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE)));
    public static final RegistrySupplier<BlockItem> BETA_FURNACE_ITEM = ITEMS.register("beta_furnace", () ->
            new BlockItem(BETA_FURNACE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));
     */

    public static final RegistrySupplier<Block> BETA_SPONGE = BLOCKS.register("beta_sponge", () ->
            new BetaSponge(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE)));
    public static final RegistrySupplier<BlockItem> BETA_SPONGE_ITEM = ITEMS.register("beta_sponge", () ->
            new BlockItem(BETA_SPONGE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_GLASS = BLOCKS.register("beta_glass", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final RegistrySupplier<BlockItem> BETA_GLASS_ITEM = ITEMS.register("beta_glass", () ->
            new BlockItem(BETA_GLASS.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_DIAMOND_ORE = BLOCKS.register("beta_diamond_ore", () ->
            new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)));
    public static final RegistrySupplier<BlockItem> BETA_DIAMOND_ORE_ITEM = ITEMS.register("beta_diamond_ore", () ->
            new BlockItem(BETA_DIAMOND_ORE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_REDSTONE_ORE = BLOCKS.register("beta_redstone_ore", () ->
            new RedStoneOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_ORE)));
    public static final RegistrySupplier<BlockItem> BETA_REDSTONE_ORE_ITEM = ITEMS.register("beta_redstone_ore", () ->
            new BlockItem(BETA_REDSTONE_ORE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_LEAVES = BLOCKS.register("beta_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final RegistrySupplier<BlockItem> BETA_LEAVES_ITEM = ITEMS.register("beta_leaves", () ->
            new BlockItem(BETA_LEAVES.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_OPAQUE_LEAVES = BLOCKS.register("beta_opaque_leaves", () ->
            new OpaqueLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final RegistrySupplier<BlockItem> BETA_OPAQUE_LEAVES_ITEM = ITEMS.register("beta_opaque_leaves", () ->
            new BlockItem(BETA_OPAQUE_LEAVES.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_WOOL = BLOCKS.register("beta_wool", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).sound(SoundType.GRASS)));
    public static final RegistrySupplier<BlockItem> BETA_WOOL_ITEM = ITEMS.register("beta_wool", () ->
            new BlockItem(BETA_WOOL.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    /*
    public static final RegistrySupplier<Block> BETA_MOB_SPAWNER = BLOCKS.register("beta_mob_spawner", () ->
            new SpawnerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPAWNER)));
    public static final RegistrySupplier<BlockItem> BETA_MOB_SPAWNER_ITEM = ITEMS.register("beta_mob_spawner", () ->
            new BlockItem(BETA_MOB_SPAWNER.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

     */

    public static final RegistrySupplier<Block> BETA_SNOW = BLOCKS.register("beta_snow", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final RegistrySupplier<BlockItem> BETA_SNOW_ITEM = ITEMS.register("beta_snow", () ->
            new BlockItem(BETA_SNOW.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_SNOW_LAYER = BLOCKS.register("beta_snow_layer", () ->
            new SnowLayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW)));
    public static final RegistrySupplier<BlockItem> BETA_SNOW_LAYER_ITEM = ITEMS.register("beta_snow_layer", () ->
            new BlockItem(BETA_SNOW_LAYER.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_ICE = BLOCKS.register("beta_ice", () ->
            new IceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final RegistrySupplier<BlockItem> BETA_ICE_ITEM = ITEMS.register("beta_ice", () ->
            new BlockItem(BETA_ICE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_SNOWY_GRASS_BLOCK = BLOCKS.register("beta_snowy_grass_block", () ->
            new SnowyDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).sound(SoundType.SNOW)));
    public static final RegistrySupplier<BlockItem> BETA_SNOWY_GRASS_BLOCK_ITEM = ITEMS.register("beta_snowy_grass_block", () ->
            new BlockItem(BETA_SNOWY_GRASS_BLOCK.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_CACTUS = BLOCKS.register("beta_cactus", () ->
            new BetaCactus(BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS)));
    public static final RegistrySupplier<BlockItem> BETA_CACTUS_ITEM = ITEMS.register("beta_cactus", () ->
            new BlockItem(BETA_CACTUS.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_CLAY = BLOCKS.register("beta_clay", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final RegistrySupplier<BlockItem> BETA_CLAY_ITEM = ITEMS.register("beta_clay", () ->
            new BlockItem(BETA_CLAY.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_SUGAR_CANE = BLOCKS.register("beta_sugar_cane", () ->
            new SugarCaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SUGAR_CANE)));
    public static final RegistrySupplier<BlockItem> BETA_SUGAR_CANE_ITEM = ITEMS.register("beta_sugar_cane", () ->
            new BlockItem(BETA_SUGAR_CANE.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_NOTE_BLOCK = BLOCKS.register("beta_note_block", () ->
            new NoteBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NOTE_BLOCK)));
    public static final RegistrySupplier<BlockItem> BETA_NOTE_BLOCK_ITEM = ITEMS.register("beta_note_block", () ->
            new BlockItem(BETA_NOTE_BLOCK.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    /*
    public static final RegistrySupplier<Block> BETA_JUKEBOX = BLOCKS.register("beta_jukebox", () ->
            new JukeboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUKEBOX)));
    public static final RegistrySupplier<BlockItem> BETA_JUKEBOX_ITEM = ITEMS.register("beta_jukebox", () ->
            new BlockItem(BETA_JUKEBOX.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

     */

    public static final RegistrySupplier<Block> BETA_TORCH = BLOCKS.register("beta_torch", () ->
            new TorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH)));
    public static final RegistrySupplier<Block> BETA_WALL_TORCH = BLOCKS.register("beta_wall_torch", () ->
            new WallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH)));
    public static final RegistrySupplier<BlockItem> BETA_TORCH_ITEM = ITEMS.register("beta_torch", () ->
            new StandingAndWallBlockItem(BETA_TORCH.get(), BETA_WALL_TORCH.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB), Direction.DOWN));

    public static final RegistrySupplier<Block> BETA_REDSTONE_TORCH = BLOCKS.register("beta_redstone_torch", () ->
            new RedstoneTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_TORCH)));
    public static final RegistrySupplier<Block> BETA_REDSTONE_WALL_TORCH = BLOCKS.register("beta_redstone_wall_torch", () ->
            new RedstoneWallTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_TORCH)));
    public static final RegistrySupplier<BlockItem> BETA_REDSTONE_TORCH_ITEM = ITEMS.register("beta_redstone_torch", () ->
            new StandingAndWallBlockItem(BETA_REDSTONE_TORCH.get(), BETA_REDSTONE_WALL_TORCH.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB), Direction.DOWN));

    public static final RegistrySupplier<Block> BETA_WOODEN_DOOR = BLOCKS.register("beta_wooden_door", () ->
            new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final RegistrySupplier<BlockItem> BETA_WOODEN_DOOR_ITEM = ITEMS.register("beta_wooden_door", () ->
            new BlockItem(BETA_WOODEN_DOOR.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_IRON_DOOR = BLOCKS.register("beta_iron_door", () ->
            new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR)));
    public static final RegistrySupplier<BlockItem> BETA_IRON_DOOR_ITEM = ITEMS.register("beta_iron_door", () ->
            new BlockItem(BETA_IRON_DOOR.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_LEVER = BLOCKS.register("beta_lever", () ->
            new LeverBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LEVER)));
    public static final RegistrySupplier<BlockItem> BETA_LEVER_ITEM = ITEMS.register("beta_lever", () ->
            new BlockItem(BETA_LEVER.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_BUTTON = BLOCKS.register("beta_button", () ->
            new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final RegistrySupplier<BlockItem> BETA_BUTTON_ITEM = ITEMS.register("beta_button", () ->
            new BlockItem(BETA_BUTTON.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_LADDER = BLOCKS.register("beta_ladder", () ->
            new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final RegistrySupplier<BlockItem> BETA_LADDER_ITEM = ITEMS.register("beta_ladder", () ->
            new BlockItem(BETA_LADDER.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_WOODEN_SLAB = BLOCKS.register("beta_wooden_slab", () ->
            new PetrifiedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).sound(SoundType.STONE)));
    public static final RegistrySupplier<BlockItem> BETA_WOODEN_SLAB_ITEM = ITEMS.register("beta_wooden_slab", () ->
            new BlockItem(BETA_WOODEN_SLAB.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static final RegistrySupplier<Block> BETA_CRYING_OBSIDIAN = BLOCKS.register("beta_crying_obsidian", () ->
            new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final RegistrySupplier<BlockItem> BETA_CRYING_OBSIDIAN_ITEM = ITEMS.register("beta_crying_obsidian", () ->
            new BlockItem(BETA_CRYING_OBSIDIAN.get(), new Item.Properties().arch$tab(Betalicious.BETALICIOUS_TAB)));

    public static void init() {
        LOGGER.info("Initializing Betalicious...");
        /*
        ModConfig.init();
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        File full = new File("resources/terrain.png");
        File cobble = new File("resources/cobblestone.png");
        Image image;
        if((!full.exists() || !cobble.exists()) && !config.disableDownload) {
            LOGGER.info("Files missing, downloading...");
            try {
                URL url = new URL(config.imageLocation);
                image = ImageIO.read(url);
                try {
                    BufferedImage bufferedImage = new BufferedImage(256, 256, BufferedImage.TYPE_4BYTE_ABGR);
                    bufferedImage.getGraphics().drawImage(image, 0, 0, null);
                    ImageIO.write(bufferedImage, "png", new File("resources/terrain.png"));
                    if (config.disableSlicing) {
                        LOGGER.info("Slicing disabled in the config. Skipping...");
                    } else {

                    }
                    LOGGER.info("Atlas downloaded. Slicing...");
                    BufferedImage currentImg = cropImage(bufferedImage, new Rectangle(0, 0, 16, 16));
                    saveSlice(bufferedImage, 0, 0, "beta_grass_block_top.png");
                    saveSlice(bufferedImage, 1, 0, "beta_stone.png");
                    saveSlice(bufferedImage, 2, 0, "beta_dirt.png");
                    saveSlice(bufferedImage, 3, 0, "beta_grass_block_side.png");
                    saveSlice(bufferedImage, 4, 0, "beta_planks.png");
                    saveSlice(bufferedImage, 5, 0, "beta_stone_slab_side.png");
                    saveSlice(bufferedImage, 6, 0, "beta_stone_slab_top.png");
                    saveSlice(bufferedImage, 7, 0, "beta_bricks.png");
                    saveSlice(bufferedImage, 8, 0, "beta_tnt_side.png");
                    saveSlice(bufferedImage, 9, 0, "beta_tnt_top.png");
                    saveSlice(bufferedImage, 10, 0, "beta_tnt_bottom.png");
                    saveSlice(bufferedImage, 11, 0, "beta_cobweb.png");
                    saveSlice(bufferedImage, 12, 0, "beta_rose.png");
                    saveSlice(bufferedImage, 13, 0, "beta_dandelion.png");
                    saveSlice(bufferedImage, 15, 0, "beta_sapling.png");
                    saveSlice(bufferedImage, 0, 1, "beta_cobblestone.png");
                    saveSlice(bufferedImage, 1, 1, "beta_bedrock.png");
                    saveSlice(bufferedImage, 2, 1, "beta_sand.png");
                    saveSlice(bufferedImage, 3, 1, "beta_gravel.png");
                    saveSlice(bufferedImage, 4, 1, "beta_log_side.png");
                    saveSlice(bufferedImage, 5, 1, "beta_log_top.png");
                    saveSlice(bufferedImage, 6, 1, "beta_iron_block_top.png");
                    saveSlice(bufferedImage, 7, 1, "beta_gold_block_top.png");
                    saveSlice(bufferedImage, 8, 1, "beta_diamond_block_top.png");
                    saveSlice(bufferedImage, 9, 1, "beta_chest_top.png");
                    saveSlice(bufferedImage, 10, 1, "beta_chest_back.png");
                    saveSlice(bufferedImage, 11, 1, "beta_chest_front.png");
                    saveSlice(bufferedImage, 12, 1, "beta_red_mushroom.png");
                    saveSlice(bufferedImage, 13, 1, "beta_brown_mushroom.png");
                    saveSlice(bufferedImage, 0, 2, "beta_gold_ore.png");
                    saveSlice(bufferedImage, 1, 2, "beta_iron_ore.png");
                    saveSlice(bufferedImage, 2, 2, "beta_coal_ore.png");
                    saveSlice(bufferedImage, 3, 2, "beta_bookshelf.png");
                    saveSlice(bufferedImage, 4, 2, "beta_mossy_cobblestone.png");
                    saveSlice(bufferedImage, 5, 2, "beta_obsidian.png");
                    saveSlice(bufferedImage, 6, 2, "beta_iron_block_side.png");
                    saveSlice(bufferedImage, 7, 2, "beta_gold_block_side.png");
                    saveSlice(bufferedImage, 8, 2, "beta_diamond_block_side.png");
                    saveSlice(bufferedImage, 9, 2, "beta_chest_front_l.png");
                    saveSlice(bufferedImage, 10, 2, "beta_chest_front_r.png");
                    saveSlice(bufferedImage, 11, 2, "beta_crafting_table_top.png");
                    saveSlice(bufferedImage, 12, 2, "beta_furnace_front.png");
                    saveSlice(bufferedImage, 13, 2, "beta_furnace_side.png");
                    saveSlice(bufferedImage, 0, 3, "beta_sponge.png");
                    saveSlice(bufferedImage, 1, 3, "beta_glass.png");
                    saveSlice(bufferedImage, 2, 3, "beta_diamond_ore.png");
                    saveSlice(bufferedImage, 3, 3, "beta_redstone_ore.png");
                    saveSlice(bufferedImage, 4, 3, "beta_leaves.png");
                    saveSlice(bufferedImage, 5, 3, "beta_leaves_opaque.png");
                    saveSlice(bufferedImage, 6, 3, "beta_iron_block_bottom.png");
                    saveSlice(bufferedImage, 7, 3, "beta_gold_block_bottom.png");
                    saveSlice(bufferedImage, 8, 3, "beta_diamond_block_bottom.png");
                    saveSlice(bufferedImage, 9, 3, "beta_chest_back_l.png");
                    saveSlice(bufferedImage, 10, 3, "beta_chest_back_r.png");
                    saveSlice(bufferedImage, 11, 3, "beta_crafting_table_side.png");
                    saveSlice(bufferedImage, 12, 3, "beta_crafting_table_front.png");
                    saveSlice(bufferedImage, 13, 3, "beta_furnace_lit.png");
                    saveSlice(bufferedImage, 0, 4, "beta_wool.png");
                    saveSlice(bufferedImage, 1, 4, "beta_spawner.png");
                    saveSlice(bufferedImage, 2, 4, "beta_snow.png");
                    saveSlice(bufferedImage, 3, 4, "beta_ice.png");
                    saveSlice(bufferedImage, 4, 4, "beta_snowy_grass_side.png");
                    saveSlice(bufferedImage, 5, 4, "beta_cactus_top.png");
                    saveSlice(bufferedImage, 6, 4, "beta_cactus_side.png");
                    saveSlice(bufferedImage, 7, 4, "beta_cactus_bottom.png");
                    saveSlice(bufferedImage, 8, 4, "beta_clay.png");
                    saveSlice(bufferedImage, 9, 4, "beta_sugar_cane.png");
                    saveSlice(bufferedImage, 10, 4, "beta_jukebox_side.png");
                    saveSlice(bufferedImage, 11, 4, "beta_jukebox_top.png");
                    saveSlice(bufferedImage, 0, 5, "beta_torch.png");
                    saveSlice(bufferedImage, 1, 5, "beta_wooden_door_top.png");
                    saveSlice(bufferedImage, 2, 5, "beta_iron_door_top.png");
                    saveSlice(bufferedImage, 3, 5, "beta_ladder.png");
                    saveSlice(bufferedImage, 4, 5, "beta_redstone_x_unpowered.png");
                    saveSlice(bufferedImage, 5, 5, "beta_redstone_line_unpowered.png");
                    saveSlice(bufferedImage, 6, 5, "beta_wet_farmland.png");
                    saveSlice(bufferedImage, 7, 5, "beta_dry_farmland.png");
                } catch (IOException e){
                    LOGGER.error("Cannot write to disk, textures might be missing in-game.");
                }
                LOGGER.info("Slicing successful.");
            } catch (IOException e) {
                LOGGER.error("Cannot download textures, they might be missing in-game.");
            }

        }
        if (config.disableDownload){
            LOGGER.info("Downloading textures is disabled. Files might be missing.");
        }
        */
        LOGGER.info("Registering...");
        BLOCKS.register();
        TABS.register();
        ITEMS.register();
        LOGGER.info("Initialization successful!");
    }

    public static BufferedImage cropImage(BufferedImage src, Rectangle rect) {
        return src.getSubimage(rect.x, rect.y, rect.width, rect.height);
    }

    public static void saveSlice(BufferedImage image, int x, int y, String filename) throws IOException {
        BufferedImage currentImg = cropImage(image, new Rectangle(16*x, 16*y, 16, 16));
        ImageIO.write(currentImg, "png", new File("resources/" + filename));
    }
}
