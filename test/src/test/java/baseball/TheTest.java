package baseball;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.nxx5.baseball.gson.GsonBuild;
import org.nxx5.baseball.jackson.JacksonBuild;
import org.nxx5.baseball.records.Record;
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

        Team away = teams.away();
        assertNotNull(away);
        assertEquals("N", away.allStarStatus());
        assertEquals(140, away.id());
        assertEquals("Texas Rangers", away.name());
        assertEquals("/api/v1/teams/140", away.link());
        assertEquals(2023L, away.season());
        assertEquals("tex", away.teamCode());
        assertEquals("tex", away.fileCode());
        assertEquals("TEX", away.abbreviation());
        assertEquals("Rangers", away.teamName());
        assertEquals("Arlington", away.locationName());
        assertEquals("1961", away.firstYearOfPlay());
        assertEquals("Texas", away.shortName());
        assertEquals("Texas", away.franchiseName());
        assertEquals("Rangers", away.clubName());
        assertTrue(away.active());

        springLeague = away.springLeague();
        assertNotNull(springLeague);
        assertEquals(114, springLeague.id());
        assertEquals("Cactus League", springLeague.name());
        assertEquals("/api/v1/league/114", springLeague.link());
        assertEquals("CL", springLeague.abbreviation());

        venue = away.venue();
        assertNotNull(venue);
        assertEquals(5325, venue.id());
        assertEquals("Globe Life Field", venue.name());
        assertEquals("/api/v1/venues/5325", venue.link());

        springVenue = away.springVenue();
        assertNotNull(springVenue);
        assertEquals(2603, springVenue.id());
        assertEquals("/api/v1/venues/2603", springVenue.link());

        league = away.league();
        assertNotNull(league);
        assertEquals(103, league.id());
        assertEquals("American League", league.name());
        assertEquals("/api/v1/league/103", league.link());

        division = away.division();
        assertNotNull(division);
        assertEquals(200, division.id());
        assertEquals("American League West", division.name());
        assertEquals("/api/v1/divisions/200", division.link());

        sport = away.sport();
        assertNotNull(sport);
        assertEquals(1L, sport.id());
        assertEquals("/api/v1/sports/1", sport.link());
        assertEquals("Major League Baseball", sport.name());

        record = away.record();
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
        assertEquals(4, record.wins());
        assertEquals(1, record.losses());
        assertEquals(".800", record.winningPercentage());

        leagueRecord = record.leagueRecord();
        assertNotNull(leagueRecord);
        assertEquals(4, leagueRecord.wins());
        assertEquals(1, leagueRecord.losses());
        assertEquals(0, leagueRecord.ties());
        assertEquals(".800", leagueRecord.pct());

        Players players = gameData.players();
        assertNotNull(players);
        assertEquals(52, players.size());

        Player player = players.get(691783L);
        assertNotNull(player);
        assertEquals(691783L, player.id());
        assertEquals("Jordan Lawlar", player.fullName());
        assertEquals("/api/v1/people/691783", player.link());
        assertEquals("Jordan", player.firstName());
        assertEquals("Lawlar", player.lastName());
        assertEquals("10", player.primaryNumber());
        assertEquals(LocalDate.of(2002, 7, 17), player.birthDate());
        assertEquals(21, player.currentAge());
        assertEquals("Carrollton", player.birthCity());
        assertEquals("TX", player.birthStateProvince());
        assertEquals("USA", player.birthCountry());
        assertEquals("6' 1\"", player.height());
        assertEquals(190L, player.weight());
        assertTrue(player.active());
        assertEquals("Jordan", player.useName());
        assertEquals("Lawlar", player.useLastName());
        assertEquals("Jeffrey-Joseph", player.middleName());
        assertEquals("Lawlar", player.boxscoreName());
        assertEquals("M", player.gender());
        assertTrue(player.isPlayer());
        assertTrue(player.isVerified());
        assertEquals(2021L, player.draftYear());
        assertEquals(LocalDate.of(2023, 9, 7), player.mlbDebutDate());
        assertEquals("Jordan Lawlar", player.nameFirstLast());
        assertEquals("jordan-lawlar-691783", player.nameSlug());
        assertEquals("Jordan Lawlar", player.firstLastName());
        assertEquals("Lawlar, Jordan", player.lastFirstName());
        assertEquals("Lawlar, J", player.lastInitName());
        assertEquals("J Lawlar", player.initLastName());
        assertEquals("Jordan Jeffrey-Joseph Lawlar", player.fullFMLName());
        assertEquals("Lawlar, Jordan Jeffrey-Joseph", player.fullLFMName());
        assertEquals(3.44, player.strikeZoneTop());
        assertEquals(1.6, player.strikeZoneBottom());

        Position primaryPosition = player.primaryPosition();
        assertEquals("6", primaryPosition.code());
        assertEquals("Shortstop", primaryPosition.name());
        assertEquals("Infielder", primaryPosition.type());
        assertEquals("SS", primaryPosition.abbreviation());

        Hand batSide = player.batSide();
        assertEquals("R", batSide.code());
        assertEquals("Right", batSide.description());

        Hand pitchHand = player.pitchHand();
        assertEquals("R", pitchHand.code());
        assertEquals("Right", pitchHand.description());

        player = players.get(666818L);
        assertNotNull(player);
        assertEquals("Frías", player.useLastName());
        assertEquals("Frías", player.boxscoreName());
        assertEquals("Guzman", player.nameMatrilineal());
        assertEquals("FREE-iss", player.pronunciation());

        venue = gameData.venue();
        assertNotNull(venue);
        assertEquals(15, venue.id());
        assertEquals("Chase Field", venue.name());
        assertEquals("/api/v1/venues/15", venue.link());
        assertTrue(venue.active());
        assertEquals(venue.season(), "2023");

        Location location = venue.location();
        assertNotNull(location);
        assertEquals("401 East Jefferson Street", location.address1());
        assertEquals("Phoenix", location.city());
        assertEquals("Arizona", location.state());
        assertEquals("AZ", location.stateAbbrev());
        assertEquals("85004", location.postalCode());
        assertEquals(0.0, location.azimuthAngle());
        assertEquals(1086, location.elevation());
        assertEquals("USA", location.country());
        assertEquals("(602) 462-6500", location.phone());

        Coordinates defaultCoordinates = location.defaultCoordinates();
        assertNotNull(defaultCoordinates);
        assertEquals(33.445302, defaultCoordinates.latitude());
        assertEquals(-112.066687, defaultCoordinates.longitude());

        Timezone timezone = venue.timeZone();
        assertNotNull(timezone);
        assertEquals("America/Phoenix", timezone.id());
        assertEquals(-7, timezone.offset());
        assertEquals(-7, timezone.offsetAtGameTime());
        assertEquals("MST", timezone.tz());

        FieldInfo fieldInfo = venue.fieldInfo();
        assertNotNull(fieldInfo);
        assertEquals(48359, fieldInfo.capacity());
        assertEquals("Artificial Turf", fieldInfo.turfType());
        assertEquals("Retractable", fieldInfo.roofType());
        assertEquals(328, fieldInfo.leftLine());
        assertEquals(376, fieldInfo.left());
        assertEquals(412, fieldInfo.leftCenter());
        assertEquals(407, fieldInfo.center());
        assertEquals(414, fieldInfo.rightCenter());
        assertEquals(376, fieldInfo.right());
        assertEquals(335, fieldInfo.rightLine());

        Venue officialVenue = gameData.officialVenue();
        assertNotNull(officialVenue);
        assertEquals(15, officialVenue.id());
        assertEquals("/api/v1/venues/15", officialVenue.link());

        Weather weather = gameData.weather();
        assertNotNull(weather);
        assertEquals("Clear", weather.condition());
        assertEquals("79", weather.temp());
        assertEquals("1 mph, Varies", weather.wind());

        GameInfo gameInfo = gameData.gameInfo();
        assertNotNull(gameInfo);
        assertEquals(48511L, gameInfo.attendance());
        assertEquals(OffsetDateTime.of(2023, 11, 2, 0, 6, 0, 0, ZoneOffset.UTC), gameInfo.firstPitch());
        assertEquals(174L, gameInfo.gameDurationMinutes());

        Review review = gameData.review();
        assertFalse(review.hasChallenges());
        Reviews awayReview = review.away();
        assertNotNull(awayReview);
        assertEquals(0, awayReview.used());
        assertEquals(1, awayReview.remaining());
        Reviews homeReview = review.home();
        assertNotNull(homeReview);
        assertEquals(0, homeReview.used());
        assertEquals(1, homeReview.remaining());

    }



}
