package org.nxx5.baseball;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.junit.jupiter.api.Test;
import org.nxx5.baseball.records.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TheTest {

    public Reader getWSReader(){
        return new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("748534.json")));
    }


    @Test
    public void testWSGson(){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(OffsetDateTime.class, (JsonDeserializer<OffsetDateTime>) (json, type, context) -> OffsetDateTime.parse(json.getAsString()));
        builder.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, context) -> LocalDate.parse(json.getAsString()));
        builder.registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, type, context) -> LocalTime.parse(json.getAsString()));
        Gson gson = builder.create();
        GameFeed gameFeed = gson.fromJson(getWSReader(), GameFeed.class);
        testGameFeed(gameFeed);
    }

    @Test
    public void testWSJackson() throws IOException {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        GameFeed gameFeed = objectMapper.readValue(getWSReader(), GameFeed.class);
        testGameFeed(gameFeed);
    }

    @Test
    public void testWSFastJson() throws IOException {
        GameFeed gameFeed = JSON.parseObject(getWSReader(), GameFeed.class);
        testGameFeed(gameFeed);
    }

    public void testGameFeed(GameFeed gameFeed){
        assertEquals(748534L, gameFeed.gamePk());
        assertEquals("/api/v1.1/game/748534/feed/live", gameFeed.link());

        MetaData metaData = gameFeed.metaData();
        assertNotNull(metaData);
        assertEquals(10L, metaData.getWait());
        assertEquals("20231102_030054", metaData.getTimeStamp());
        assertEquals(List.of("strikeout", "game_finished"), metaData.getGameEvents());
        assertEquals(List.of("midInning", "countChange", "count23", "gameStateChangeToGameOver"), metaData.getLogicalEvents());

        GameData gameData = gameFeed.gameData();
        assertNotNull(gameData);

        Game game = gameData.game();
        assertNotNull(gameData);
        assertEquals(748534L, game.pk());
        assertEquals("W", game.type());
        assertEquals("N", game.doubleHeader());
        assertEquals("2023/11/01/texmlb-arimlb-1", game.id());
        assertEquals("P", game.gamedayType());
        assertEquals("N", game.tiebreaker());
        assertEquals(1L, game.gameNumber());
        assertEquals("14-748534-2023-11-01", game.calendarEventID());
        assertEquals("2023", game.season());
        assertEquals("2023", game.seasonDisplay());

        DateTime datetime = gameData.datetime();
        assertNotNull(datetime);
        assertEquals(OffsetDateTime.of(2023, 11, 2, 0, 3, 0, 0, ZoneOffset.UTC), datetime.dateTime());
        assertEquals(LocalDate.of(2023, 11, 1), datetime.officialDate());
        assertEquals(LocalDate.of(2023, 11, 1), datetime.originalDate());
        assertEquals("night", datetime.dayNight());
        assertEquals("5:03", datetime.time());
        assertEquals("PM", datetime.ampm());
    }

}
