package com.hotsliggityslogs.services;

import com.hotsliggityslogs.models.Match;
import com.hotsliggityslogs.models.responses.MatchesResponse;
import com.hotsliggityslogs.repository.SliggityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SliggityGetService {

    @Autowired
    private SliggityRepo sliggityRepo;

    public MatchesResponse getAllMatches() {
        MatchesResponse matchesResponse = new MatchesResponse();

        List<Match> matches = new ArrayList<>();
        matches.addAll(sliggityRepo.findAll());

        matchesResponse.setMatches(matches);

        return matchesResponse;
    }

    public MatchesResponse getMatchById(String id) {

        MatchesResponse matchesResponse = new MatchesResponse();

        List<Match> matches = new ArrayList<>();
        matches.add(sliggityRepo.findOne(id));

        matchesResponse.setMatches(matches);

        return matchesResponse;
    }

    public MatchesResponse getMatchByHeroName(String heroName) {

        MatchesResponse matchesResponse = new MatchesResponse();

        List<Match> matches = new ArrayList<>();
        matches.addAll(sliggityRepo.findByHeroName(heroName));

        matchesResponse.setMatches(matches);

        return matchesResponse;
    }

    public MatchesResponse getMatchBySeason(String season) {

        MatchesResponse matchesResponse = new MatchesResponse();

        List<Match> matches = new ArrayList<>();
        matches.addAll(sliggityRepo.findBySeason(season));

        matchesResponse.setMatches(matches);

        return matchesResponse;
    }
}
