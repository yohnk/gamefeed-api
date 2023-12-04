package org.nxx5.baseball.gson;

import com.google.gson.*;
import org.nxx5.baseball.records.Person;
import org.nxx5.baseball.records.Players;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Map;

public class GsonBuild {

    public static GsonBuilder builder(GsonBuilder builder){
        builder.registerTypeAdapter(OffsetDateTime.class, (JsonDeserializer<OffsetDateTime>) (json, type, context) -> OffsetDateTime.parse(json.getAsString()));
        builder.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, context) -> LocalDate.parse(json.getAsString()));
        builder.registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, type, context) -> LocalTime.parse(json.getAsString()));
        builder.registerTypeAdapter(Players.class, new PlayersDeserializer());
        return builder;
    }

    public static GsonBuilder builder(){
        return builder(new GsonBuilder());
    }

    private static class PlayersDeserializer implements JsonDeserializer<Players> {

        private static final Gson gson = builder().create();

        @Override
        public Players deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            Players players = new Players();
            Map<String, JsonElement> jsonMap = jsonElement.getAsJsonObject().asMap();
            for(String key : jsonMap.keySet()){
                JsonElement element = jsonMap.get(key);
                Person p = gson.fromJson(element, Person.class);
                players.put(p.id(), p);
            }
            return players;
        }
    }

}
