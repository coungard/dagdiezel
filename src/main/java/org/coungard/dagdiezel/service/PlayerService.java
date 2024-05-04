package org.coungard.dagdiezel.service;

import java.util.List;

import org.coungard.dagdiezel.model.PlayerDetails;
import org.coungard.dagdiezel.model.PlayerDto;

public interface PlayerService {

  List<PlayerDto> getPlayers();

  PlayerDetails getPlayerDetails(long playerId);
}
