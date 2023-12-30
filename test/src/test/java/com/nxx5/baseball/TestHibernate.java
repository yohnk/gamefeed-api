package com.nxx5.baseball;

import com.nxx5.baseball.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Objects;

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


        sessionFactory = configuration.buildSessionFactory();

    }

//    @AfterEach
//    public void cleanup(){
//        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
//        sessionFactory.getCurrentSession().tra
//        transaction.commit();
//    }

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
        Game game = Helpers.createGame();
        ProbablePitchers pp = Helpers.createProbablePitchers();

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

        sessionFactory.getCurrentSession().merge(game);

        sessionFactory.getCurrentSession().merge(pp.getHome());
        sessionFactory.getCurrentSession().merge(pp.getAway());
        sessionFactory.getCurrentSession().merge(pp);

        assertEquals(pp, sessionFactory.getCurrentSession().get(ProbablePitchers.class, 748534L));

        assertEquals(game, sessionFactory.getCurrentSession().get(Game.class, 748534L));
        transaction.rollback();

    }

}
