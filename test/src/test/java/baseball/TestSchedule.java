package baseball;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.nxx5.baseball.gson.GsonBuild;
import org.nxx5.baseball.jackson.JacksonBuild;
import org.nxx5.baseball.records.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TestSchedule {

    public Reader getWSReader(){
        return new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("schedule.json")));
    }

    @Test
    public void testWSGson(){
        Gson gson = GsonBuild.builder().create();
        Schedule schedule = gson.fromJson(getWSReader(), Schedule.class);
        testSchedule(schedule);
    }

    @Test
    public void testWSJackson() throws IOException {
        ObjectMapper objectMapper = JacksonBuild.builder().build();
        Schedule schedule = objectMapper.readValue(getWSReader(), Schedule.class);
        testSchedule(schedule);
    }

    public void testSchedule(Schedule schedule){
        assertNotNull(schedule);

        assertEquals(1, schedule.totalItems());
        assertEquals(1, schedule.totalGames());
        assertEquals(0, schedule.totalEvents());
        assertEquals(0, schedule.totalGamesInProgress());

        List<Date> dates = schedule.dates();
        assertNotNull(dates);
        assertEquals(1, dates.size());

        Date date = dates.get(0);
        assertNotNull(date);

        assertEquals(LocalDate.of(2023, 11, 1), date.date());
        assertEquals(1, date.totalItems());
        assertEquals(0, date.totalEvents());
        assertEquals(1, date.totalGames());
        assertEquals(0, date.totalGamesInProgress());

        List<ScheduledGame> games = date.games();
        assertNotNull(games);
        assertEquals(1, games.size());

        ScheduledGame game = games.get(0);
        assertNotNull(game);

        assertEquals("f3f76a5b-9530-4e02-99f1-40d4ce443e8c", game.gameGuid());
        assertEquals("/api/v1.1/game/748534/feed/live", game.link());
        assertEquals("W", game.gameType());
        assertEquals("2023", game.season());
        assertEquals(OffsetDateTime.of(2023, 11, 2, 0, 3, 0, 0, ZoneOffset.UTC), game.gameDate());
        assertEquals(LocalDate.of(2023, 11, 1), game.officialDate());
        assertFalse(game.isTie());
        assertEquals(1, game.gameNumber());
        assertTrue(game.publicFacing());
        assertEquals("N", game.doubleHeader());
        assertEquals("P", game.gamedayType());
        assertEquals("N", game.tiebreaker());
        assertEquals("14-748534-2023-11-01", game.calendarEventID());
        assertEquals("2023", game.seasonDisplay());
        assertEquals("night", game.dayNight());
        assertEquals("World Series Game 5", game.description());
        assertEquals(9, game.scheduledInnings());
        assertFalse(game.reverseHomeAwayStatus());
        assertEquals(175, game.inningBreakLength());
        assertEquals(7, game.gamesInSeries());
        assertEquals(5, game.seriesGameNumber());
        assertEquals("World Series", game.seriesDescription());
        assertEquals("S", game.recordSource());
        assertEquals("N", game.ifNecessary());
        assertEquals("Normal Game", game.ifNecessaryDescription());

        Status status = game.status();
        assertNotNull(status);
        assertEquals("Final", status.abstractGameState());
        assertEquals("F", status.codedGameState());
        assertEquals("Final", status.detailedState());
        assertEquals("F", status.statusCode());
        assertFalse(status.startTimeTBD());
        assertEquals("F", status.abstractGameCode());

        ScheduleTeams teams = game.teams();
        assertNotNull(teams);

        ScheduleTeam away = teams.away();
        assertNotNull(away);
        assertEquals(5, away.score());
        assertTrue(away.isWinner());
        assertFalse(away.splitSquad());
        assertEquals(1, away.seriesNumber());

        LeagueRecord record = away.leagueRecord();
        assertNotNull(record);
        assertEquals(4, record.wins());
        assertEquals(1, record.losses());
        assertEquals(".800", record.pct());

        Team awayTeam = away.team();
        assertNotNull(awayTeam);
        assertEquals(140, awayTeam.id());
        assertEquals("Texas Rangers", awayTeam.name());
        assertEquals("/api/v1/teams/140", awayTeam.link());

        ScheduleTeam home = teams.home();
        assertNotNull(home);

        Team homeTeam = home.team();
        assertNotNull(homeTeam);
        assertEquals(109, homeTeam.id());
        assertEquals("Arizona Diamondbacks", homeTeam.name());
        assertEquals("/api/v1/teams/109", homeTeam.link());

        Venue venue = game.venue();
        assertNotNull(venue);
        assertEquals(15, venue.id());
        assertEquals("Chase Field", venue.name());
        assertEquals("/api/v1/venues/15", venue.link());


    }

}
