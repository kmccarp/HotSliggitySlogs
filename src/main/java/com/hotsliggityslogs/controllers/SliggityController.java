package com.hotsliggityslogs.controllers;

import com.hotsliggityslogs.models.Match;
import com.hotsliggityslogs.models.requests.MatchesRequest;
import com.hotsliggityslogs.models.responses.MatchesResponse;
import com.hotsliggityslogs.services.SliggityGetService;
import com.hotsliggityslogs.services.SliggitySaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SliggityController {

    @Autowired
    private SliggityGetService sliggityGetService;

    @Autowired
    private SliggitySaveService sliggitySaveService;

    @GetMapping("/matches")
    public Map<String, Object> getMatches() {

        List<Match> matches = sliggityGetService.getMatches();

        Map<String, Object> response = new HashMap<>();

        response.put("totalMatches", matches.size());
        response.put("matches", matches);

        return response;
    }

    @PostMapping("/matches")
    public ResponseEntity<Void> postMatches(@RequestBody MatchesRequest matchesRequest) {

        sliggitySaveService.save(matchesRequest);

        return ResponseEntity.ok().build();
    }

//    @GetMapping("/matches/{id}")
//    public Map<String, Object> getMatch(@PathVariable String id) {
//
//        Match match = sliggityGetService.getMatch(id);
//
//        Map<String, Object> response = new HashMap<>();
//
//        response.put("totalMatches", 1);
//        response.put("matches", match);
//
//        return response;
//    }
    @GetMapping("/matches/{id}")
    public ResponseEntity<MatchesResponse> getMatch(@PathVariable String id) {

        MatchesResponse matchesResponse = new MatchesResponse();

        List<Match> matches = new ArrayList<>();

        matches.add(sliggityGetService.getMatch(id));

        matchesResponse.setMatches(matches);

        return ResponseEntity.ok(matchesResponse);
    }

}
