package com.github.stellarwitch7.example.client;

public class ClientRegistry {
	private static void loadRegistry() {
		ClientRenderers.load();
	}
	
	public static void register() {
		loadRegistry();
	}
}
