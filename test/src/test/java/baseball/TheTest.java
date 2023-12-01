package baseball;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.nxx5.baseball.gson.GsonBuild;
import org.nxx5.baseball.jackson.JacksonBuild;
import org.nxx5.baseball.records.*;
import org.nxx5.baseball.records.Record;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TheTest {

    public Reader getWSReader(){
        return new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("748534.json")));
    }


    @Test
    public void testWSGson(){
        Gson gson = GsonBuild.builder().create();
        GameFeed gameFeed = gson.fromJson(getWSReader(), GameFeed.class);
        testGameFeed(gameFeed);
    }

    @Test
    public void testWSJackson() throws IOException {
        ObjectMapper objectMapper = JacksonBuild.builder().build();
        GameFeed gameFeed = objectMapper.readValue(getWSReader(), GameFeed.class);
        testGameFeed(gameFeed);
    }

    @Test
    public void testWSFastJson() throws IOException {
        GameFeed gameFeed = JSON.parseObject(getWSReader(), GameFeed.class);
        testGameFeed(gameFeed);
    }

    public static void testGameFeed(GameFeed gameFeed){
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

        Status status = gameData.status();
        assertNotNull(status);
        assertEquals("Final", status.abstractGameState());
        assertEquals("F", status.codedGameState());
        assertEquals("Final", status.detailedState());
        assertEquals("F", status.statusCode());
        assertFalse(status.startTimeTBD());
        assertEquals("F", status.abstractGameCode());

        Teams teams = gameData.teams();
        assertNotNull(teams);

        Team home = teams.home();
        assertNotNull(home);
        assertEquals("N", home.allStarStatus());
        assertEquals(109, home.id());
        assertEquals("Arizona Diamondbacks", home.name());
        assertEquals("/api/v1/teams/109", home.link());
        assertEquals(2023L, home.season());
        assertEquals("ari", home.teamCode());
        assertEquals("ari", home.fileCode());
        assertEquals("AZ", home.abbreviation());
        assertEquals("D-backs", home.teamName());
        assertEquals("Phoenix", home.locationName());
        assertEquals("1996", home.firstYearOfPlay());
        assertEquals("Arizona", home.shortName());
        assertEquals("Arizona", home.franchiseName());
        assertEquals("Diamondbacks", home.clubName());
        assertTrue(home.active());

        League springLeague = home.springLeague();
        assertNotNull(springLeague);
        assertEquals(114, springLeague.id());
        assertEquals("Cactus League", springLeague.name());
        assertEquals("/api/v1/league/114", springLeague.link());
        assertEquals("CL", springLeague.abbreviation());

        Venue venue = home.venue();
        assertNotNull(venue);
        assertEquals(15, venue.id());
        assertEquals("Chase Field", venue.name());
        assertEquals("/api/v1/venues/15", venue.link());

        Venue springVenue = home.springVenue();
        assertNotNull(springVenue);
        assertEquals(4249, springVenue.id());
        assertEquals("/api/v1/venues/4249", springVenue.link());

        League league = home.league();
        assertNotNull(league);
        assertEquals(104, league.id());
        assertEquals("National League", league.name());
        assertEquals("/api/v1/league/104", league.link());

        Division division = home.division();
        assertNotNull(division);
        assertEquals(203, division.id());
        assertEquals("National League West", division.name());
        assertEquals("/api/v1/divisions/203", division.link());

        Sport sport = home.sport();
        assertNotNull(sport);
        assertEquals(1L, sport.id());
        assertEquals("/api/v1/sports/1", sport.link());
        assertEquals("Major League Baseball", sport.name());

        Record record = home.record();
        assertNotNull(record);
        assertEquals(5, record.gamesPlayed());
        assertEquals("-", record.wildCardGamesBack());
        assertEquals("-", record.leagueGamesBack());
        assertEquals("-", record.springLeagueGamesBack());
        assertEquals("-", record.sportGamesBack());
        assertEquals("-", record.divisionGamesBack());
        assertEquals("-", record.conferenceGamesBack());
        assertNotNull(record.records());
        assertFalse(record.divisionLeader());
        assertEquals(1, record.wins());
        assertEquals(4, record.losses());
        assertEquals(".200", record.winningPercentage());

        LeagueRecord leagueRecord = record.leagueRecord();
        assertNotNull(leagueRecord);
        assertEquals(1, leagueRecord.wins());
        assertEquals(4, leagueRecord.losses());
        assertEquals(0, leagueRecord.ties());
        assertEquals(".200", leagueRecord.pct());


    }



}
