package org.coungard.dagdiezel.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InjuryModel {
  private String game;
  private String player;
  private String type;
  private String reason;
  private String dateAbsent;
}
