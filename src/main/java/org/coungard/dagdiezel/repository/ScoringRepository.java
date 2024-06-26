package org.coungard.dagdiezel.repository;

import java.util.List;
import org.coungard.dagdiezel.entity.Scoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoringRepository extends JpaRepository<Scoring, Long> {

  List<Scoring> findAllByGameId(Long gameId);

  List<Scoring> findAllByPlayerId(Long playerId);
}
