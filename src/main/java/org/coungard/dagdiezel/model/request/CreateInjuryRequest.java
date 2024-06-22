package org.coungard.dagdiezel.model.request;

import lombok.Data;

@Data
public class CreateInjuryRequest {

  private long gameId;
  private long playerId;
  private String type;
  private String reason;
}
