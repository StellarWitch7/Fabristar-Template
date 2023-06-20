package com.github.stellarwitch7.example.util;

import com.github.stellarwitch7.example.ExampleMod;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class GeckoModel<T extends GeoAnimatable> extends GeoModel<T> {
	private final boolean noAnimation;
	private final String id;
	private final ModelType modelType;
	
	public GeckoModel(String id, ModelType modelType) {
		super();
		this.noAnimation = false;
		this.id = id;
		this.modelType = modelType;
	}
	
	public GeckoModel(String id, ModelType modelType, boolean hasNoAnimation) {
		super();
		this.noAnimation = hasNoAnimation;
		this.id = id;
		this.modelType = modelType;
	}
	
	@Override
	public Identifier getModelResource(T object) {
		return new Identifier(ExampleMod.MOD_ID, "geo/" + id + ".geo.json");
	}
	
	@Override
	public Identifier getTextureResource(T object) {
		return new Identifier(ExampleMod.MOD_ID, "textures/" + modelType.getPath() + id + ".png");
	}
	
	@Override
	public Identifier getAnimationResource(T object) {
		if (noAnimation) {
			return new Identifier(ExampleMod.MOD_ID, "animations/empty.animation.json");
		} else {
			return new Identifier(ExampleMod.MOD_ID, "animations/" + id + ".animation.json");
		}
	}
}
