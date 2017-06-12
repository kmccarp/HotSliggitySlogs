package com.hotsliggityslogs.repository;

import com.hotsliggityslogs.models.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliggityRepo extends MongoRepository<Match, String> {
    @Query("{ 'heroName' : ?0, 'matchDate' : { $gte : ?1, $lte : ?2 }}")
    List<Match> findByHero(String heroName, String from, String to);
    @Query("{ 'matchDate' : { $gte : ?0, $lte : ?1 }, 'matchType' : ?2 }")
    List<Match> findByGameType(String from, String to, String matchType);
    @Query("{ 'heroName' : ?0, 'matchDate' : { $gte : ?1, $lte : ?2 }, 'matchType' : ?3 }")
    List<Match> findByHeroAndGameType(String heroName, String from, String to, String matchType);
}
