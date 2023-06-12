package com.github.stellarwitch7.example;

import com.github.stellarwitch7.example.datagen.*;
import com.github.stellarwitch7.example.registry.ModRegistry;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ExampleDataGenerator implements DataGeneratorEntrypoint {
	public static FabricDataGenerator fabricDataGenerator;
	public static FabricDataGenerator.Pack pack;
	
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		pack = fabricDataGenerator.createPack();
		ModRegistry.datagenCleanup();
		ExampleMod.LOGGER.info("Generating data files");
		ModDataGenerators.load();
	}
}