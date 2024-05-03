package org.coungard.dagdiezel.repository;

import org.coungard.dagdiezel.entity.Scoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoringRepository extends JpaRepository<Scoring, Long> {

}
