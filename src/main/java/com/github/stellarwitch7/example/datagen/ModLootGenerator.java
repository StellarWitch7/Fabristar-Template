package com.github.stellarwitch7.example.datagen;

import com.github.stellarwitch7.example.ExampleDataGenerator;
import com.github.stellarwitch7.example.ExampleMod;
import com.github.stellarwitch7.example.registry.ModRegistry;
import com.github.stellarwitch7.example.registry.registrable.RegistrableBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModLootGenerator {
	public static void generate() {
		ExampleDataGenerator.fabricDataGenerator.addProvider(SimpleBlockLootGenerator::new);
		ExampleDataGenerator.fabricDataGenerator.addProvider(CustomBlockLootGenerator::new);
		ExampleDataGenerator.fabricDataGenerator.addProvider(EntityLootGenerator::new);
	}
}

//For simple block drops
class SimpleBlockLootGenerator extends SimpleFabricLootTableProvider {
	public SimpleBlockLootGenerator(FabricDataGenerator dataGenerator) {
		super(dataGenerator, LootContextTypes.BLOCK);
	}
	
	@Override
	public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
		for (RegistrableBlock data : ModRegistry.publicRegistryBlocks) {
			if (data.hasSimpleLoot) {
				identifierBuilderBiConsumer.accept(new Identifier(ExampleMod.MOD_ID,
								"blocks/" + data.id),
						BlockLootTableGenerator.drops(data.block));
			} else {
				ExampleMod.LOGGER.warn("The loot table for "
						+ ExampleMod.MOD_ID + ":" + data.id
						+ " has not been generated because hasSimpleLoot is set to false");
			}
		}
	}
}

class CustomBlockLootGenerator extends SimpleFabricLootTableProvider {
	public CustomBlockLootGenerator(FabricDataGenerator dataGenerator) {
		super(dataGenerator, LootContextTypes.BLOCK);
	}
	
	@Override
	public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
	}
}

class EntityLootGenerator extends SimpleFabricLootTableProvider {
	public EntityLootGenerator(FabricDataGenerator dataGenerator) {
		super(dataGenerator, LootContextTypes.ENTITY);
	}
	
	@Override
	public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
	}
}