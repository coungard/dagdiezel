package org.coungard.dagdiezel.repository;

import org.coungard.dagdiezel.entity.Injury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InjuryRepository extends JpaRepository<Injury, Long> {

}
