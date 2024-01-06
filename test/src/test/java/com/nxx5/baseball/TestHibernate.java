package com.nxx5.baseball;

import com.nxx5.baseball.jpa.*;
import jakarta.persistence.Query;
import org.hibernate.CacheMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class TestHibernate {

    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void createSession(){

        if(Objects.nonNull(sessionFactory)){
            sessionFactory.close();
            sessionFactory = null;
        }

        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        configuration.setProperty("hibernate.current_session_context_class", "thread");

        configuration.addAnnotatedClass(Schedule.class);
        configuration.addAnnotatedClass(Team.class);
        configuration.addAnnotatedClass(Venue.class);
        configuration.addAnnotatedClass(FieldInfo.class);
        configuration.addAnnotatedClass(Location.class);
        configuration.addAnnotatedClass(Timezone.class);
        configuration.addAnnotatedClass(Division.class);
        configuration.addAnnotatedClass(Game.class);
        configuration.addAnnotatedClass(GameStatus.class);
        configuration.addAnnotatedClass(GameType.class);
        configuration.addAnnotatedClass(League.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Position.class);
        configuration.addAnnotatedClass(ProbablePitchers.class);
        configuration.addAnnotatedClass(SeasonDateInfo.class);
        configuration.addAnnotatedClass(Sport.class);
        configuration.addAnnotatedClass(Play.class);
        configuration.addAnnotatedClass(Runner.class);
        configuration.addAnnotatedClass(Credit.class);
        configuration.addAnnotatedClass(Event.class);
        configuration.addAnnotatedClass(Batter.class);
        configuration.addAnnotatedClass(BattingOrder.class);
        configuration.addAnnotatedClass(Bench.class);
        configuration.addAnnotatedClass(Bullpen.class);
        configuration.addAnnotatedClass(GamePosition.class);
        configuration.addAnnotatedClass(Pitcher.class);


        sessionFactory = configuration.buildSessionFactory();

    }

    @Test
    public void testSchedule(){

        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        assertNull(sessionFactory.getCurrentSession().get(Schedule.class, 748534L));
        sessionFactory.getCurrentSession().merge(Helpers.createSchedule());
        assertEquals(Helpers.createSchedule(), sessionFactory.getCurrentSession().get(Schedule.class, 748534L));
        transaction.rollback();
    }

    @Test
    public void testVenue(){

        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

        assertNull(sessionFactory.getCurrentSession().get(Venue.class, 15L));
        sessionFactory.getCurrentSession().merge(Helpers.createVenue());
        assertEquals(Helpers.createVenue(), sessionFactory.getCurrentSession().get(Venue.class, 15L));

        Venue v = Helpers.createVenue();
        v.setLocation(Helpers.createLocation());
        sessionFactory.getCurrentSession().merge(v);

        Location location = sessionFactory.getCurrentSession().get(Location.class, 15L);
        assertEquals(Helpers.createLocation(v), location);

        v.setFieldInfo(Helpers.createFieldInfo());
        sessionFactory.getCurrentSession().merge(v);

        FieldInfo fieldInfo = sessionFactory.getCurrentSession().get(FieldInfo.class, 15L);
        assertEquals(Helpers.createFieldInfo(v), fieldInfo);

        v.setTimezone(Helpers.createTimezone());
        sessionFactory.getCurrentSession().merge(v);

        Timezone timezone = sessionFactory.getCurrentSession().get(Timezone.class, "America/Phoenix");
        assertEquals(Helpers.createTimezone(), timezone);

        Venue persisted = sessionFactory.getCurrentSession().get(Venue.class, 15L);
        assertEquals(location, persisted.getLocation());
        assertEquals(fieldInfo, persisted.getFieldInfo());
        assertEquals(timezone, persisted.getTimezone());

        transaction.rollback();

    }

    @Test
    public void testGame(){
        Play play = Helpers.createPlay();
        Game game = Helpers.createGame();
        ProbablePitchers pp = Helpers.createProbablePitchers();
        List<Runner> runners = Helpers.createRunners();
        List<Credit> credits = Helpers.createCredits();
        runners.get(0).setCredits(new HashSet<>(credits));
        runners.forEach(play::addRunner);
        Helpers.createEvents().forEach(play::addEvent);
        game.setProbablePitchers(pp);
        game.addPlay(play);
        Helpers.createGamePositions().forEach(game::addGamePosition);
        Helpers.createBatters().forEach(game::addBatter);
        Helpers.createPitchers().forEach(game::addPitcher);
        Helpers.createBench().forEach(game::addBench);
        Helpers.createBullpen().forEach(game::addBullpen);
        Helpers.createBattingOrder().forEach(game::addBattingOrder);

        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

        assertNull(sessionFactory.getCurrentSession().get(Game.class, game.getGamePk()));
        assertNull(sessionFactory.getCurrentSession().get(Team.class, game.getAway().getLeague().getId()));
        assertNull(sessionFactory.getCurrentSession().get(Team.class, game.getAway().getSpringLeague().getId()));
        assertNull(sessionFactory.getCurrentSession().get(Team.class, game.getAway().getDivision().getId()));
        assertNull(sessionFactory.getCurrentSession().get(Team.class, game.getAway().getVenue().getId()));
        assertNull(sessionFactory.getCurrentSession().get(Team.class, game.getAway().getId()));
        assertNull(sessionFactory.getCurrentSession().get(Team.class, game.getHome().getLeague().getId()));
        assertNull(sessionFactory.getCurrentSession().get(Team.class, game.getHome().getSpringLeague().getId()));
        assertNull(sessionFactory.getCurrentSession().get(Team.class, game.getHome().getDivision().getId()));
        assertNull(sessionFactory.getCurrentSession().get(Team.class, game.getHome().getId()));
        assertNull(sessionFactory.getCurrentSession().get(Venue.class, game.getVenue().getId()));
        assertNull(sessionFactory.getCurrentSession().get(ProbablePitchers.class, pp.getGame().getGamePk()));

        sessionFactory.getCurrentSession().merge(game.getAway().getLeague());
        sessionFactory.getCurrentSession().merge(game.getAway().getSpringLeague());
        sessionFactory.getCurrentSession().merge(game.getAway().getDivision());
        sessionFactory.getCurrentSession().merge(game.getAway().getVenue());
        sessionFactory.getCurrentSession().merge(game.getAway().getSpringVenue());
        sessionFactory.getCurrentSession().merge(game.getAway());

        sessionFactory.getCurrentSession().merge(game.getHome().getLeague());
        sessionFactory.getCurrentSession().merge(game.getHome().getSpringLeague());
        sessionFactory.getCurrentSession().merge(game.getHome().getDivision());
        sessionFactory.getCurrentSession().merge(game.getHome().getVenue());
        sessionFactory.getCurrentSession().merge(game.getHome().getSpringVenue());
        sessionFactory.getCurrentSession().merge(game.getHome());

        sessionFactory.getCurrentSession().merge(game.getStatus());
        sessionFactory.getCurrentSession().merge(game.getType());

        sessionFactory.getCurrentSession().merge(game.getProbablePitchers().getHome());
        sessionFactory.getCurrentSession().merge(game.getProbablePitchers().getAway());

        for(GamePosition gp : game.getGamePositions()){
            sessionFactory.getCurrentSession().merge(gp.getTeam());
            sessionFactory.getCurrentSession().merge(gp.getBatter());
            sessionFactory.getCurrentSession().merge(gp.getPosition());
        }

        for(Play p : game.getPlays()){
            sessionFactory.getCurrentSession().merge(p.getBatter());
            sessionFactory.getCurrentSession().merge(p.getPitcher());
            for(Event e : p.getEvents()){
                if(e.getPosition() != null) {
                    sessionFactory.getCurrentSession().merge(e.getPosition());
                }
                if(e.getPlayer() != null) {
                    sessionFactory.getCurrentSession().merge(e.getPlayer());
                }
            }
            for(Runner r : p.getRunners()){
                if(r.getResponsiblePitcher() != null) {
                    sessionFactory.getCurrentSession().merge(r.getResponsiblePitcher());
                }
                if(r.getRunner() != null) {
                    sessionFactory.getCurrentSession().merge(r.getRunner());
                }
            }
        }

        for(Batter b : game.getBatters()){
            sessionFactory.getCurrentSession().merge(b.getBatter());
            sessionFactory.getCurrentSession().merge(b.getTeam());
        }

        for(Credit c : credits){
            sessionFactory.getCurrentSession().merge(c.getPlayer());
            sessionFactory.getCurrentSession().merge(c.getPosition());
        }

        sessionFactory.getCurrentSession().merge(game);
        
        assertEquals(pp, sessionFactory.getCurrentSession().get(ProbablePitchers.class, 748534L));
        Play persistedPlay = sessionFactory.getCurrentSession().get(Play.class, play);

        assertEquals(play, persistedPlay);
        Game persistedGame = sessionFactory.getCurrentSession().get(Game.class, 748534L);
        assertEquals(persistedGame.getPlays(), Set.of(play));
        assertEquals(persistedGame.getGamePositions(), game.getGamePositions());
        assertEquals(persistedGame.getBatters(), game.getBatters());
        assertEquals(persistedGame.getPitchers(), game.getPitchers());
        assertEquals(persistedGame.getBench(), game.getBench());
        assertEquals(persistedGame.getBullpen(), game.getBullpen());
        assertEquals(persistedGame.getBattingOrder(), game.getBattingOrder());
        assertEquals(game, persistedGame);

        transaction.rollback();

    }

    @Test
    public void testPlay(){
        Play play = Helpers.createPlay();

        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

        assertNull(sessionFactory.getCurrentSession().get(Play.class, new Play(play.getGame(), play.getAtBatIndex())));

        sessionFactory.getCurrentSession().merge(play.getGame());
        sessionFactory.getCurrentSession().merge(play.getBatter());
        sessionFactory.getCurrentSession().merge(play.getPitcher());
        sessionFactory.getCurrentSession().merge(play);

        assertEquals(Helpers.createPlay(), sessionFactory.getCurrentSession().get(Play.class, play));

        transaction.rollback();
    }

    @Test
    public void testRunner(){
        List<Runner> runners = Helpers.createRunners();

        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

        for(Runner runner : runners){
            assertNull(sessionFactory.getCurrentSession().get(Runner.class, new Runner(runner.getPlay(), runner.getRunner())));
        }

        Play play = runners.get(0).getPlay();
        Game game = play.getGame();

        sessionFactory.getCurrentSession().merge(game);
        sessionFactory.getCurrentSession().merge(play);

        for(Runner runner : runners){
            sessionFactory.getCurrentSession().merge(runner.getRunner());
            sessionFactory.getCurrentSession().merge(runner);
        }

        for(Runner runner : runners){
            Runner fetched = sessionFactory.getCurrentSession().get(Runner.class, new Runner(runner.getPlay(), runner.getRunner()));
            assertEquals(runner, fetched);
        }

        transaction.rollback();

    }

    @Test
    public void testCredit(){
        List<Credit> credits = Helpers.createCredits();

        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

        for(Credit credit : credits){
            assertNull(sessionFactory.getCurrentSession().get(Credit.class, new Credit(credit.getRunner(), credit.getPlayer())));
        }

        Runner runner = credits.get(0).getRunner();
        Play play = runner.getPlay();
        Game game = play.getGame();

        sessionFactory.getCurrentSession().merge(game);
        sessionFactory.getCurrentSession().merge(play);
        sessionFactory.getCurrentSession().merge(runner);

        for(Credit credit : credits){
            sessionFactory.getCurrentSession().merge(credit.getPlayer());
            sessionFactory.getCurrentSession().merge(credit.getPosition());
            sessionFactory.getCurrentSession().merge(credit);
        }

        for(Credit credit : credits){
            Credit fetched = sessionFactory.getCurrentSession().get(Credit.class, new Credit(credit.getRunner(), credit.getPlayer()));
            assertEquals(credit, fetched);
        }

        transaction.rollback();
    }

    @Test
    public void testEvent(){
        List<Event> events = Helpers.createEvents();

        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

        for(Event event : events){
            assertNull(sessionFactory.getCurrentSession().get(Event.class, new Event(event.getPlay(), event.getIndex())));
        }

        Play play = events.get(0).getPlay();
        Game game = play.getGame();

        sessionFactory.getCurrentSession().merge(game);
        sessionFactory.getCurrentSession().merge(play);

        for(Event event : events){
            if(event.getPlayer() != null){
                sessionFactory.getCurrentSession().merge(event.getPlayer());
            }
            if(event.getPosition() != null){
                sessionFactory.getCurrentSession().merge(event.getPosition());
            }

            sessionFactory.getCurrentSession().merge(event);
        }

        for(Event event : events){
            assertEquals(event, sessionFactory.getCurrentSession().get(Event.class, new Event(event.getPlay(), event.getIndex())));
        }

        transaction.rollback();
    }

    @Test
    public void testBatters(){
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

        Query query = sessionFactory.getCurrentSession().createQuery("select count(*) from batter");
        assertEquals(0, query.getFirstResult());

        Game g = new Game();
        g.setGamePk(748534L);
        sessionFactory.getCurrentSession().merge(g);

        Team away = new Team();
        away.setId(140L);
        sessionFactory.getCurrentSession().merge(away);

        Team home = new Team();
        home.setId(109L);
        sessionFactory.getCurrentSession().merge(home);

        List<Batter> batters = Helpers.createBatters();

        for(Batter b : batters){
            sessionFactory.getCurrentSession().merge(b.getBatter());
            sessionFactory.getCurrentSession().merge(b);
        }

        query = sessionFactory.getCurrentSession().createQuery("select b from batter b");
        assertEquals(new HashSet<>(batters), new HashSet<>(query.getResultList()));

        query = sessionFactory.getCurrentSession().createQuery("select b from batter b where team = :team_id");
        query.setParameter("team_id", away);
        assertEquals(new HashSet<>(Helpers.createAwayBatters()), new HashSet<>(query.getResultList()));

        query = sessionFactory.getCurrentSession().createQuery("select b from batter b where team = :team_id");
        query.setParameter("team_id", home);
        assertEquals(new HashSet<>(Helpers.createHomeBatters()), new HashSet<>(query.getResultList()));


        transaction.rollback();

    }

    @Test
    public void testBattingOrder(){
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

        Query query = sessionFactory.getCurrentSession().createQuery("select count(*) from batting_order");
        assertEquals(0, query.getFirstResult());

        Game g = new Game();
        g.setGamePk(748534L);
        sessionFactory.getCurrentSession().merge(g);

        Team away = new Team();
        away.setId(140L);
        sessionFactory.getCurrentSession().merge(away);

        Team home = new Team();
        home.setId(109L);
        sessionFactory.getCurrentSession().merge(home);

        List<BattingOrder> batters = Helpers.createBattingOrder();

        for(BattingOrder b : batters){
            sessionFactory.getCurrentSession().merge(b.getBatter());
            sessionFactory.getCurrentSession().merge(b);
        }

        query = sessionFactory.getCurrentSession().createQuery("select b from batting_order b");
        assertEquals(new HashSet<>(batters), new HashSet<>(query.getResultList()));

        query = sessionFactory.getCurrentSession().createQuery("select b from batting_order b where team = :team_id");
        query.setParameter("team_id", away);
        assertEquals(new HashSet<>(Helpers.createAwayBattingOrder()), new HashSet<>(query.getResultList()));

        query = sessionFactory.getCurrentSession().createQuery("select b from batting_order b where team = :team_id");
        query.setParameter("team_id", home);
        assertEquals(new HashSet<>(Helpers.createHomeBattingOrder()), new HashSet<>(query.getResultList()));

        BattingOrder homeLeadoff = new BattingOrder();
        Person p = new Person();
        p.setId(682998L);
        homeLeadoff.setBatter(p);
        homeLeadoff.setTeam(home);
        homeLeadoff.setGame(g);
        homeLeadoff.setPosition(1L);

        BattingOrder awayLeadoff = new BattingOrder();
        p = new Person();
        p.setId(543760L);
        awayLeadoff.setBatter(p);
        awayLeadoff.setTeam(away);
        awayLeadoff.setGame(g);
        awayLeadoff.setPosition(1L);

        query = sessionFactory.getCurrentSession().createQuery("select b from batting_order b where position = 1");
        assertEquals(new HashSet<>(List.of(homeLeadoff, awayLeadoff)), new HashSet<>(query.getResultList()));

        transaction.rollback();

    }

}
