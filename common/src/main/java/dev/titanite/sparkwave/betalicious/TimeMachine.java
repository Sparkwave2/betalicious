package dev.titanite.sparkwave.betalicious;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.context.CommandContextBuilder;
import dev.architectury.registry.registries.RegistrySupplier;
import it.unimi.dsi.fastutil.objects.Reference2ObjectArrayMap;
import net.minecraft.client.GuiMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Spawner;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import org.lwjgl.system.linux.FOwnerEx;
import org.lwjgl.system.linux.PThread;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class TimeMachine extends Item {
    public TimeMachine(Properties properties) {
        super(properties);
    }

    Random r= new Random();

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(Component.translatable("item.betalicious.time_machine.tooltip1").withColor(11184810));
        list.add(Component.translatable("item.betalicious.time_machine.tooltip2").withColor(11184810));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        BlockHitResult hit = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        Block block = level.getBlockState(hit.getBlockPos()).getBlock();
        switch (block.getName().toString()){
            case "translation{key='block.minecraft.air', args=[]}":
                break;
            case "translation{key='block.minecraft.grass_block', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_GRASS_BLOCK);
                break;
            case "translation{key='block.minecraft.stone', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_STONE);
                break;
            case "translation{key='block.minecraft.stone_pressure_plate', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_STONE_PRESSURE_PLATE);
                break;
            case "translation{key='block.minecraft.oak_planks', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_PLANKS);
                break;
            case "translation{key='block.minecraft.oak_pressure_plate', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_WOODEN_PRESSURE_PLATE);
                break;
            case "translation{key='block.minecraft.oak_stairs', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_WOODEN_STAIRS);
                break;
            case "translation{key='block.minecraft.oak_fence', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_FENCE);
                break;
            case "translation{key='block.minecraft.bricks', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_BRICKS);
                break;
            case "translation{key='block.minecraft.tnt', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_TNT);
                break;
            case "translation{key='block.minecraft.cobweb', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_COBWEB);
                break;
            case "translation{key='block.minecraft.poppy', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_ROSE);
                break;
            case "translation{key='block.minecraft.rose_bush', args=[]}":
                player.displayClientMessage(Component.translatable("message.betalicious.rosebush").withColor(16711680), true);
                break;
            case "translation{key='block.minecraft.dandelion', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_DANDELION);
                break;
            case "translation{key='block.minecraft.oak_sapling', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_SAPLING);
                break;
            case "translation{key='block.minecraft.cobblestone', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_COBBLESTONE);
                break;
            case "translation{key='block.minecraft.cobblestone_stairs', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_COBBLESTONE_STAIRS);
                break;
            case "translation{key='block.minecraft.bedrock', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_BEDROCK);
                break;
            case "translation{key='block.minecraft.sand', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_SAND);
                break;
            case "translation{key='block.minecraft.gravel', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_GRAVEL);
                break;
            case "translation{key='block.minecraft.oak_log', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_LOG);
                break;
            case "translation{key='block.minecraft.iron_block', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_IRON_BLOCK);
                break;
            case "translation{key='block.minecraft.gold_block', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_GOLD_BLOCK);
                break;
            case "translation{key='block.minecraft.diamond_block', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_DIAMOND_BLOCK);
                break;
            case "translation{key='block.minecraft.brown_mushroom', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_BROWN_MUSHROOM);
                break;
            case "translation{key='block.minecraft.red_mushroom', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_RED_MUSHROOM);
                break;
            case "translation{key='block.minecraft.gold_ore', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_GOLD_ORE);
                break;
            case "translation{key='block.minecraft.iron_ore', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_IRON_ORE);
                break;
            case "translation{key='block.minecraft.coal_ore', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_COAL_ORE);
                break;
            case "translation{key='block.minecraft.bookshelf', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_BOOKSHELF);
                break;
            case "translation{key='block.minecraft.mossy_cobblestone', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_MOSSY_COBBLESTONE);
                break;
            case "translation{key='block.minecraft.obsidian', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_OBSIDIAN);
                break;
            case "translation{key='block.minecraft.crafting_table', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_CRAFTING_TABLE);
                break;
                /*
            case "translation{key='block.minecraft.furnace', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_FURNACE);
                break;

                 */
            case "translation{key='block.minecraft.sponge', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_SPONGE);
                break;
            case "translation{key='block.minecraft.glass', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_GLASS);
                break;
            case "translation{key='block.minecraft.diamond_ore', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_DIAMOND_ORE);
                break;
            case "translation{key='block.minecraft.redstone_ore', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_REDSTONE_ORE);
                break;
            case "translation{key='block.minecraft.oak_leaves', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_LEAVES);
                break;
            case "translation{key='block.minecraft.white_wool', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_WOOL);
                break;
                /*
            case "translation{key='block.minecraft.spawner', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_MOB_SPAWNER);
                break;

                 */
            case "translation{key='block.minecraft.snow_block', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_SNOW);
                break;
            case "translation{key='block.minecraft.snow', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_SNOW_LAYER);
                break;
            case "translation{key='block.minecraft.ice', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_ICE);
                break;
            case "translation{key='block.minecraft.cactus', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_CACTUS);
                break;
            case "translation{key='block.minecraft.clay', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_CLAY);
                break;
            case "translation{key='block.minecraft.sugar_cane', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_SUGAR_CANE);
                break;
            case "translation{key='block.minecraft.note_block', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_NOTE_BLOCK);
                break;
                /*
            case "translation{key='block.minecraft.jukebox', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_JUKEBOX);
                break;

                 */
            case "translation{key='block.minecraft.torch', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_TORCH);
                break;
            case "translation{key='block.minecraft.redstone_torch', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_REDSTONE_TORCH);
                break;
            case "translation{key='block.minecraft.oak_door', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_WOODEN_DOOR);
                break;
            case "translation{key='block.minecraft.iron_door', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_IRON_DOOR);
                break;
            case "translation{key='block.minecraft.lever', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_LEVER);
                break;
            case "translation{key='block.minecraft.stone_button', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_BUTTON);
                break;
            case "translation{key='block.minecraft.ladder', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_LADDER);
                break;
            case "translation{key='block.minecraft.oak_slab', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_WOODEN_SLAB);
                break;
            case "translation{key='block.minecraft.crying_obsidian', args=[]}":
                quickSetBlock(level, hit, player, Betalicious.BETA_CRYING_OBSIDIAN);
                break;
            default:
                player.displayClientMessage(Component.translatable("message.betalicious.wrongblock").withColor(16711680), true);
        }

        return super.use(level, player, interactionHand);
    }

    public void doOtherStuff(Level level, BlockHitResult hit, Player player){
        for (int i = 0; i < 50; i++) {
            double randomX = (hit.getBlockPos().getX() + (r.nextDouble() * 2)) - 0.5;
            double randomY = (hit.getBlockPos().getY() + (r.nextDouble() * 2)) - 0.5;
            double randomZ = (hit.getBlockPos().getZ() + (r.nextDouble() * 2)) - 0.5;
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, randomX, randomY, randomZ, 0, 0, 0);
            randomX = (hit.getBlockPos().getX() + (r.nextDouble() * 2)) - 0.5;
            randomY = (hit.getBlockPos().getY() + (r.nextDouble() * 2)) - 0.5;
            randomZ = (hit.getBlockPos().getZ() + (r.nextDouble() * 2)) - 0.5;
            level.addParticle(ParticleTypes.PORTAL, randomX, randomY, randomZ, 0, 0, 0);
        }
        player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        level.playSound(player, hit.getBlockPos(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 1, 0);
    }

    public void quickSetBlock(Level level, BlockHitResult hit, Player player, RegistrySupplier<Block> block){
        Block newBlock = block.get();
        BlockState oldState = level.getBlockState(hit.getBlockPos());
        BlockState newState = newBlock.withPropertiesOf(oldState);

        level.setBlock(hit.getBlockPos(), newState, 0);
        doOtherStuff(level, hit, player);
    }
}
