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

    @GetMapping("/matches/heroName")
    public ResponseEntity<MatchesResponse> getMatchByHeroName(@RequestParam(value = "heroName", required = true) String heroName,
                                                              @RequestParam(value = "beginningDate", required = false) String beginningDate,
                                                              @RequestParam(value = "endDate", required = false) String endDate) {

        return ResponseEntity.ok(sliggityGetService.getMatchByHeroName(heroName, beginningDate, endDate));
    }
}
