package org.nxx5.baseball.records;

public record GameFeed(Long gamePk, String link, MetaData metaData, GameData gameData, LiveData liveData) {
}
