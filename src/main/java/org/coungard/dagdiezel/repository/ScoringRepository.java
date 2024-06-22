package org.coungard.dagdiezel.repository;

import java.util.List;
import org.coungard.dagdiezel.entity.Scoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoringRepository extends JpaRepository<Scoring, Long> {

    List<Scoring> findAllByGameId(Long gameId);
    List<Scoring> findAllByPlayerId(Long playerId);

    @Query(value = "SELECT coalesce(max(id), 0) FROM Scoring ")
    Long getMaxId();
}
