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
import java.util.concurrent.TimeUnit;

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

        /*
        METADATA
         */

        MetaData metaData = gameFeed.metaData();
        assertNotNull(metaData);
        assertEquals(10L, metaData.getWait());
        assertEquals("20231102_030054", metaData.getTimeStamp());
        assertEquals(List.of("strikeout", "game_finished"), metaData.getGameEvents());
        assertEquals(List.of("midInning", "countChange", "count23", "gameStateChangeToGameOver"), metaData.getLogicalEvents());

        /*
        GAMEDATA
         */

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

        Person player = players.get(691783L);
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
        Used awayReview = review.away();
        assertNotNull(awayReview);
        assertEquals(0, awayReview.used());
        assertEquals(1, awayReview.remaining());
        Used homeReview = review.home();
        assertNotNull(homeReview);
        assertEquals(0, homeReview.used());
        assertEquals(1, homeReview.remaining());

        Flags flags = gameData.flags();
        assertNotNull(flags);
        assertFalse(flags.noHitter());
        assertFalse(flags.perfectGame());
        assertFalse(flags.awayTeamNoHitter());
        assertFalse(flags.awayTeamPerfectGame());
        assertFalse(flags.homeTeamNoHitter());
        assertFalse(flags.homeTeamPerfectGame());

        List<Object> alerts = gameData.alerts();
        assertEquals(0, alerts.size());

        Person officialScorer = gameData.officialScorer();
        assertNotNull(officialScorer);
        assertEquals(607890L, officialScorer.id());
        assertEquals("Jason Johnson", officialScorer.fullName());
        assertEquals("/api/v1/people/607890", officialScorer.link());

        Person primaryDatacaster = gameData.primaryDatacaster();
        assertNotNull(primaryDatacaster);
        assertEquals(430022L, primaryDatacaster.id());
        assertEquals("Chris Lentine", primaryDatacaster.fullName());
        assertEquals("/api/v1/people/430022", primaryDatacaster.link());

        MoundVisits moundVisits = gameData.moundVisits();
        assertNotNull(moundVisits);
        Used awayUsed = moundVisits.away();
        assertNotNull(awayUsed);
        assertEquals(3, awayUsed.used());
        assertEquals(2, awayUsed.remaining());
        Used homeUsed = moundVisits.home();
        assertNotNull(homeUsed);
        assertEquals(4, homeUsed.used());
        assertEquals(1, homeUsed.remaining());

        /*
        LIVEDATA
         */

        LiveData liveData = gameFeed.liveData();
        assertNotNull(liveData);

        Plays plays = liveData.plays();
        assertNotNull(plays);

        List<Play> allPlays = plays.allPlays();
        assertNotNull(allPlays);
        assertEquals(77, allPlays.size());

        Play p = allPlays.get(0);
        assertNotNull(p);
        assertEquals(OffsetDateTime.of(2023, 11, 2, 0, 7, 23, (int)TimeUnit.MILLISECONDS.toNanos(589), ZoneOffset.UTC), p.playEndTime());
        assertEquals(0, p.atBatIndex());

        Result result = p.result();
        assertNotNull(result);
        assertEquals("atBat", result.type());
        assertEquals("Flyout", result.event());
        assertEquals("field_out", result.eventType());
        assertEquals("Marcus Semien flies out to center fielder Alek Thomas.", result.description());
        assertEquals(0, result.rbi());
        assertEquals(0, result.awayScore());
        assertEquals(0, result.homeScore());
        assertTrue(result.isOut());

        About about = p.about();
        assertNotNull(about);
        assertEquals(0, about.atBatIndex());
        assertEquals("top", about.halfInning());
        assertTrue(about.isTopInning());
        assertEquals(1, about.inning());
        assertEquals(OffsetDateTime.of(2023, 11, 2, 0, 6, 13, (int)TimeUnit.MILLISECONDS.toNanos(497), ZoneOffset.UTC), about.startTime());
        assertEquals(OffsetDateTime.of(2023, 11, 2, 0, 7, 23, (int)TimeUnit.MILLISECONDS.toNanos(589), ZoneOffset.UTC), about.endTime());
        assertTrue(about.isComplete());
        assertFalse(about.isScoringPlay());
        assertFalse(about.hasReview());
        assertTrue(about.hasOut());
        assertEquals(0, about.captivatingIndex());

        Count count = p.count();
        assertNotNull(count);
        assertEquals(2, count.balls());
        assertEquals(1, count.strikes());
        assertEquals(1, count.outs());

        Matchup matchup = p.matchup();
        assertNotNull(matchup);

        Person batter = matchup.batter();
        assertNotNull(batter);
        assertEquals(543760, batter.id());
        assertEquals("Marcus Semien", batter.fullName());
        assertEquals("/api/v1/people/543760", batter.link());

        batSide = matchup.batSide();
        assertNotNull(batSide);
        assertEquals("R", batSide.code());
        assertEquals("Right", batSide.description());

        Person pitcher = matchup.pitcher();
        assertNotNull(pitcher);
        assertEquals(668678, pitcher.id());
        assertEquals("Zac Gallen", pitcher.fullName());
        assertEquals("/api/v1/people/668678", pitcher.link());

        pitchHand = matchup.pitchHand();
        assertNotNull(pitchHand);
        assertEquals("R", pitchHand.code());
        assertEquals("Right", pitchHand.description());

        List<Object> batterHotColdZones = matchup.batterHotColdZones();
        assertNotNull(batterHotColdZones);
        assertTrue(batterHotColdZones.isEmpty());

        List<Object> pitcherHotColdZones = matchup.pitcherHotColdZones();
        assertNotNull(pitcherHotColdZones);
        assertTrue(pitcherHotColdZones.isEmpty());

        Splits splits = matchup.splits();
        assertNotNull(splits);
        assertEquals("vs_RHP", splits.batter());
        assertEquals("vs_RHB", splits.pitcher());
        assertEquals("Empty", splits.menOnBase());

        List<Long> pitchIndex = p.pitchIndex();
        assertNotNull(pitchIndex);
        assertEquals(4, pitchIndex.size());
        assertEquals(List.of(3L, 4L, 5L, 6L), pitchIndex);

        List<Long> actionIndex = p.actionIndex();
        assertNotNull(actionIndex);
        assertEquals(3, actionIndex.size());
        assertEquals(List.of(0L, 1L, 2L), actionIndex);

        List<Long> runnerIndex = p.runnerIndex();
        assertNotNull(runnerIndex);
        assertEquals(1, runnerIndex.size());
        assertEquals(List.of(0L), runnerIndex);

        List<Runner> runners = p.runners();
        assertNotNull(runners);
        assertEquals(1, runners.size());

        Runner runner = runners.get(0);
        assertNotNull(runner);

        Movement movement = runner.movement();
        assertNull(movement.originBase());
        assertNull(movement.start());
        assertNull(movement.end());
        assertEquals("1B", movement.outBase());
        assertTrue(movement.isOut());
        assertEquals(1, movement.outNumber());

        RunnerDetails details = runner.details();
        assertNotNull(details);
        assertEquals("Flyout", details.event());
        assertEquals("field_out", details.eventType());
        assertNull(details.movementReason());
        assertNull(details.responsiblePitcher());
        assertFalse(details.isScoringEvent());
        assertFalse(details.rbi());
        assertFalse(details.earned());
        assertFalse(details.teamUnearned());
        assertEquals(6, details.playIndex());

        Person rRunner = details.runner();
        assertNotNull(rRunner);
        assertEquals(543760, rRunner.id());
        assertEquals("Marcus Semien", rRunner.fullName());
        assertEquals("/api/v1/people/543760", rRunner.link());

        //TODO - Look at what's Null above and find examples to test them

        List<Credit> credits = runner.credits();
        assertNotNull(credits);
        assertEquals(1, credits.size());
        Credit credit = credits.get(0);
        Person creditPlayer = credit.player();
        assertNotNull(creditPlayer);
        assertEquals(677950, creditPlayer.id());
        assertEquals("/api/v1/people/677950", creditPlayer.link());
        Position position = credit.position();
        assertNotNull(position);
        assertEquals("8", position.code());
        assertEquals("Outfielder", position.name());
        assertEquals("Outfielder", position.type());
        assertEquals("CF", position.abbreviation());
        assertEquals("f_putout", credit.credit());

        List<PlayEvent> playEvents = p.playEvents();
        assertNotNull(playEvents);
        assertEquals(7, playEvents.size());

        PlayEvent playEvent = playEvents.get(3);
        assertNotNull(playEvent);
        assertEquals(3, playEvent.index());
        assertEquals("7c2e53d2-ec36-4348-83af-d10406f98830", playEvent.playId());
        assertEquals(1, playEvent.pitchNumber());
        assertEquals(OffsetDateTime.of(2023, 11, 2, 0, 6, 15, (int)TimeUnit.MILLISECONDS.toNanos(846), ZoneOffset.UTC), playEvent.startTime());
        assertEquals(OffsetDateTime.of(2023, 11, 2, 0, 6, 19, (int)TimeUnit.MILLISECONDS.toNanos(783), ZoneOffset.UTC), playEvent.endTime());
        assertTrue(playEvent.isPitch());
        assertEquals("pitch", playEvent.type());

        Details pDetails = playEvent.details();
        assertNotNull(pDetails);
        assertEquals("Ball", pDetails.description());
        assertEquals("B", pDetails.code());
        assertEquals("rgba(39, 161, 39, 1.0)", pDetails.ballColor());
        assertEquals("rgba(188, 0, 33, 1.0)", pDetails.trailColor());
        assertFalse(pDetails.isInPlay());
        assertFalse(pDetails.isStrike());
        assertTrue(pDetails.isBall());
        assertFalse(pDetails.isOut());
        assertFalse(pDetails.hasReview());

        Call call = pDetails.call();
        assertNotNull(call);
        assertEquals("B", call.code());
        assertEquals("Ball", call.description());

        PitchType pt = pDetails.type();
        assertNotNull(pt);
        assertEquals("FF", pt.code());
        assertEquals("Four-Seam Fastball", pt.description());

        count = playEvent.count();
        assertNotNull(count);
        assertEquals(1, count.balls());
        assertEquals(0, count.strikes());
        assertEquals(0, count.outs());

        PitchData pitchData = playEvent.pitchData();
        assertNotNull(pitchData);
        assertEquals(94.4, pitchData.startSpeed());
        assertEquals(86.2, pitchData.endSpeed());
        assertEquals(3.38431964486296, pitchData.strikeZoneTop());
        assertEquals(1.5678269255926, pitchData.strikeZoneBottom());

        PitchCoordinates pCoords = pitchData.coordinates();
        assertNotNull(pCoords);
        assertEquals(30.682850258846507, pCoords.aY());
        assertEquals(-12.893144161286793, pCoords.aZ());
        assertEquals(-2.394965224529101, pCoords.pfxX());
        assertEquals(10.152441689678522, pCoords.pfxZ());
        assertEquals(1.3186731766246924, pCoords.pX());
        assertEquals(2.6309597029396663, pCoords.pZ());
        assertEquals(10.644831536258499, pCoords.vX0());
        assertEquals(-137.02756570372844, pCoords.vY0());
        assertEquals(-6.261174898433838, pCoords.vZ0());
        assertEquals(66.74, pCoords.x());
        assertEquals(167.74, pCoords.y());
        assertEquals(-2.3075058244583113, pCoords.x0());
        assertEquals(50.001560349494575, pCoords.y0());
        assertEquals(5.828830290616323, pCoords.z0());
        assertEquals(-4.549538746752562, pCoords.aX());

        Breaks breaks = pitchData.breaks();
        assertNotNull(breaks);
        assertEquals(8.4, breaks.breakAngle());
        assertEquals(3.6, breaks.breakLength());
        assertEquals(24.0, breaks.breakY());
        assertEquals(-13.7, breaks.breakVertical());
        assertEquals(17.2, breaks.breakVerticalInduced());
        assertEquals(2.0, breaks.breakHorizontal());
        assertEquals(2262, breaks.spinRate());
        assertEquals(198, breaks.spinDirection());


    }



}
