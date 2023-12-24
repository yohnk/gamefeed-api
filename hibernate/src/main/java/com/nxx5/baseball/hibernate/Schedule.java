package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity(name = "schedule")
public class Schedule {

    public Schedule() {
    }

    public Schedule(Long gamePk) {
        this.gamePk = gamePk;
    }

    @Id
    private Long gamePk;

    @Column
    private String gameGuid;

    @Column
    private String link;

    @Column
    private String gameType;

    @Column
    private Long season;

    @Column
    private OffsetDateTime gameDate;

    @Column
    private LocalDate officialDate;

    @Column
    private String abstractGameState;

    @Column
    private String codedGameState;

    @Column
    private String detailedState;

    @Column
    private String statusCode;

    @Column
    private Boolean startTimeTBD;

    @Column
    private String abstractGameCode;

    @ManyToOne
    @Cascade(CascadeType.MERGE)
    private Team awayTeam;

    @ManyToOne
    @Cascade(CascadeType.MERGE)
    private Team homeTeam;

    @ManyToOne
    @Cascade(CascadeType.MERGE)
    private Venue venue;

    @Column
    private Boolean isTie;

    @Column
    private Long gameNumber;

    @Column
    private Boolean doubleHeader;

    @Column
    private String gamedayType;

    @Column
    private Boolean tiebreaker;

    @Column
    private String calendarEventID;

    @Column
    private String seasonDisplay;

    @Column
    private String dayNight;

    @Column
    private String description;

    @Column
    private Long scheduledInnings;

    @Column
    private Boolean reverseHomeAwayStatus;

    @Column
    private Long inningBreakLength;

    @Column
    private Long gamesInSeries;

    @Column
    private Long seriesGameNumber;

    @Column
    private String seriesDescription;

    @Column
    private String recordSource;

    @Column
    private Boolean ifNecessary;

    @Column
    private String ifNecessaryDescription;

    public Long getGamePk() {
        return gamePk;
    }

    public void setGamePk(Long gamePk) {
        this.gamePk = gamePk;
    }

    public String getGameGuid() {
        return gameGuid;
    }

    public void setGameGuid(String gameGuid) {
        this.gameGuid = gameGuid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public Long getSeason() {
        return season;
    }

    public void setSeason(Long season) {
        this.season = season;
    }

    public OffsetDateTime getGameDate() {
        return gameDate;
    }

    public void setGameDate(OffsetDateTime gameDate) {
        this.gameDate = gameDate;
    }

    public LocalDate getOfficialDate() {
        return officialDate;
    }

    public void setOfficialDate(LocalDate officialDate) {
        this.officialDate = officialDate;
    }

    public String getAbstractGameState() {
        return abstractGameState;
    }

    public void setAbstractGameState(String abstractGameState) {
        this.abstractGameState = abstractGameState;
    }

    public String getCodedGameState() {
        return codedGameState;
    }

    public void setCodedGameState(String codedGameState) {
        this.codedGameState = codedGameState;
    }

    public String getDetailedState() {
        return detailedState;
    }

    public void setDetailedState(String detailedState) {
        this.detailedState = detailedState;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Boolean getStartTimeTBD() {
        return startTimeTBD;
    }

    public void setStartTimeTBD(Boolean startTimeTBD) {
        this.startTimeTBD = startTimeTBD;
    }

    public String getAbstractGameCode() {
        return abstractGameCode;
    }

    public void setAbstractGameCode(String abstractGameCode) {
        this.abstractGameCode = abstractGameCode;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Boolean getTie() {
        return isTie;
    }

    public void setTie(Boolean tie) {
        isTie = tie;
    }

    public Long getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(Long gameNumber) {
        this.gameNumber = gameNumber;
    }

    public Boolean getDoubleHeader() {
        return doubleHeader;
    }

    public void setDoubleHeader(Boolean doubleHeader) {
        this.doubleHeader = doubleHeader;
    }

    public String getGamedayType() {
        return gamedayType;
    }

    public void setGamedayType(String gamedayType) {
        this.gamedayType = gamedayType;
    }

    public Boolean getTiebreaker() {
        return tiebreaker;
    }

    public void setTiebreaker(Boolean tiebreaker) {
        this.tiebreaker = tiebreaker;
    }

    public String getCalendarEventID() {
        return calendarEventID;
    }

    public void setCalendarEventID(String calendarEventID) {
        this.calendarEventID = calendarEventID;
    }

    public String getSeasonDisplay() {
        return seasonDisplay;
    }

    public void setSeasonDisplay(String seasonDisplay) {
        this.seasonDisplay = seasonDisplay;
    }

    public String getDayNight() {
        return dayNight;
    }

    public void setDayNight(String dayNight) {
        this.dayNight = dayNight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getScheduledInnings() {
        return scheduledInnings;
    }

    public void setScheduledInnings(Long scheduledInnings) {
        this.scheduledInnings = scheduledInnings;
    }

    public Boolean getReverseHomeAwayStatus() {
        return reverseHomeAwayStatus;
    }

    public void setReverseHomeAwayStatus(Boolean reverseHomeAwayStatus) {
        this.reverseHomeAwayStatus = reverseHomeAwayStatus;
    }

    public Long getInningBreakLength() {
        return inningBreakLength;
    }

    public void setInningBreakLength(Long inningBreakLength) {
        this.inningBreakLength = inningBreakLength;
    }

    public Long getGamesInSeries() {
        return gamesInSeries;
    }

    public void setGamesInSeries(Long gamesInSeries) {
        this.gamesInSeries = gamesInSeries;
    }

    public Long getSeriesGameNumber() {
        return seriesGameNumber;
    }

    public void setSeriesGameNumber(Long seriesGameNumber) {
        this.seriesGameNumber = seriesGameNumber;
    }

    public String getSeriesDescription() {
        return seriesDescription;
    }

    public void setSeriesDescription(String seriesDescription) {
        this.seriesDescription = seriesDescription;
    }

    public String getRecordSource() {
        return recordSource;
    }

    public void setRecordSource(String recordSource) {
        this.recordSource = recordSource;
    }

    public Boolean getIfNecessary() {
        return ifNecessary;
    }

    public void setIfNecessary(Boolean ifNecessary) {
        this.ifNecessary = ifNecessary;
    }

    public String getIfNecessaryDescription() {
        return ifNecessaryDescription;
    }

    public void setIfNecessaryDescription(String ifNecessaryDescription) {
        this.ifNecessaryDescription = ifNecessaryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(gamePk, schedule.gamePk) && Objects.equals(gameGuid, schedule.gameGuid) && Objects.equals(link, schedule.link) && Objects.equals(gameType, schedule.gameType) && Objects.equals(season, schedule.season) && Objects.equals(gameDate, schedule.gameDate) && Objects.equals(officialDate, schedule.officialDate) && Objects.equals(abstractGameState, schedule.abstractGameState) && Objects.equals(codedGameState, schedule.codedGameState) && Objects.equals(detailedState, schedule.detailedState) && Objects.equals(statusCode, schedule.statusCode) && Objects.equals(startTimeTBD, schedule.startTimeTBD) && Objects.equals(abstractGameCode, schedule.abstractGameCode) && Objects.equals(awayTeam, schedule.awayTeam) && Objects.equals(homeTeam, schedule.homeTeam) && Objects.equals(venue, schedule.venue) && Objects.equals(isTie, schedule.isTie) && Objects.equals(gameNumber, schedule.gameNumber) && Objects.equals(doubleHeader, schedule.doubleHeader) && Objects.equals(gamedayType, schedule.gamedayType) && Objects.equals(tiebreaker, schedule.tiebreaker) && Objects.equals(calendarEventID, schedule.calendarEventID) && Objects.equals(seasonDisplay, schedule.seasonDisplay) && Objects.equals(dayNight, schedule.dayNight) && Objects.equals(description, schedule.description) && Objects.equals(scheduledInnings, schedule.scheduledInnings) && Objects.equals(reverseHomeAwayStatus, schedule.reverseHomeAwayStatus) && Objects.equals(inningBreakLength, schedule.inningBreakLength) && Objects.equals(gamesInSeries, schedule.gamesInSeries) && Objects.equals(seriesGameNumber, schedule.seriesGameNumber) && Objects.equals(seriesDescription, schedule.seriesDescription) && Objects.equals(recordSource, schedule.recordSource) && Objects.equals(ifNecessary, schedule.ifNecessary) && Objects.equals(ifNecessaryDescription, schedule.ifNecessaryDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamePk, gameGuid, link, gameType, season, gameDate, officialDate, abstractGameState, codedGameState, detailedState, statusCode, startTimeTBD, abstractGameCode, awayTeam, homeTeam, venue, isTie, gameNumber, doubleHeader, gamedayType, tiebreaker, calendarEventID, seasonDisplay, dayNight, description, scheduledInnings, reverseHomeAwayStatus, inningBreakLength, gamesInSeries, seriesGameNumber, seriesDescription, recordSource, ifNecessary, ifNecessaryDescription);
    }
}
