package com.hotsliggityslogs.models;

import org.springframework.data.annotation.Id;

public abstract class Match {
    @Id
    private String id;
    private String mapName;
    private String matchLength;
    private String heroName;
    private String heroLevel;
    private String matchmakingRating;
    private String ratingAdjustmentPoints;
    private String matchDateTime;
    private String matchOutcome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(String matchDateTime) {
        this.matchDateTime = matchDateTime;
    }

    public String getMatchOutcome() {
        return matchOutcome;
    }

    public void setMatchOutcome(String matchOutcome) {
        this.matchOutcome = matchOutcome;
    }
}
