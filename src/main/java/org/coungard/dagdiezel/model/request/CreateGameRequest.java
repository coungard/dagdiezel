package org.coungard.dagdiezel.model.request;

import java.time.LocalDateTime;
import lombok.Data;
import org.coungard.dagdiezel.model.GameType;
import org.coungard.dagdiezel.model.Gridiron;

@Data
public class CreateGameRequest {

  private Gridiron gridiron;
  private GameType type;
  private LocalDateTime date;
  private String total;
  private String teams;
}
