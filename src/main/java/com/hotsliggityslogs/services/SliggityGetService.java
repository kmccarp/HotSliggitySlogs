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

    public List<Match> getMatches() {
        return sliggityRepo.findAll();
    }

    public MatchesResponse getMatch(String id) {

        MatchesResponse matchesResponse = new MatchesResponse();

        List<Match> matches = new ArrayList<>();
        matches.add(sliggityRepo.findOne(id));

        matchesResponse.setMatches(matches);

        return matchesResponse;
    }
}
