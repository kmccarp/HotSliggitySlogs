package com.hotsliggityslogs.models.requests;

import com.hotsliggityslogs.models.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchesRequest {
    private List<Match> matches = new ArrayList<>();

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
