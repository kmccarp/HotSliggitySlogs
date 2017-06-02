package com.hotsliggityslogs.controllers;

import com.hotsliggityslogs.models.requests.MatchesRequest;
import com.hotsliggityslogs.models.responses.MatchesResponse;
import com.hotsliggityslogs.services.SliggityGetService;
import com.hotsliggityslogs.services.SliggitySaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SliggityController {

    @Autowired
    private SliggityGetService sliggityGetService;

    @Autowired
    private SliggitySaveService sliggitySaveService;

    @GetMapping("/matches")
    public ResponseEntity<MatchesResponse> getMatches() {

        return ResponseEntity.ok(sliggityGetService.getAllMatches());
    }

    @PostMapping("/matches")
    public ResponseEntity<Void> postMatches(@RequestBody MatchesRequest matchesRequest) {

        sliggitySaveService.save(matchesRequest);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/matches/{id}")
    public ResponseEntity<MatchesResponse> getMatchById(@PathVariable String id) {

        return ResponseEntity.ok(sliggityGetService.getMatchById(id));
    }

    @GetMapping("/matches/heroName/{heroName}")
    public ResponseEntity<MatchesResponse> getMatchByHeroName(@PathVariable String heroName) {

        return ResponseEntity.ok(sliggityGetService.getMatchByHeroName(heroName));
    }

    @GetMapping("/matches/season/{season}")
    public ResponseEntity<MatchesResponse> getMatchBySeason(@PathVariable String season) {

        return ResponseEntity.ok(sliggityGetService.getMatchBySeason(season));
    }
}
