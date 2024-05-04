package org.coungard.dagdiezel.repository;

import org.coungard.dagdiezel.entity.Scoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoringRepository extends JpaRepository<Scoring, Long> {

    List<Scoring> findAllByGameId(Long gameId);
    List<Scoring> findAllByPlayerId(Long playerId);
}
