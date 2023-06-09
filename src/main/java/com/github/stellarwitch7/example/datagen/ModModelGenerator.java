package com.github.stellarwitch7.example.datagen;

import com.github.stellarwitch7.example.ExampleDataGenerator;
import com.github.stellarwitch7.example.ExampleMod;
import com.github.stellarwitch7.example.registry.ModRegistry;
import com.github.stellarwitch7.example.util.registrable.RegistrableBlock;
import com.github.stellarwitch7.example.util.registrable.RegistrableItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelGenerator {
	public static void generate() {
		ExampleDataGenerator.pack.addProvider(SimpleModelGenerator::new);
		ExampleDataGenerator.pack.addProvider(CustomModelGenerator::new);
	}
}

class SimpleModelGenerator extends FabricModelProvider {
	public SimpleModelGenerator(FabricDataOutput output) {
		super(output);
	}
	
	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		for (RegistrableBlock data : ModRegistry.publicRegistryBlocks) {
			if (data.hasSimpleModel) {
				blockStateModelGenerator.registerCubeAllModelTexturePool(data.block);
			} else {
				ExampleMod.LOGGER.warn("The block model for <"
						+ ExampleMod.MOD_ID + ":" + data.id
						+ "> has not been generated because hasSimpleModel is set to false");
			}
		}
	}
	
	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		for (RegistrableItem data : ModRegistry.publicRegistryItems) {
			itemModelGenerator.register(data.item, data.itemModel);
		}
	}
}

class CustomModelGenerator extends FabricModelProvider {
	public CustomModelGenerator(FabricDataOutput output) {
		super(output);
	}
	
	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
	
	}
	
	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
	
	}
}