package org.coungard.dagdiezel.model.request;

import lombok.Data;
import org.coungard.dagdiezel.model.MatchResult;
import org.coungard.dagdiezel.model.Shirt;

@Data
public class ScoringDto {

  private Long playerId;
  private MatchResult result;
  private Double score;
  private Integer goals;
  private Shirt shirt;
}
