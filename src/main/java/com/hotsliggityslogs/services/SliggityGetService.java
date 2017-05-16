package com.hotsliggityslogs.services;

import com.hotsliggityslogs.models.Match;
import com.hotsliggityslogs.repository.SliggityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SliggityGetService {

    @Autowired
    private SliggityRepo sliggityRepo;

    public List<Match> getMatches() {
        return sliggityRepo.findAll();
    }
}
