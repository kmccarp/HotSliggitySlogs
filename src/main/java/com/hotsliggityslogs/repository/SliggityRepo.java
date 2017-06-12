package com.hotsliggityslogs.repository;

import com.hotsliggityslogs.models.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliggityRepo extends MongoRepository<Match, String> {
    @Query("{ 'heroName' : ?0, 'matchDate' : { $gte : ?1, $lte : ?2 } }")
    List<Match> findByHero(String heroName, String from, String to);
    @Query("{ 'matchType' : ?0, 'matchDate' : { $gte : ?1, $lte : ?2 } }")
    List<Match> findByMatchType(String matchType, String from, String to);
    @Query("{ 'mapName' : ?0, 'matchDate' : { $gte : ?1, $lte : ?2 } }")
    List<Match> findByMap(String mapName, String from, String to);
    @Query("{ 'heroName' : ?0, 'matchType' : ?1, 'matchDate' : { $gte : ?2, $lte : ?3 }}")
    List<Match> findByHeroAndMatchType(String heroName, String matchType, String from, String to);
    @Query("{ 'heroName' : ?0, 'mapName' : ?1, 'matchDate' : { $gte : ?2, $lte : ?3 }}")
    List<Match> findByHeroAndMap(String heroName, String mapName, String from, String to);
    @Query("{ 'matchType' : ?0, 'mapName' : ?1, 'matchDate' : { $gte : ?2, $lte : ?3 }}")
    List<Match> findByMatchTypeAndMap(String matchType, String mapName, String from, String to);
    @Query("{ 'heroName' : ?0, 'mapName' : ?1, 'matchType' : ?2, 'matchDate' : { $gte : ?3, $lte : ?4 }}")
    List<Match> findByHeroAndMatchTypeAndMap(String heroName, String matchType, String mapName, String from, String to);
}
