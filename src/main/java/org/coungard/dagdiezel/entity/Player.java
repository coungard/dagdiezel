package org.coungard.dagdiezel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import lombok.Data;
import org.coungard.dagdiezel.model.Leg;

@Data
@Entity(name = "players")
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private LocalDate birthday;
  private String position;
  private Leg leg;

  @OneToOne
  private Style style;
  @OneToOne(mappedBy = "player")
  private Talent talent;
}
