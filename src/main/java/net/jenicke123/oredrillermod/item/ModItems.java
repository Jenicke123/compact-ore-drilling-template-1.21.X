package net.jenicke123.oredrillermod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jenicke123.oredrillermod.CompactOreDrilling;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item WOODEN_DRILL_BIT = registerItem("wooden_drill", new Item(new Item.Settings()));
    public static final Item STONE_DRILL_BIT = registerItem("stone_drill", new Item(new Item.Settings()));
    public static final Item IRON_DRILL_BIT = registerItem("iron_drill", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CompactOreDrilling.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CompactOreDrilling.LOGGER.info("Registering mod items for " + CompactOreDrilling.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(WOODEN_DRILL_BIT);
            fabricItemGroupEntries.add(STONE_DRILL_BIT);
            fabricItemGroupEntries.add(IRON_DRILL_BIT);
        });
    }
}
