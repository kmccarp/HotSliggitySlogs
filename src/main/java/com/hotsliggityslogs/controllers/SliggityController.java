package com.hotsliggityslogs.controllers;

import com.hotsliggityslogs.models.Match;
import com.hotsliggityslogs.services.SliggityGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SliggityController {

    @Autowired
    private SliggityGetService sliggityGetService;

    @GetMapping("/matches")
    public Map<String, Object> getMatches() {

        List<Match> matches = sliggityGetService.getMatches();

        Map<String, Object> response = new HashMap<>();

        response.put("totalMatches", matches.size());
        response.put("matches", matches);

        return response;
    }
}
