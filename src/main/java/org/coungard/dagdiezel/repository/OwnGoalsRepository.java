package org.coungard.dagdiezel.repository;

import java.util.Optional;
import org.coungard.dagdiezel.entity.OwnGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnGoalsRepository extends JpaRepository<OwnGoals, Long> {

  Optional<OwnGoals> findOwnGoalsByGameId(Long gameId);

}
