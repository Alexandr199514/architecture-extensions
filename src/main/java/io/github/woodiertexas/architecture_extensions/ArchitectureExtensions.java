package io.github.woodiertexas.architecture_extensions;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchitectureExtensions implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Architecture Extensions");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {} v{}!", mod.metadata().name(), mod.metadata().version().raw());

		ArchitectureExtensionsBlocks.init();

		if (QuiltLoader.isModLoaded("soul_ice")) {
			ArchExSoul_IceCompat.init();
		}
	}
}
