package com.github.stellarwitch7.example.datagen;

import com.github.stellarwitch7.example.ExampleDataGenerator;
import com.github.stellarwitch7.example.ExampleMod;
import com.github.stellarwitch7.example.registry.ModRegistry;
import com.github.stellarwitch7.example.util.registrable.RegistrableBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootGenerator {
	public static void generate() {
		ExampleDataGenerator.pack.addProvider(BlockLootGenerator::new);
		ExampleDataGenerator.pack.addProvider(CustomBlockLootGenerator::new);
	}
}

//For simple block drops
class BlockLootGenerator extends FabricBlockLootTableProvider {
	protected BlockLootGenerator(FabricDataOutput dataOutput) {
		super(dataOutput);
	}
	
	@Override
	public void generate() {
		for (RegistrableBlock data : ModRegistry.publicRegistryBlocks) {
			if (data.hasSimpleLoot) {
				addDrop(data.block);
			} else {
				ExampleMod.LOGGER.warn("The loot table for "
						+ ExampleMod.MOD_ID + ":" + data.id
						+ " has not been generated because hasSimpleLoot is set to false");
			}
		}
	}
}

class CustomBlockLootGenerator extends FabricBlockLootTableProvider {
	protected CustomBlockLootGenerator(FabricDataOutput dataOutput) {
		super(dataOutput);
	}
	
	@Override
	public void generate() {
	
	}
}