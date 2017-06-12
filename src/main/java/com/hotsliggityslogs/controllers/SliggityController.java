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

    @PostMapping("/matches")
    public ResponseEntity<Void> postMatches(@RequestBody MatchesRequest matchesRequest) {

        sliggitySaveService.save(matchesRequest);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/matches/{id}")
    public ResponseEntity<MatchesResponse> getMatchById(@PathVariable String id) {

        return ResponseEntity.ok(sliggityGetService.getMatchById(id));
    }

    @GetMapping("/matches")
    public ResponseEntity<MatchesResponse> getMatch(@RequestParam(value = "heroName", required = true) String heroName,
                                                    @RequestParam(value = "beginningDate", required = true) String beginningDate,
                                                    @RequestParam(value = "endDate", required = true) String endDate,
                                                    @RequestParam(value = "matchType", required = true) String matchType,
                                                    @RequestParam(value = "mapName", required = true) String mapName) {

        return ResponseEntity.ok(sliggityGetService.getMatch(heroName, beginningDate, endDate, matchType, mapName));
    }
}
