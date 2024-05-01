package org.coungard.dagdiezel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.coungard.dagdiezel.model.MatchResult;

@Entity
@Data
public class PlayStatistics {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private Player player;
  @OneToOne
  private Game game;

  @Enumerated(EnumType.STRING)
  private MatchResult result;

  private int goals;

  private double score;
}
