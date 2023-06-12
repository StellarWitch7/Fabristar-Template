package com.github.stellarwitch7.example.datagen;

import com.github.stellarwitch7.example.ExampleDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class ModRecipeGenerator {
	public static void generate() {
		ExampleDataGenerator.pack.addProvider(CraftingRecipeGenerator::new);
		ExampleDataGenerator.pack.addProvider(SmeltingRecipeGenerator::new);
	}
}

class CraftingRecipeGenerator extends FabricRecipeProvider {
	public CraftingRecipeGenerator(FabricDataOutput output) {
		super(output);
	}
	
	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
	
	}
}

class SmeltingRecipeGenerator extends FabricRecipeProvider {
	public SmeltingRecipeGenerator(FabricDataOutput output) {
		super(output);
	}
	
	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
	
	}
}