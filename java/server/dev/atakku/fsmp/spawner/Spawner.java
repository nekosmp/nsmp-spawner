// Copyright 2024 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package dev.atakku.fsmp.spawner;

import static net.minecraft.server.command.CommandManager.literal;

import java.util.UUID;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Spawner implements DedicatedServerModInitializer {
  public static final String MOD_ID = "fsmp-spawner";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitializeServer() {
    LOGGER.info("Initializing FSMP Spawner");
    CommandRegistrationCallback.EVENT.register((d, r, e) -> {
      d.register(literal("fsmp-spawner-test").requires(s -> s.hasPermissionLevel(2)).executes(ctx -> {
        for (int i = 0; i < 1024; i++) {
          SpawnCache.getSpawnData(UUID.randomUUID());
        }
        return 1;
      }));
    });
  }
}
