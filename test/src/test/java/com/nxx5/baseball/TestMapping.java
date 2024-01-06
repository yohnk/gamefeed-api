package com.nxx5.baseball;

import com.google.gson.Gson;
import com.nxx5.baseball.jpa.*;
import com.nxx5.baseball.mapping.Mappers;
import org.junit.jupiter.api.Test;
import org.nxx5.baseball.gson.GsonBuild;
import org.nxx5.baseball.records.Coordinates;
import org.nxx5.baseball.records.Date;
import org.nxx5.baseball.records.Status;

import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TestMapping {

    public Reader getWSScheduleReader(){
        return getFile("schedule.json");
    }

    public Reader getFile(String file){
        return new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(file)));
    }

    @Test
    public void testSchedule(){
        Gson gson = GsonBuild.builder().create();
        org.nxx5.baseball.records.Schedule api = gson.fromJson(getWSScheduleReader(), org.nxx5.baseball.records.Schedule.class);

        Mappers mapper = org.mapstruct.factory.Mappers.getMapper(Mappers.class);

        List<Schedule> convert = api.dates().stream().map(Date::games).flatMap(List::stream).map(mapper::convertSchedule).toList();

        assertNotNull(convert);
        assertEquals(1, convert.size());

        Schedule schedule = convert.get(0);
        assertNotNull(schedule);
        Schedule created = Helpers.createSchedule();
        assertEquals(created, schedule);
    }

    @Test
    public void testPosition(){
        Gson gson = GsonBuild.builder().create();
        org.nxx5.baseball.records.Position api = gson.fromJson(getFile("position.json"), org.nxx5.baseball.records.Position.class);

        Mappers mapper = org.mapstruct.factory.Mappers.getMapper(Mappers.class);

        Position position = mapper.convertPosition(api);

        assertNotNull(position);
        assertEquals("2", position.getCode());
        assertEquals("Catcher", position.getName());
        assertEquals("Catcher", position.getType());
        assertEquals("C", position.getAbbreviation());

    }

    @Test
    public void testPerson(){
        Gson gson = GsonBuild.builder().create();
        org.nxx5.baseball.records.Person api = gson.fromJson(getFile("person.json"), org.nxx5.baseball.records.Person.class);

        Mappers mapper = org.mapstruct.factory.Mappers.getMapper(Mappers.class);

        Person person = mapper.convertPerson(api);

        assertNotNull(person);
        assertEquals(694497, person.getId());
        assertEquals("Evan Carter", person.getFullName());
        assertEquals("/api/v1/people/694497", person.getLink());
        assertEquals("Evan", person.getFirstName());
        assertEquals("Carter", person.getLastName());
        assertEquals(32, person.getPrimaryNumber());
        assertEquals(LocalDate.of(2002, 8, 29), person.getBirthDate());
        assertEquals(21, person.getCurrentAge());
        assertEquals("Elizabethton", person.getBirthCity());
        assertEquals("TN", person.getBirthStateProvince());
        assertEquals("USA", person.getBirthCountry());
        assertEquals("6' 2\"", person.getHeight());
        assertEquals(190, person.getWeight());
        assertTrue(person.getActive());
        assertEquals("8", person.getPrimaryPosition().getCode());
        assertEquals("Outfielder", person.getPrimaryPosition().getName());
        assertEquals("Outfielder", person.getPrimaryPosition().getType());
        assertEquals("CF", person.getPrimaryPosition().getAbbreviation());
        assertEquals("Evan", person.getUseName());
        assertEquals("Carter", person.getUseLastName());
        assertEquals("Jason", person.getMiddleName());
        assertEquals("Carter", person.getBoxscoreName());
        assertEquals("M", person.getGender());
        assertTrue(person.getIsPlayer());
        assertTrue(person.getIsVerified());
        assertEquals(2020, person.getDraftYear());
        assertEquals(LocalDate.of(2023, 9, 8), person.getMlbDebutDate());
        assertEquals("L", person.getBatSideCode());
        assertEquals("Left", person.getBatSideDescription());
        assertEquals("R", person.getPitchHandCode());
        assertEquals("Right", person.getPitchHandDescription());
        assertEquals("Evan Carter", person.getNameFirstLast());
        assertEquals("evan-carter-694497", person.getNameSlug());
        assertEquals("Evan Carter", person.getFirstLastName());
        assertEquals("Carter, Evan", person.getLastFirstName());
        assertEquals("Carter, E", person.getLastInitName());
        assertEquals("E Carter", person.getInitLastName());
        assertEquals("Evan Jason Carter", person.getFullFMLName());
        assertEquals("Carter, Evan Jason", person.getFullLFMName());
        assertEquals(3.68, person.getStrikeZoneTop());
        assertEquals(1.72, person.getStrikeZoneBottom());
    }

    @Test
    public void testGameType(){
        Mappers mapper = org.mapstruct.factory.Mappers.getMapper(Mappers.class);
        GameType type = mapper.convertGameType("W");
        assertNotNull(type);
        assertEquals("W", type.getId());
    }

    @Test
    public void testGameStatus(){
        Mappers mapper = org.mapstruct.factory.Mappers.getMapper(Mappers.class);
        Status status = new Status("a", "b", "c", "d", true, "e");
        GameStatus converted = mapper.convertStatus(status);
        assertNotNull(converted);
        assertEquals("a", converted.getAbstractGameState());
        assertEquals("b", converted.getCodedGameState());
        assertEquals("c", converted.getDetailedState());
        assertEquals("d", converted.getStatusCode());
        assertTrue(converted.getStartTimeTBD());
        assertEquals("e", converted.getAbstractGameCode());
    }

    @Test
    public void testVenue() {
        Coordinates coords = new Coordinates(1.1, 2.1);
        org.nxx5.baseball.records.Location location = new org.nxx5.baseball.records.Location("address1", "city", "state", "stateAbbrev", "12345", coords, 3.1, 1000L, "country", "phone");
        org.nxx5.baseball.records.Timezone timezone = new org.nxx5.baseball.records.Timezone("id", 6L, 7L, "tz");
        org.nxx5.baseball.records.FieldInfo fieldInfo = new org.nxx5.baseball.records.FieldInfo(12345L, "turfType", "roofType", 1L, 2L, 3L, 4L, 5L, 6L, 7L);
        org.nxx5.baseball.records.Venue venue = new org.nxx5.baseball.records.Venue(10L, "name", "link", location, timezone, fieldInfo, false, "2023");

        Mappers mapper = org.mapstruct.factory.Mappers.getMapper(Mappers.class);

        Venue converted = mapper.convertVenue(venue);
        assertNotNull(converted);

        assertEquals(10L, converted.getId());
        assertEquals("name", converted.getName());
        assertEquals("link", converted.getLink());
        assertFalse(converted.getActive());
        assertEquals(2023, converted.getSeason());

        FieldInfo cf = converted.getFieldInfo();
        assertNotNull(cf);
        assertEquals(12345, cf.getCapacity());
        assertEquals("turfType", cf.getTurfType());
        assertEquals("roofType", cf.getRoofType());
        assertEquals(1, cf.getLeftLine());
        assertEquals(2, cf.getLeftField());
        assertEquals(3, cf.getLeftCenter());
        assertEquals(4, cf.getCenterField());
        assertEquals(5, cf.getRightCenter());
        assertEquals(6, cf.getRightField());
        assertEquals(7, cf.getRightLine());

        Timezone tz = converted.getTimezone();
        assertNotNull(tz);
        assertEquals("id", tz.getId());
        assertEquals(6, tz.getTzOffset());
        assertEquals(7, tz.getOffsetAtGameTime());
        assertEquals("tz", tz.getTz());

        Location cl = converted.getLocation();
        assertNotNull(cl);
        assertEquals("address1", cl.getAddress1());
        assertEquals("state", cl.getState());
        assertEquals("stateAbbrev", cl.getStateAbbrev());
        assertEquals("12345", cl.getPostalCode());
        assertEquals(1.1, cl.getLatitude());
        assertEquals(2.1, cl.getLongitude());
        assertEquals(3.1, cl.getAzimuthAngle());
        assertEquals(1000, cl.getElevation());
        assertEquals("country", cl.getCountry());
        assertEquals("phone", cl.getPhone());
    }

    @Test
    public void testGame(){
        Gson gson = GsonBuild.builder().create();
        org.nxx5.baseball.records.GameFeed api = gson.fromJson(getFile("gamefeed.json"), org.nxx5.baseball.records.GameFeed.class);

        Mappers mapper = org.mapstruct.factory.Mappers.getMapper(Mappers.class);
        Game game = mapper.convertGame(api);

        System.out.println();

    }

}
