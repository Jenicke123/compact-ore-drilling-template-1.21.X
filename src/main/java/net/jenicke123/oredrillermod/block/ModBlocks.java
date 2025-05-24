package net.jenicke123.oredrillermod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jenicke123.oredrillermod.CompactOreDrilling;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block WOODEN_DRILL = registerBlock("wooden_drill",
            new Block(AbstractBlock.Settings.create().strength(0f)
                    .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block STONE_DRILL = registerBlock("stone_drill",
            new Block(AbstractBlock.Settings.create().strength(1f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CompactOreDrilling.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CompactOreDrilling.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        CompactOreDrilling.LOGGER.info("Registering mod blocks for " + CompactOreDrilling.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.WOODEN_DRILL);
            fabricItemGroupEntries.add(ModBlocks.STONE_DRILL);
        });
    }
}
