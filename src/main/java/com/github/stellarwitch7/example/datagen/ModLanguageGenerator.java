package com.github.stellarwitch7.example.datagen;

import com.github.stellarwitch7.example.util.registrable.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import org.apache.commons.lang3.StringUtils;
import com.github.stellarwitch7.example.ExampleDataGenerator;
import com.github.stellarwitch7.example.ExampleMod;
import com.github.stellarwitch7.example.registry.ModRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLanguageGenerator {
	public static void generate() {
		ExampleDataGenerator.pack.addProvider(UkEnglishLangProvider::new);
		ExampleDataGenerator.pack.addProvider(UsEnglishLangProvider::new);
	}
}

//UK english translation
class UkEnglishLangProvider extends FabricLanguageProvider {
	protected UkEnglishLangProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}
	
	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		translationBuilder.add(ExampleMod.ITEM_GROUP,
				StringUtils.capitalize(ExampleMod.MOD_ID));
		
		//Generate block translations
		for (RegistrableBlock data : ModRegistry.publicRegistryBlocks) {
			translationBuilder.add(data.block, data.name);
		}
		
		//Generate status effect translations
		for (RegistrableStatusEffect data : ModRegistry.publicRegistryEffects) {
			translationBuilder.add(data.effect, data.name);
		}
		
		//Generate entity translations
		for (RegistrableEntity data : ModRegistry.publicRegistryEntities) {
			translationBuilder.add(data.entity, data.name);
		}
		
		//Generate item translations
		for (RegistrableItem data : ModRegistry.publicRegistryItems) {
			translationBuilder.add(data.item, data.name);
		}
		
		//Generate sound translations
		for (RegistrableSound data : ModRegistry.publicRegistrySounds) {
			translationBuilder.add("subtitles." + ExampleMod.MOD_ID + "." + data.id, data.name);
		}
	}
}

//US english translation
class UsEnglishLangProvider extends FabricLanguageProvider {
	protected UsEnglishLangProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}
	
	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		translationBuilder.add(ExampleMod.ITEM_GROUP,
				StringUtils.capitalize(ExampleMod.MOD_ID));
		
		//Generate block translations
		for (RegistrableBlock data : ModRegistry.publicRegistryBlocks) {
			translationBuilder.add(data.block, data.name);
		}
		
		//Generate status effect translations
		for (RegistrableStatusEffect data : ModRegistry.publicRegistryEffects) {
			translationBuilder.add(data.effect, data.name);
		}
		
		//Generate entity translations
		for (RegistrableEntity data : ModRegistry.publicRegistryEntities) {
			translationBuilder.add(data.entity, data.name);
		}
		
		//Generate item translations
		for (RegistrableItem data : ModRegistry.publicRegistryItems) {
			translationBuilder.add(data.item, data.name);
		}
		
		//Generate sound translations
		for (RegistrableSound data : ModRegistry.publicRegistrySounds) {
			translationBuilder.add("subtitles." + ExampleMod.MOD_ID + "." + data.id, data.name);
		}
	}
}