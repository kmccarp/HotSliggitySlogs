package com.hotsliggityslogs.services;

import com.hotsliggityslogs.factories.MatchesResponseFactory;
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

    @Autowired
    private MatchesResponseFactory matchesResponseFactory;

    public MatchesResponse getAllMatches() {
        List<Match> matches = new ArrayList<>();
        matches.addAll(sliggityRepo.findAll());

        return matchesResponseFactory.createMatchesResponse(matches);
    }

    public MatchesResponse getMatchById(String id) {
        List<Match> matches = new ArrayList<>();
        matches.add(sliggityRepo.findOne(id));

        return matchesResponseFactory.createMatchesResponse(matches);
    }

    public MatchesResponse getMatchByHeroName(String heroName, String beginningDate, String endDate) {
        List<Match> matches = new ArrayList<>();
        if (beginningDate != null && endDate != null) {
            matches.addAll(sliggityRepo.findByHeroAndDate(heroName, beginningDate, endDate));
        } else {
            matches.addAll(sliggityRepo.findByHeroName(heroName));
        }

        return matchesResponseFactory.createMatchesResponse(matches, heroName);
    }

    public MatchesResponse getMatchBySeason(String season) {
        List<Match> matches = new ArrayList<>();
        matches.addAll(sliggityRepo.findBySeason(season));

        return matchesResponseFactory.createMatchesResponse(matches);
    }
}
