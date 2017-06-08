package com.hotsliggityslogs.models.responses;

import com.hotsliggityslogs.models.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchesResponse {
    private List<Match> matches = new ArrayList<>();
    private double wins;
    private double losses;
    private double matchesCount;
    private double winLossRatio;
    private String heroIcon;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public double getWins() {
        return wins;
    }

    public void setWins(double wins) {
        this.wins = wins;
    }

    public double getLosses() {
        return losses;
    }

    public void setLosses(double losses) {
        this.losses = losses;
    }

    public double getMatchesCount() {
        return matchesCount;
    }

    public void setMatchesCount(double matchesCount) {
        this.matchesCount = matchesCount;
    }

    public double getWinLossRatio() {
        return winLossRatio;
    }

    public void setWinLossRatio(double winLossRatio) {
        this.winLossRatio = winLossRatio;
    }

    public String getHeroIcon() {
        return heroIcon;
    }

    public void setHeroIcon(String heroIcon) {
        this.heroIcon = heroIcon;
    }
}
