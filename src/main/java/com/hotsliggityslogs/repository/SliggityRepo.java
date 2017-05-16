package com.hotsliggityslogs.repository;

import com.hotsliggityslogs.models.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliggityRepo extends MongoRepository<Match, String> {}
