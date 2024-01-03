package com.nxx5.baseball;

import com.nxx5.baseball.jpa.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.LinkedList;
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

    public static List<Event> createEvents(){
        Game game = new Game();
        game.setGamePk(748534L);

        Play play = new Play();
        play.setGame(game);
        play.setAtBatIndex(50L);

        Event e1 = new Event();
        e1.setPlay(play);
        e1.setDescription("Mound Visit.");
        e1.setEvent("Mount Visit");
        e1.setAwayScore(1L);
        e1.setHomeScore(0L);
        e1.setIsScoringPlay(false);
        e1.setIsOut(false);
        e1.setHasReview(false);
        e1.setBalls(0L);
        e1.setStrikes(0L);
        e1.setOuts(1L);
        e1.setIndex(0L);
        e1.setStartTime(OffsetDateTime.of(2023, 11, 2, 1, 59, 55, 469, ZoneOffset.UTC));
        e1.setEndTime(OffsetDateTime.of(2023, 11, 2, 2, 0, 40, 800, ZoneOffset.UTC));
        e1.setIsPitch(false);
        e1.setType("action");

        Event e2 = new Event();
        e2.setPlay(play);
        e2.setDescription("Pitching Change: Kevin Ginkel replaces Zac Gallen.");
        e2.setEvent("Pitching Substitution");
        e2.setEventType("pitching_substitution");
        e2.setAwayScore(1L);
        e2.setHomeScore(0L);
        e2.setAwayScore(1L);
        e2.setHomeScore(0L);
        e2.setIsScoringPlay(false);
        e2.setIsOut(false);
        e2.setHasReview(false);
        e2.setBalls(0L);
        e2.setStrikes(0L);
        e2.setOuts(1L);
        e2.setIndex(1L);
        e2.setStartTime(OffsetDateTime.of(2023, 11, 2, 2, 0, 40, 800, ZoneOffset.UTC));
        e2.setEndTime(OffsetDateTime.of(2023, 11, 2, 2, 3, 3, 707, ZoneOffset.UTC));
        e2.setIsPitch(false);
        e2.setIsSubstitution(true);
        e2.setType("action");

        Person player = new Person();
        player.setId(656464L);
        e2.setPlayer(player);

        Position position = new Position();
        position.setCode("1");
        e2.setPosition(position);

        Event e3 = new Event();
        e3.setPlay(play);
        e3.setCallCode("B");
        e3.setCallDescription("Ball");
        e3.setDescription("Ball");
        e3.setCode("B");
        e3.setIsInPlay(false);
        e3.setIsStrike(false);
        e3.setIsBall(true);
        e3.setPitchCode("FF");
        e3.setPitchDescription("Four-Seam Fastball");
        e3.setIsOut(false);
        e3.setHasReview(false);
        e3.setBalls(1L);
        e3.setStrikes(0L);
        e3.setOuts(1L);
        e3.setStartSpeed(95.6);
        e3.setEndSpeed(86.8);
        e3.setStrikeZoneTop(3.57766939176536);
        e3.setStrikeZoneBottom(1.6808013671999);
        e3.setAY(32.93552022471541);
        e3.setAZ(-16.21682988278894);
        e3.setPfxX(-4.929628813368872);
        e3.setPfxZ(8.2237849271907);
        e3.setPX(0.5850466968357034);
        e3.setPZ(3.7251815992892547);
        e3.setVX0(9.226940295181011);
        e3.setVY0(-138.84790476986672);
        e3.setVZ0(-3.7885089394994553);
        e3.setX(94.7);
        e3.setY(138.2);
        e3.setX0(-2.1502397247864065);
        e3.setY0(50.00199776629153);
        e3.setZ0(6.195885241771316);
        e3.setAX(-9.565230502980956);
        e3.setBreakAngle(24.0);
        e3.setBreakLength(3.6);
        e3.setBreakY(24.0);
        e3.setBreakVertical(-16.0);
        e3.setBreakVerticalInduced(14.2);
        e3.setBreakHorizontal(6.8);
        e3.setSpinRate(2488.0);
        e3.setSpinDirection(222.0);
        e3.setZone(12L);
        e3.setTypeConfidence(0.92);
        e3.setPlateTime(0.3954467429462043);
        e3.setExtension(6.909284718878651);
        e3.setIndex(2L);
        e3.setPlayId("de33d49e-2ff0-43bd-868c-3a6f2994d124");
        e3.setPitchNumber(1L);
        e3.setStartTime(OffsetDateTime.of(2023, 11, 2, 2, 3, 3, 707, ZoneOffset.UTC));
        e3.setEndTime(OffsetDateTime.of(2023, 11, 2, 2, 3, 7, 462, ZoneOffset.UTC));
        e3.setIsPitch(true);
        e3.setType("pitch");

        return List.of(e1, e2, e3);
    }

    public static List<Batter> createHomeBatters(){
        List<Batter> batters = new LinkedList<>();

        Game game = new Game();
        game.setGamePk(748534L);

        Team home = new Team();
        home.setId(109L);

        List<Long> homeIds = List.of(682998L, 606466L, 672515L, 572233L, 502054L, 666971L, 677950L, 446334L, 656976L, 656896L, 672695L, 668678L, 656464L, 623149L);

        for(Long id : homeIds){
            Person person = new Person();
            person.setId(id);

            Batter batter = new Batter();
            batter.setBatter(person);
            batter.setTeam(home);
            batter.setGame(game);

            batters.add(batter);
        }

        return batters;
    }

    public static List<Batter> createAwayBatters(){
        List<Batter> batters = new LinkedList<>();

        Game game = new Game();
        game.setGamePk(748534L);

        Team away = new Team();
        away.setId(140L);

        List<Long> awayIds = List.of(543760L, 608369L, 694497L, 641598L, 673962L, 663993L, 641680L, 665750L, 608671L, 543135L, 547973L, 622250L);

        for(Long id : awayIds){
            Person person = new Person();
            person.setId(id);

            Batter batter = new Batter();
            batter.setBatter(person);
            batter.setTeam(away);
            batter.setGame(game);

            batters.add(batter);
        }

        return batters;
    }

    public static List<Batter> createBatters(){
        List<Batter> batters = new LinkedList<>();
        batters.addAll(createHomeBatters());
        batters.addAll(createAwayBatters());
        return batters;
    }


    public static List<BattingOrder> createHomeBattingOrder(){
        List<BattingOrder> output = new LinkedList<>();
        List<Long> battingOrder = List.of(682998L, 606466L, 672515L, 572233L, 502054L, 666971L, 677950L, 656896L, 672695L);

        Game game = new Game();
        game.setGamePk(748534L);

        Team home = new Team();
        home.setId(109L);

        for(int i = 0; i < battingOrder.size(); i++){
            BattingOrder bo = new BattingOrder();
            bo.setTeam(home);
            bo.setGame(game);
            bo.setPosition((long)i + 1);

            Person person = new Person();
            person.setId(battingOrder.get(i));

            bo.setBatter(person);
            output.add(bo);
        }

        return output;
    }

    public static List<BattingOrder> createAwayBattingOrder(){
        List<BattingOrder> output = new LinkedList<>();
        List<Long> battingOrder = List.of(543760L, 608369L, 694497L, 641598L, 673962L, 663993L, 641680L, 665750L, 608671L);

        Game game = new Game();
        game.setGamePk(748534L);

        Team away = new Team();
        away.setId(140L);

        for(int i = 0; i < battingOrder.size(); i++){
            BattingOrder bo = new BattingOrder();
            bo.setTeam(away);
            bo.setGame(game);
            bo.setPosition((long)i + 1);

            Person person = new Person();
            person.setId(battingOrder.get(i));

            bo.setBatter(person);
            output.add(bo);
        }

        return output;
    }

    public static List<BattingOrder> createBattingOrder(){
        List<BattingOrder> output = new LinkedList<>();
        output.addAll(createHomeBattingOrder());
        output.addAll(createAwayBattingOrder());
        return output;
    }

}
