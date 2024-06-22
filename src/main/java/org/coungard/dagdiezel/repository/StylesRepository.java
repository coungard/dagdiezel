package org.coungard.dagdiezel.repository;

import org.coungard.dagdiezel.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StylesRepository extends JpaRepository<Style, Long> {
}
