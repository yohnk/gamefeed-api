package org.nxx5.baseball.gson;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

public class GsonBuild {

    public static GsonBuilder builder(){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(OffsetDateTime.class, (JsonDeserializer<OffsetDateTime>) (json, type, context) -> OffsetDateTime.parse(json.getAsString()));
        builder.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, context) -> LocalDate.parse(json.getAsString()));
        builder.registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, type, context) -> LocalTime.parse(json.getAsString()));
        return builder;
    }

}
