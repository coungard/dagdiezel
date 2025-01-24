package org.coungard.dagdiezel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.coungard.dagdiezel.tools.sequence.IncrementByMaxIdGenerator;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "own_goals")
@Data
public class OwnGoals {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "games_seq")
  @GenericGenerator(name = "games_seq", type = IncrementByMaxIdGenerator.class)
  private Long id;
  @OneToOne
  private Game game;
  @OneToOne
  private Player player;
}
