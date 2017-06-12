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

    public MatchesResponse getMatchById(String id) {
        List<Match> matches = new ArrayList<>();
        matches.add(sliggityRepo.findOne(id));

        return matchesResponseFactory.createMatchesResponse(matches);
    }

    public MatchesResponse getMatch(String heroName, String beginningDate, String endDate, String matchType) {
        List<Match> matches = new ArrayList<>();
        if (heroName.equals("All Heroes")) {
            if (matchType.equals("All Modes")) {
                matches.addAll(sliggityRepo.findAll());
            } else {
                matches.addAll(sliggityRepo.findByGameType(beginningDate, endDate, matchType));
            }
        } else {
            if (matchType.equals("All Modes")) {
                matches.addAll(sliggityRepo.findByHero(heroName, beginningDate, endDate));
            } else {
                matches.addAll(sliggityRepo.findByHeroAndGameType(heroName, beginningDate, endDate, matchType));
            }
        }

        return matchesResponseFactory.createMatchesResponse(matches, heroName);
    }
}
