package com.github.stellarwitch7.example.datagen;

public class ModDataGenerators {
	//Call this to load the data generators
	public static void load() {
		ModLanguageGenerator.generate();
		ModLootGenerator.generate();
		ModRecipeGenerator.generate();
		ModModelGenerator.generate();
	}
}
