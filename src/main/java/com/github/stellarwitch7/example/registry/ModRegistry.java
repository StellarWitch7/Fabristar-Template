package com.github.stellarwitch7.example.registry;

import com.github.stellarwitch7.example.ExampleMod;
import com.github.stellarwitch7.example.util.registrable.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Block;
import net.minecraft.data.client.Model;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ModRegistry {
	private static final ArrayList<RegistrableBlock> registryBlocks =
			new ArrayList<>();
	public static final List<RegistrableBlock> publicRegistryBlocks =
			Collections.unmodifiableList(registryBlocks);
	private static final ArrayList<RegistrableStatusEffect> registryEffects =
			new ArrayList<>();
	public static final List<RegistrableStatusEffect> publicRegistryEffects =
			Collections.unmodifiableList(registryEffects);
	private static final ArrayList<RegistrableItem> registryItems =
			new ArrayList<>();
	public static final List<RegistrableItem> publicRegistryItems =
			Collections.unmodifiableList(registryItems);
	private static final ArrayList<RegistrableEntity> registryEntities =
			new ArrayList<>();
	public static final List<RegistrableEntity> publicRegistryEntities =
			Collections.unmodifiableList(registryEntities);
	private static final ArrayList<RegistrableSound> registrySounds =
			new ArrayList<>();
	public static final List<RegistrableSound> publicRegistrySounds =
			Collections.unmodifiableList(registrySounds);
	
	//Loads the other registry classes
	private static void loadRegistry() {
		ExampleMod.LOGGER.info("Preparing registry");
		ModBlocks.load();
		ModEffects.load();
		ModEntities.load();
		ModItems.load();
		ModBlockEntities.load();
		ModEvents.load();
		ModSoundEvents.load();
		ModMusic.load();
	}
	
	public static void register() {
		//Attempting to register anything without first
		//loading the registries will register nothing
		loadRegistry();
		
		//Register blocks
		ExampleMod.LOGGER.info("Registering "
				+ StringUtils.capitalize(ExampleMod.MOD_ID)
				+ " blocks");
		for (RegistrableBlock data : registryBlocks) {
			ExampleMod.LOGGER.info("Registering block <"
					+ ExampleMod.MOD_ID + ":"
					+ data.id + ">");
			Registry.register(Registry.BLOCK,
					new Identifier(ExampleMod.MOD_ID, data.id),
					data.block);
		}
		
		//Register status effects
		ExampleMod.LOGGER.info("Registering "
				+ StringUtils.capitalize(ExampleMod.MOD_ID)
				+ " status effects");
		for (RegistrableStatusEffect data : registryEffects) {
			ExampleMod.LOGGER.info("Registering effect <"
					+ ExampleMod.MOD_ID + ":"
					+ data.id + ">");
			Registry.register(Registry.STATUS_EFFECT,
					new Identifier(ExampleMod.MOD_ID, data.id),
					data.effect);
		}
		
		//Register entities
		ExampleMod.LOGGER.info("Registering "
				+ StringUtils.capitalize(ExampleMod.MOD_ID)
				+ " entities");
		for (RegistrableEntity data : registryEntities) {
			ExampleMod.LOGGER.info("Registering entity <"
					+ ExampleMod.MOD_ID + ":"
					+ data.id + ">");
			Registry.register(Registry.ENTITY_TYPE,
					new Identifier(ExampleMod.MOD_ID, data.id),
					data.entity);
		}
		
		//Register items
		ExampleMod.LOGGER.info("Registering "
				+ StringUtils.capitalize(ExampleMod.MOD_ID)
				+ " items");
		for (RegistrableItem data : registryItems) {
			ExampleMod.LOGGER.info("Registering item <"
					+ ExampleMod.MOD_ID + ":"
					+ data.id + ">");
			Registry.register(Registry.ITEM,
					new Identifier(ExampleMod.MOD_ID, data.id),
					data.item);
		}
		
		//Register sound events
		ExampleMod.LOGGER.info("Registering "
				+ StringUtils.capitalize(ExampleMod.MOD_ID)
				+ " sound events");
		for (RegistrableSound data : registrySounds) {
			ExampleMod.LOGGER.info("Registering sound event <"
					+ ExampleMod.MOD_ID + ":"
					+ data.id + ">");
			Registry.register(Registry.SOUND_EVENT,
					new Identifier(ExampleMod.MOD_ID, data.id),
					data.soundEvent);
		}
	}
	
	//Clears the item list of any block items so that datagen functions don't create dupes
	public static void datagenCleanup() {
		ExampleMod.LOGGER.info("Preparing registry for data generation");
		ArrayList<RegistrableItem> toBeRemoved = new ArrayList<>();
		
		for (RegistrableItem data : registryItems) {
			if (data.isBlock) {
				toBeRemoved.add(data);
			}
		}
		
		for (RegistrableItem data : toBeRemoved) {
			registryItems.remove(data);
		}
	}
	
	public static Block createBlock(String name, boolean hasSimpleLoot,
									boolean hasSimpleModel, Block block) {
		var newBlock = new RegistrableBlock();
		newBlock.name = name;
		newBlock.id = name.toLowerCase(Locale.ROOT).replace(" ", "_");
		newBlock.hasSimpleLoot = hasSimpleLoot;
		newBlock.hasSimpleModel = hasSimpleModel;
		newBlock.block = block;
		registryBlocks.add(newBlock);
		return block;
	}
	
	public static StatusEffect createEffect(String name, StatusEffect effect) {
		var newEffect = new RegistrableStatusEffect();
		newEffect.name = name;
		newEffect.id = name.toLowerCase(Locale.ROOT).replace(" ", "_");
		newEffect.effect = effect;
		registryEffects.add(newEffect);
		return effect;
	}
	
	public static EntityType createEntity(String name, EntityType entityType,
										  DefaultAttributeContainer.Builder attributes) {
		var newEntity = new RegistrableEntity();
		newEntity.name = name;
		newEntity.id = name.toLowerCase(Locale.ROOT).replace(" ", "_");
		newEntity.entity = entityType;
		FabricDefaultAttributeRegistry.register(entityType,
				attributes);
		registryEntities.add(newEntity);
		return entityType;
	}
	
	public static Item createItem(String name, Model model, boolean isBlock, Item item) {
		var newItem = new RegistrableItem();
		newItem.name = name;
		newItem.id = name.toLowerCase(Locale.ROOT).replace(" ", "_");
		newItem.itemModel = model;
		newItem.isBlock = isBlock;
		newItem.item = item;
		registryItems.add(newItem);
		return item;
	}
	
	public static SoundEvent createSound(String name) {
		String id = name.toLowerCase(Locale.ROOT).replace(" ", "_");
		Identifier identifier = new Identifier(ExampleMod.MOD_ID, id);
		var newSound = new RegistrableSound();
		var soundEvent = new SoundEvent(identifier);
		newSound.id = id;
		newSound.name = name;
		newSound.soundEvent = soundEvent;
		registrySounds.add(newSound);
		return soundEvent;
	}
}
