package org.coungard.dagdiezel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;
import org.coungard.dagdiezel.model.GameType;
import org.coungard.dagdiezel.model.Gridiron;
import org.coungard.dagdiezel.tools.sequence.IncrementByMaxIdGenerator;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "games")
@Data
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "games_seq")
  @GenericGenerator(name = "games_seq", type = IncrementByMaxIdGenerator.class)
  private Long id;

  @Enumerated(EnumType.STRING)
  private GameType type;
  @Enumerated(EnumType.STRING)
  private Gridiron gridiron;

  private LocalDateTime date;
  private String total;
  private String teams;
}
