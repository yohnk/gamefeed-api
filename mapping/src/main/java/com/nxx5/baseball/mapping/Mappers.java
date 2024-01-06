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
        return new GameType(type);
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

    @Mapping(target = "type", source = "result.type")
    @Mapping(target = "event", source = "result.event")
    @Mapping(target = "eventType", source = "result.eventType")
    @Mapping(target = "description", source = "result.description")
    @Mapping(target = "rbi", source = "result.rbi")
    @Mapping(target = "awayScore", source = "result.awayScore")
    @Mapping(target = "homeScore", source = "result.homeScore")
    @Mapping(target = "isOut", source = "result.isOut")
    @Mapping(target = "atBatIndex", source = "about.atBatIndex")
    @Mapping(target = "halfInning", source = "about.halfInning")
    @Mapping(target = "isTopInning", source = "about.isTopInning")
    @Mapping(target = "inning", source = "about.inning")
    @Mapping(target = "startTime", source = "about.startTime")
    @Mapping(target = "endTime", source = "about.endTime")
    @Mapping(target = "isComplete", source = "about.isComplete")
    @Mapping(target = "isScoringPlay", source = "about.isScoringPlay")
    @Mapping(target = "hasReview", source = "about.hasReview")
    @Mapping(target = "hasOut", source = "about.hasOut")
    @Mapping(target = "captivatingIndex", source = "about.captivatingIndex")
    @Mapping(target = "balls", source = "count.balls")
    @Mapping(target = "strikes", source = "count.strikes")
    @Mapping(target = "outs", source = "count.outs")
    @Mapping(target = "batter", source = "matchup.batter")
    @Mapping(target = "pitcher", source = "matchup.pitcher")
    @Mapping(target = "runners", source = "runners")
    @Mapping(target = "events", source = "playEvents")
    Play convertPlay(org.nxx5.baseball.records.Play play);

    @Mapping(target = "originBase", source = "movement.originBase")
    @Mapping(target = "start", source = "movement.start")
    @Mapping(target = "end", source = "movement.end")
    @Mapping(target = "outBase", source = "movement.outBase")
    @Mapping(target = "isOut", source = "movement.isOut")
    @Mapping(target = "outNumber", source = "movement.outNumber")
    @Mapping(target = "event", source = "details.event")
    @Mapping(target = "eventType", source = "details.eventType")
    @Mapping(target = "movementReason", source = "details.movementReason")
    @Mapping(target = "runner", source = "details.runner")
    @Mapping(target = "responsiblePitcher", source = "details.responsiblePitcher")
    @Mapping(target = "isScoringEvent", source = "details.isScoringEvent")
    @Mapping(target = "rbi", source = "details.rbi")
    @Mapping(target = "earned", source = "details.earned")
    @Mapping(target = "teamUnearned", source = "details.teamUnearned")
    @Mapping(target = "playIndex", source = "details.playIndex")
    @Mapping(target = "credits", source = "credits")
    Runner convertRunner(org.nxx5.baseball.records.Runner runner);

    @Mapping(target = "callCode", source = "details.call.code")
    @Mapping(target = "callDescription", source = "details.call.description")
    @Mapping(target = "description", source = "details.description")
    @Mapping(target = "code", source = "details.code")
    @Mapping(target = "isInPlay", source = "details.isInPlay")
    @Mapping(target = "isStrike", source = "details.isStrike")
    @Mapping(target = "isBall", source = "details.isBall")
    @Mapping(target = "event", source = "details.event")
    @Mapping(target = "eventType", source = "details.eventType")
    @Mapping(target = "awayScore", source = "details.awayScore")
    @Mapping(target = "homeScore", source = "details.homeScore")
    @Mapping(target = "isScoringPlay", source = "details.isScoringPlay")
    @Mapping(target = "pitchCode", source = "details.type.code")
    @Mapping(target = "pitchDescription", source = "details.type.description")
    @Mapping(target = "isOut", source = "details.isOut")
    @Mapping(target = "hasReview", source = "details.hasReview")
    @Mapping(target = "balls", source = "count.balls")
    @Mapping(target = "strikes", source = "count.strikes")
    @Mapping(target = "outs", source = "count.outs")
    @Mapping(target = "startSpeed", source = "pitchData.startSpeed")
    @Mapping(target = "endSpeed", source = "pitchData.endSpeed")
    @Mapping(target = "strikeZoneTop", source = "pitchData.strikeZoneTop")
    @Mapping(target = "strikeZoneBottom", source = "pitchData.strikeZoneBottom")
    @Mapping(target = "AY", source = "pitchData.coordinates.aY")
    @Mapping(target = "AZ", source = "pitchData.coordinates.aZ")
    @Mapping(target = "pfxX", source = "pitchData.coordinates.pfxX")
    @Mapping(target = "pfxZ", source = "pitchData.coordinates.pfxZ")
    @Mapping(target = "PX", source = "pitchData.coordinates.pX")
    @Mapping(target = "PZ", source = "pitchData.coordinates.pZ")
    @Mapping(target = "VX0", source = "pitchData.coordinates.vX0")
    @Mapping(target = "VY0", source = "pitchData.coordinates.vY0")
    @Mapping(target = "VZ0", source = "pitchData.coordinates.vZ0")
    @Mapping(target = "x", source = "pitchData.coordinates.x")
    @Mapping(target = "y", source = "pitchData.coordinates.y")
    @Mapping(target = "x0", source = "pitchData.coordinates.x0")
    @Mapping(target = "y0", source = "pitchData.coordinates.y0")
    @Mapping(target = "z0", source = "pitchData.coordinates.z0")
    @Mapping(target = "AX", source = "pitchData.coordinates.aX")
    @Mapping(target = "breakAngle", source = "pitchData.breaks.breakAngle")
    @Mapping(target = "breakLength", source = "pitchData.breaks.breakLength")
    @Mapping(target = "breakY", source = "pitchData.breaks.breakY")
    @Mapping(target = "breakVertical", source = "pitchData.breaks.breakVertical")
    @Mapping(target = "breakVerticalInduced", source = "pitchData.breaks.breakVerticalInduced")
    @Mapping(target = "breakHorizontal", source = "pitchData.breaks.breakHorizontal")
    @Mapping(target = "spinRate", source = "pitchData.breaks.spinRate")
    @Mapping(target = "spinDirection", source = "pitchData.breaks.spinDirection")
    @Mapping(target = "zone", source = "pitchData.zone")
    @Mapping(target = "typeConfidence", source = "pitchData.typeConfidence")
    @Mapping(target = "plateTime", source = "pitchData.plateTime")
    @Mapping(target = "extension", source = "pitchData.extension")
    @Mapping(target = "isSubstitution", source = "isSubstitution")
    @Mapping(target = "player", source = "player")
    @Mapping(target = "position", source = "position")
    @Mapping(target = "launchSpeed", source = "hitData.launchSpeed")
    @Mapping(target = "launchAngle", source = "hitData.launchAngle")
    @Mapping(target = "totalDistance", source = "hitData.totalDistance")
    @Mapping(target = "trajectory", source = "hitData.trajectory")
    @Mapping(target = "hardness", source = "hitData.hardness")
    @Mapping(target = "location", source = "hitData.location")
    @Mapping(target = "hitX", source = "hitData.coordinates.coordX")
    @Mapping(target = "hitY", source = "hitData.coordinates.coordY")
    Event convertEvent(org.nxx5.baseball.records.PlayEvent event);

    @Mapping(target = "type", source = "gameData.game.type")
    @Mapping(target = "doubleHeader", source = "gameData.game.doubleHeader")
    @Mapping(target = "tiebreaker", source = "gameData.game.tiebreaker")
    @Mapping(target = "gameNumber", source = "gameData.game.gameNumber")
    @Mapping(target = "season", source = "gameData.game.season")
    @Mapping(target = "seasonDisplay", source = "gameData.game.seasonDisplay")
    @Mapping(target = "dateTime", source = "gameData.datetime.dateTime")
    @Mapping(target = "originalDate", source = "gameData.datetime.originalDate")
    @Mapping(target = "officialDate", source = "gameData.datetime.officialDate")
    @Mapping(target = "status", source = "gameData.status")
    @Mapping(target = "away", source = "gameData.teams.away")
    @Mapping(target = "home", source = "gameData.teams.home")
    @Mapping(target = "venue", source = "gameData.venue")
    @Mapping(target = "condition", source = "gameData.weather.condition")
    @Mapping(target = "temp", source = "gameData.weather.temp")
    @Mapping(target = "wind", source = "gameData.weather.wind")
    @Mapping(target = "attendance", source = "gameData.gameInfo.attendance")
    @Mapping(target = "firstPitch", source = "gameData.gameInfo.firstPitch")
    @Mapping(target = "gameDurationMinutes", source = "gameData.gameInfo.gameDurationMinutes")
    @Mapping(target = "probablePitchers", source = "gameData.probablePitchers")
    @Mapping(target = "plays", source = "liveData.plays.allPlays")
    Game convertGame(org.nxx5.baseball.records.GameFeed api);
}
