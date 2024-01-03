package com.nxx5.baseball;

import com.google.gson.Gson;
import com.nxx5.baseball.jpa.Schedule;
import com.nxx5.baseball.mapping.Mappers;
import org.junit.jupiter.api.Test;
import org.nxx5.baseball.gson.GsonBuild;
import org.nxx5.baseball.records.Date;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class TestMapping {

    public Reader getWSScheduleReader(){
        return new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("schedule.json")));
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

}
