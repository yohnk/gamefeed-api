package com.nxx5.baseball;

import com.nxx5.baseball.hibernate.*;
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
        configuration.addAnnotatedClass(FieldInfo.class);
        configuration.addAnnotatedClass(Location.class);
        configuration.addAnnotatedClass(Timezone.class);

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

    @Test
    public void testVenue(){

        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        assertNull(sessionFactory.getCurrentSession().get(Venue.class, 15L));
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().merge(createVenue());
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        assertEquals(createVenue(), sessionFactory.getCurrentSession().get(Venue.class, 15L));
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        Venue v = createVenue();
        v.setLocation(createLocation());
        sessionFactory.getCurrentSession().merge(v);
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        Location location = sessionFactory.getCurrentSession().get(Location.class, 15L);
        assertEquals(createLocation(v), location);
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        v.setFieldInfo(createFieldInfo());
        sessionFactory.getCurrentSession().merge(v);
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        FieldInfo fieldInfo = sessionFactory.getCurrentSession().get(FieldInfo.class, 15L);
        assertEquals(createFieldInfo(v), fieldInfo);
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        v.setTimezone(createTimezone());
        sessionFactory.getCurrentSession().merge(v);
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        Timezone timezone = sessionFactory.getCurrentSession().get(Timezone.class, "America/Phoenix");
        assertEquals(createTimezone(), timezone);
        transaction.commit();

        transaction = sessionFactory.getCurrentSession().beginTransaction();
        Venue persisted = sessionFactory.getCurrentSession().get(Venue.class, 15L);
        assertEquals(location, persisted.getLocation());
        assertEquals(fieldInfo, persisted.getFieldInfo());
        assertEquals(timezone, persisted.getTimezone());
        transaction.commit();

    }

}
