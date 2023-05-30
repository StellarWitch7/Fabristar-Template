package com.github.stellarwitch7.example.registry;

public class ClientRegistry {
	private static void loadRegistry() {
		ClientRenderers.load();
	}
	
	public static void register() {
		loadRegistry();
	}
}
