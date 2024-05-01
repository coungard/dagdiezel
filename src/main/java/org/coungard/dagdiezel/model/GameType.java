package org.coungard.dagdiezel.model;

import lombok.Data;

public enum GameType {

  TEAM_2_PLAYS_6x6("6 x 6, 2 команды"),
  TEAM_3_PLAYS_6x6("6 x 6, 3 команды");

  private final String local;

  GameType(String local) {
    this.local = local;
  }

  public String getLocal() {
    return local;
  }
}
