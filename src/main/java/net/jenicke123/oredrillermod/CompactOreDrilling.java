package net.jenicke123.oredrillermod;

import net.fabricmc.api.ModInitializer;

import net.jenicke123.oredrillermod.block.ModBlocks;
import net.jenicke123.oredrillermod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important Content
public class CompactOreDrilling implements ModInitializer {
	public static final String MOD_ID = "oredrillermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}