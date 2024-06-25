// Copyright 2024 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package rs.neko.smp.spawner;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Spawner implements DedicatedServerModInitializer {
  public static final String MOD_ID = "nsmp-spawner";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitializeServer() {
    LOGGER.info("Initializing NSMP Spawner");
  }
}
