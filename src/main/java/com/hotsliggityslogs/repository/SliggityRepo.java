package com.hotsliggityslogs.repository;

import com.hotsliggityslogs.models.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliggityRepo extends MongoRepository<Match, String> {
    List<Match> findByHeroName(String heroName);
    List<Match> findBySeason(String season);
}
