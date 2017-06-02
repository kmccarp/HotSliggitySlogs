package com.hotsliggityslogs.models.responses;

import com.hotsliggityslogs.models.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchesResponse {
    private List<Match> matches = new ArrayList<>();

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
