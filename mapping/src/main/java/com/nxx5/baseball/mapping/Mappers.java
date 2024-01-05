package com.nxx5.baseball.mapping;

import com.nxx5.baseball.jpa.*;
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

    Position convertPosition(org.nxx5.baseball.records.Position position);

    @Mapping(target="batSideCode", source = "batSide.code")
    @Mapping(target="batSideDescription", source = "batSide.description")
    @Mapping(target="pitchHandCode", source = "pitchHand.code")
    @Mapping(target="pitchHandDescription", source = "pitchHand.description")
    Person convertPerson(org.nxx5.baseball.records.Person person);

    default GameType convertGameType(String type) {
        GameType gameType = new GameType();
        gameType.setId(type);
        return gameType;
    }

    GameStatus convertStatus(org.nxx5.baseball.records.Status status);

    @Mapping(target = "timezone", source = "timeZone")
    Venue convertVenue(org.nxx5.baseball.records.Venue venue);

    @Mapping(target="latitude", source="defaultCoordinates.latitude")
    @Mapping(target="longitude", source="defaultCoordinates.longitude")
    Location convertLocation(org.nxx5.baseball.records.Location location);

    @Mapping(target = "tzOffset", source = "offset")
    Timezone convertTimezone(org.nxx5.baseball.records.Timezone timezone);

    @Mapping(target="leftField", source="left")
    @Mapping(target="centerField", source="center")
    @Mapping(target="rightField", source="right")
    FieldInfo convertFieldInfo(org.nxx5.baseball.records.FieldInfo fieldInfo);

}
