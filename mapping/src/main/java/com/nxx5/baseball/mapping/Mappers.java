package com.nxx5.baseball.mapping;

import com.nxx5.baseball.jpa.Schedule;
import com.nxx5.baseball.jpa.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nxx5.baseball.records.ScheduledGame;

@Mapper
public interface Mappers {

    @Mapping(target="abstractGameState", source = "schedule.status.abstractGameState")
    @Mapping(target="codedGameState", source = "schedule.status.codedGameState")
    @Mapping(target="detailedState", source = "schedule.status.detailedState")
    @Mapping(target="statusCode", source = "schedule.status.statusCode")
    @Mapping(target="startTimeTBD", source = "schedule.status.startTimeTBD")
    @Mapping(target="abstractGameCode", source = "schedule.status.abstractGameCode")
    @Mapping(target="awayTeam", source = "schedule.teams.away.team")
    @Mapping(target="homeTeam", source = "schedule.teams.home.team")
    Schedule convertSchedule(ScheduledGame schedule);

    Team convertTeam(org.nxx5.baseball.records.Team team);

}
