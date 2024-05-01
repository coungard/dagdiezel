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

@Entity
@Data
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private GameType type;
  @Enumerated(EnumType.STRING)
  private Gridiron gridiron;

  private LocalDateTime date;
  private String total;
  private String teams;
}
