package com.nxx5.baseball;

import com.nxx5.baseball.hibernate.*;

import java.io.File;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;

public class Helpers {

    public static Schedule createSchedule(){
        Schedule s = new Schedule(748534L);
        s.setGameGuid("f3f76a5b-9530-4e02-99f1-40d4ce443e8c");
        s.setLink("/api/v1.1/game/748534/feed/live");
        s.setGameType("W");
        s.setSeason(2023L);
        s.setGameDate(OffsetDateTime.of(2023, 11, 2, 0, 3, 0, 0, ZoneOffset.UTC));
        s.setOfficialDate(LocalDate.of(2023, 11, 1));
        s.setAbstractGameState("Final");
        s.setCodedGameState("F");
        s.setDetailedState("Final");
        s.setStatusCode("F");
        s.setStartTimeTBD(false);
        s.setAbstractGameCode("F");
        s.setAwayTeam(new Team(140L));
        s.setHomeTeam(new Team(109L));
        s.setVenue(new Venue(15L));
        s.setIsTie(false);
        s.setGameNumber(1L);
        s.setDoubleHeader(false);
        s.setGamedayType("P");
        s.setTiebreaker(false);
        s.setCalendarEventID("14-748534-2023-11-01");
        s.setSeasonDisplay("2023");
        s.setDayNight("night");
        s.setDescription("World Series Game 5");
        s.setScheduledInnings(9L);
        s.setReverseHomeAwayStatus(false);
        s.setInningBreakLength(175L);
        s.setGamesInSeries(7L);
        s.setSeriesGameNumber(5L);
        s.setSeriesDescription("World Series");
        s.setRecordSource("S");
        s.setIfNecessary(false);
        s.setIfNecessaryDescription("Normal Game");

        return s;
    }

    public static Team createAwayTeam(){
        Team team = new Team();

        League springLeague = new League();
        springLeague.setId(114L);
        springLeague.setName("Cactus League");
        springLeague.setLink("/api/v1/league/114");
        springLeague.setAbbreviation("CL");
        team.setSpringLeague(springLeague);

        team.setAllStarStatus(false);
        team.setId(140L);
        team.setName("Texas Rangers");
        team.setLink("/api/v1/teams/140");
        team.setSeasons(2023L);

        Venue venue = new Venue();
        venue.setId(5325L);
        venue.setName("Globe Life Field");
        venue.setLink("/api/v1/venues/5325");
        team.setVenue(venue);

        Venue springVenue = new Venue();
        springVenue.setId(2603L);
        springVenue.setLink("/api/v1/venues/2603");
        team.setSpringVenue(springVenue);

        team.setTeamCode("tex");
        team.setFileCode("tex");
        team.setAbbreviation("TEX");
        team.setTeamName("Rangers");
        team.setLocationName("Arlington");
        team.setFirstYearOfPlay(1961L);

        League league = new League();
        league.setId(103L);
        league.setName("American League");
        league.setLink("/api/v1/league/103");
        team.setLeague(league);

        Division division = new Division();
        division.setId(200L);
        division.setName("American League West");
        division.setLink("/api/v1/divisions/200");
        team.setDivision(division);

        team.setShortName("Texas");
        team.setFranchiseName("Texas");
        team.setClubName("Rangers");
        team.setActive(true);

        return team;
    }

    public static Team createHomeTeam(){
        Team team = new Team();

        League springLeague = new League();
        springLeague.setId(114L);
        springLeague.setName("Cactus League");
        springLeague.setLink("/api/v1/league/114");
        springLeague.setAbbreviation("CL");
        team.setSpringLeague(springLeague);

        team.setAllStarStatus(false);
        team.setId(109L);
        team.setName("Arizona Diamondbacks");
        team.setLink("/api/v1/teams/109");
        team.setSeasons(2023L);

        Venue venue = new Venue();
        venue.setId(15L);
        venue.setName("Chase Field");
        venue.setLink("/api/v1/venues/15");
        team.setVenue(venue);

        Venue springVenue = new Venue();
        springVenue.setId(4249L);
        springVenue.setLink("/api/v1/venues/4249");
        team.setSpringVenue(springVenue);

        team.setTeamCode("ari");
        team.setFileCode("ari");
        team.setAbbreviation("AZ");
        team.setTeamName("D-backs");
        team.setLocationName("Phoenix");
        team.setFirstYearOfPlay(1996L);

        League league = new League();
        league.setId(104L);
        league.setName("National League");
        league.setLink("/api/v1/league/104");
        team.setLeague(league);

        Division division = new Division();
        division.setId(203L);
        division.setName("National League West");
        division.setLink("/api/v1/divisions/203");
        team.setDivision(division);

        team.setShortName("Arizona");
        team.setFranchiseName("Arizona");
        team.setClubName("Diamondbacks");
        team.setActive(true);

        return team;
    }

    public static Venue createFullVenue(){
        Venue v = new Venue();
        v.setId(15L);
        v.setName("Chase Field");
        v.setLink("/api/v1/venues/15");

        Location l = new Location();
        l.setAddress1("401 East Jefferson Street");
        l.setCity("Phoenix");
        l.setState("Arizona");
        l.setStateAbbrev("AZ");
        l.setPostalCode("85004");
        l.setLatitude(33.445302);
        l.setLongitude(-112.066687);
        l.setAzimuthAngle(0.0);
        l.setElevation(1086.0);
        l.setCountry("USA");
        l.setPhone("(602) 462-6500");
        v.setLocation(l);

        Timezone t = new Timezone();
        t.setId("America/Phoenix");
        t.setTzOffset(-7L);
        t.setOffsetAtGameTime(-7L);
        t.setTz("MST");
        v.setTimezone(t);

        FieldInfo f = new FieldInfo();
        f.setCapacity(48359L);
        f.setTurfType("Artificial Turf");
        f.setRoofType("Retractable");
        f.setLeftLine(328L);
        f.setLeftField(376L);
        f.setLeftCenter(412L);
        f.setCenterField(407L);
        f.setRightCenter(414L);
        f.setRightField(376L);
        f.setRightLine(335L);
        v.setFieldInfo(f);

        v.setActive(true);
        v.setSeason(2023L);

        return v;
    }

    public static Game createGame(){
        Game game = new Game();

        game.setGamePk(748534L);
        game.setType(new GameType("W"));
        game.setDoubleHeader(false);
        game.setTiebreaker(false);
        game.setGameNumber(1L);
        game.setSeason(2023L);
        game.setSeasonDisplay("2023");
        game.setDateTime(OffsetDateTime.of(2023, 11, 2, 0, 3, 0, 0, ZoneOffset.UTC));
        game.setOriginalDate(LocalDate.of(2023, 11, 1));
        game.setOfficialDate(LocalDate.of(2023, 11, 1));

        GameStatus status = new GameStatus();
        status.setAbstractGameState("Final");
        status.setCodedGameState("F");
        status.setDetailedState("Final");
        status.setStatusCode("F");
        status.setStartTimeTBD(false);
        status.setAbstractGameCode("F");

        game.setStatus(status);

        game.setAway(createAwayTeam());
        game.setHome(createHomeTeam());
        game.setVenue(createFullVenue());

        game.setCondition("Clear");
        game.setTemp(79L);
        game.setWind("1 mph, Varies");

        game.setAttendance(48511L);
        game.setFirstPitch(OffsetDateTime.of(2023, 11, 2, 0, 6, 0, 0, ZoneOffset.UTC));

        return game;
    }

    public static ProbablePitchers createProbablePitchers(){
        Person away = new Person();
        away.setId(543135L);
        away.setFullName("Nathan Eovaldi");
        away.setLink("/api/v1/people/543135");

        Person home = new Person();
        home.setId(668678L);
        home.setFullName("Zac Gallen");
        home.setLink("/api/v1/people/668678");

        Game game = new Game();
        game.setGamePk(748534L);

        ProbablePitchers pp = new ProbablePitchers();
        pp.setAway(away);
        pp.setHome(home);
        pp.setGame(game);

        return pp;
    }

    public static Venue createVenue(){
        Venue v = new Venue(15L);
        v.setName("Chase Field");
        v.setLink("/api/v1/venues/15");
        v.setActive(true);
        v.setSeason(2023L);
        return v;
    }

    public static Location createLocation(){
        return createLocation(null);
    }

    public static Location createLocation(Venue v){
        Location location = new Location();
        location.setAddress1("401 East Jefferson Street");
        location.setCity("Phoenix");
        location.setState("Arizona");
        location.setStateAbbrev("AZ");
        location.setPostalCode("85004");
        location.setLatitude(33.445302);
        location.setLongitude(-112.066687);
        location.setAzimuthAngle(0.0);
        location.setElevation(1086.0);
        location.setCountry("USA");
        location.setPhone("(602) 462-6500");

        if(Objects.nonNull(v)){
            location.setVenue(v);
        }

        return location;
    }

    public static FieldInfo createFieldInfo(){
        return createFieldInfo(null);
    }

    public static FieldInfo createFieldInfo(Venue v){
        FieldInfo fieldInfo = new FieldInfo();
        fieldInfo.setCapacity(48359L);
        fieldInfo.setTurfType("Artificial Turf");
        fieldInfo.setRoofType("Retractable");
        fieldInfo.setLeftLine(328L);
        fieldInfo.setLeftField(376L);
        fieldInfo.setLeftCenter(412L);
        fieldInfo.setCenterField(407L);
        fieldInfo.setRightCenter(414L);
        fieldInfo.setRightField(376L);
        fieldInfo.setRightLine(335L);

        if(Objects.nonNull(v)){
            fieldInfo.setVenue(v);
        }

        return fieldInfo;
    }

    public static Timezone createTimezone(){
        Timezone timezone = new Timezone();
        timezone.setId("America/Phoenix");
        timezone.setTzOffset(-7L);
        timezone.setOffsetAtGameTime(-7L);
        timezone.setTz("MST");
        return timezone;
    }

    public static Play createPlay(){
        Play play = new Play();

        Game game = new Game();
        game.setGamePk(748534L);
        play.setGame(game);

        play.setType("atBat");
        play.setEvent("Walk");
        play.setEventType("walk");
        play.setDescription("Ketel Marte walks.   Corbin Carroll to 2nd.");
        play.setRbi(0L);
        play.setAwayScore(0L);
        play.setHomeScore(0L);
        play.setIsOut(false);
        play.setAtBatIndex(19L);
        play.setHalfInning("bottom");
        play.setIsTopInning(false);
        play.setInning(3L);
        play.setStartTime(OffsetDateTime.of(2023, 11, 2, 0, 47, 11, 176, ZoneOffset.UTC));
        play.setEndTime(OffsetDateTime.of(2023, 11, 2, 0, 48, 52, 601, ZoneOffset.UTC));
        play.setIsComplete(true);
        play.setIsScoringPlay(false);
        play.setHasReview(false);
        play.setHasOut(false);
        play.setCaptivatingIndex(0L);
        play.setBalls(4L);
        play.setStrikes(0L);
        play.setOuts(0L);

        Person batter = new Person();
        batter.setId(606466L);
        play.setBatter(batter);

        Person pitcher = new Person();
        pitcher.setId(543135L);
        play.setPitcher(pitcher);

        return play;
    }

    public static List<Runner> createRunners(){

        Play play = new Play();
        Game game = new Game();
        game.setGamePk(748534L);
        play.setGame(game);
        play.setAtBatIndex(19L);

        Runner r1 = new Runner();
        r1.setPlay(play);
        r1.setOriginBase("1B");
        r1.setStart("1B");
        r1.setEnd("2B");
        r1.setIsOut(false);
        r1.setEvent("Walk");
        r1.setEventType("walk");
        r1.setMovementReason("r_adv_force");
        Person runner1 = new Person();
        runner1.setId(682998L);
        r1.setRunner(runner1);
        r1.setIsScoringEvent(false);
        r1.setRbi(false);
        r1.setEarned(false);
        r1.setTeamUnearned(false);
        r1.setPlayIndex(4L);

        Runner r2 = new Runner();
        r2.setPlay(play);
        r2.setEnd("1B");
        r2.setIsOut(false);
        r2.setEvent("Walk");
        r2.setEventType("walk");
        Person runner2 = new Person();
        runner2.setId(606466L);
        r2.setRunner(runner2);
        r2.setIsScoringEvent(false);
        r2.setRbi(false);
        r2.setEarned(false);
        r2.setTeamUnearned(false);
        r2.setPlayIndex(4L);

        return List.of(r1, r2);
    }

    public static List<Credit> createCredits(){
        Play play = new Play();
        Game game = new Game();
        Runner runner = new Runner();
        Person person = new Person();
        person.setId(502054L);

        game.setGamePk(748534L);
        play.setGame(game);
        play.setAtBatIndex(22L);
        runner.setPlay(play);
        runner.setRunner(person);

        Credit c1 = new Credit();
        c1.setRunner(runner);
        Person c1p = new Person();
        c1p.setId(608369L);
        c1.setPlayer(c1p);
        Position p1 = new Position();
        p1.setCode("6");
        c1.setPosition(p1);
        c1.setCredit("f_assist");

        Credit c2 = new Credit();
        c2.setRunner(runner);
        Person c2p = new Person();
        c2p.setId(663993L);
        c2.setPlayer(c2p);
        Position p2 = new Position();
        p2.setCode("3");
        c2.setPosition(p2);
        c2.setCredit("f_putout");

        return List.of(c1, c2);
    }

}
