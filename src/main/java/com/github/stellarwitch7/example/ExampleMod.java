package com.github.stellarwitch7.example;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import org.apache.commons.lang3.StringUtils;
import com.github.stellarwitch7.example.registry.ModRegistry;
import com.github.stellarwitch7.example.world.feature.ModConfiguredFeatures;
import com.github.stellarwitch7.example.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "example";
	public static final Logger LOGGER =
			LoggerFactory.getLogger(StringUtils.capitalize(MOD_ID));
	public static final ItemGroup ITEM_GROUP =
			FabricItemGroup.builder()
					.displayName(Text.translatable(MOD_ID + ".main_item_group"))
					.icon(() -> new ItemStack(Items.EMERALD))
					.build();
	
	@Override
	public void onInitialize() {
		LOGGER.info(StringUtils.capitalize(MOD_ID) + " loaded");
		ModConfiguredFeatures.register();
		ModRegistry.register();
		ModOreGeneration.generate();
	}
}