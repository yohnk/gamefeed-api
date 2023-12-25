package com.nxx5.baseball;

import com.nxx5.baseball.hibernate.Schedule;
import com.nxx5.baseball.hibernate.Team;
import com.nxx5.baseball.hibernate.Venue;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

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

}
