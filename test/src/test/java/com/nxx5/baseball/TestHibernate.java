package com.nxx5.baseball;

import com.nxx5.baseball.hibernate.Schedule;
import com.nxx5.baseball.hibernate.Team;
import com.nxx5.baseball.hibernate.Venue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

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

        sessionFactory = configuration.buildSessionFactory();

    }

    public static Schedule createSchedule(){
        Schedule s = new Schedule(748534L);
        s.setGameGuid("f3f76a5b-9530-4e02-99f1-40d4ce443e8c");
        s.setLink("/api/v1.1/game/748534/feed/live");
        s.setGameType("W");
        s.setSeason(2023L);
        s.setGameDate(OffsetDateTime.of(2023, 11, 3, 0, 3, 0, 0, ZoneOffset.UTC));
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
        s.setTie(false);
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


    @Test
    public void testSchedule(){

        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        assertNull(sessionFactory.getCurrentSession().get(Schedule.class, 748534L));
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().merge(createSchedule());
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        assertEquals(createSchedule(), sessionFactory.getCurrentSession().get(Schedule.class, 748534L));
        transaction.commit();
    }

}
