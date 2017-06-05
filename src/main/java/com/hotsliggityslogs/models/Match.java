package com.hotsliggityslogs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "match")
public class Match {
    @Id
    private String id;
    private String matchType;
    private String mapName;
    private String matchLength;
    private String heroName;
    private String heroLevel;
    private String matchmakingRating;
    private String ratingAdjustmentPoints;
    private String matchDate;
    private String matchTime;
    private String matchOutcome;
    private String season;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getMatchLength() {
        return matchLength;
    }

    public void setMatchLength(String matchLength) {
        this.matchLength = matchLength;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(String heroLevel) {
        this.heroLevel = heroLevel;
    }

    public String getMatchmakingRating() {
        return matchmakingRating;
    }

    public void setMatchmakingRating(String matchmakingRating) {
        this.matchmakingRating = matchmakingRating;
    }

    public String getRatingAdjustmentPoints() {
        return ratingAdjustmentPoints;
    }

    public void setRatingAdjustmentPoints(String ratingAdjustmentPoints) {
        this.ratingAdjustmentPoints = ratingAdjustmentPoints;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getMatchOutcome() {
        return matchOutcome;
    }

    public void setMatchOutcome(String matchOutcome) {
        this.matchOutcome = matchOutcome;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
