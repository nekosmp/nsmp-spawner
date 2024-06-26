// Copyright 2024 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package rs.neko.smp.spawner;

import java.lang.reflect.Type;

import net.minecraft.util.JsonHelper;
import net.minecraft.util.math.BlockPos;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SpawnData {
  public int spawnX, spawnZ = 0;

  public final BlockPos toBlockPos() {
    return new BlockPos(spawnX, 128, spawnZ);
  }

  public static final class Serde implements JsonSerializer<SpawnData>, JsonDeserializer<SpawnData> {
    @Override
    public SpawnData deserialize(JsonElement json, Type t, JsonDeserializationContext ctx)
        throws JsonParseException {
      JsonObject obj = json.getAsJsonObject();
      SpawnData self = new SpawnData();
      self.spawnX = JsonHelper.getInt(obj, "spawnX", 0);
      self.spawnZ = JsonHelper.getInt(obj, "spawnZ", 0);
      return self;
    }

    @Override
    public JsonElement serialize(SpawnData self, Type t, JsonSerializationContext ctx) {
      JsonObject json = new JsonObject();
      json.addProperty("spawnX", self.spawnX);
      json.addProperty("spawnZ", self.spawnZ);
      return json;
    }
  }
}