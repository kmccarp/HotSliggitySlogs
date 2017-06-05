package com.hotsliggityslogs.repository;

import com.hotsliggityslogs.models.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliggityRepo extends MongoRepository<Match, String> {
    List<Match> findByHeroName(String heroName);
    List<Match> findBySeason(String season);
    @Query("{ 'heroName' : ?0, 'matchDate' : { $gte : ?1, $lte : ?2 }}")
    List<Match> findByHeroAndDate(String heroName, String from, String to);
}
