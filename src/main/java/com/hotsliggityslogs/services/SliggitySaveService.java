package com.hotsliggityslogs.services;

import com.hotsliggityslogs.models.Match;
import com.hotsliggityslogs.models.requests.MatchesRequest;
import com.hotsliggityslogs.repository.SliggityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SliggitySaveService {

    @Autowired
    private SliggityRepo sliggityRepo;

    public void save(MatchesRequest matchesRequest) {

        for(Match match : matchesRequest.getMatches()) {
            sliggityRepo.save(match);
        }
    }
}
