package com.hotsliggityslogs.services;

import com.hotsliggityslogs.factories.MatchesResponseFactory;
import com.hotsliggityslogs.models.Match;
import com.hotsliggityslogs.models.responses.MatchesResponse;
import com.hotsliggityslogs.repository.SliggityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public MatchesResponse getMatch(String heroName, String beginningDate, String endDate, String matchType, String mapName) {
        Sort matchDateDescending = new Sort(Sort.Direction.DESC, "matchDate");

        List<Match> matches = new ArrayList<>();
        if (heroName.equals("All Heroes")) {
            if (matchType.equals("All Modes")) {
                if (mapName.equals("All Maps")) {
                    matches.addAll(sliggityRepo.findByDates(beginningDate, endDate, matchDateDescending));
                } else {
                    matches.addAll(sliggityRepo.findByMap(mapName, beginningDate, endDate, matchDateDescending));
                }
            } else {
                if (mapName.equals("All Maps")) {
                    matches.addAll(sliggityRepo.findByMatchType(matchType, beginningDate, endDate, matchDateDescending));
                } else {
                    matches.addAll(sliggityRepo.findByMatchTypeAndMap(matchType, mapName, beginningDate, endDate, matchDateDescending));
                }
            }
        } else {
            if (matchType.equals("All Modes")) {
                if (mapName.equals("All Maps")) {
                    matches.addAll(sliggityRepo.findByHero(heroName, beginningDate, endDate, matchDateDescending));
                } else {
                    matches.addAll(sliggityRepo.findByHeroAndMap(heroName, mapName, beginningDate, endDate, matchDateDescending));
                }
            } else {
                if (mapName.equals("All Maps")) {
                    matches.addAll(sliggityRepo.findByHeroAndMatchType(heroName, matchType, beginningDate, endDate, matchDateDescending));
                } else {
                    matches.addAll(sliggityRepo.findByHeroAndMatchTypeAndMap(heroName, matchType, mapName, beginningDate, endDate, matchDateDescending));
                }
            }
        }

        return matchesResponseFactory.createMatchesResponse(matches, heroName);
    }
}
