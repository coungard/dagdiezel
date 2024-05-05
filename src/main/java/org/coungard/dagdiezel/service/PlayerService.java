package org.coungard.dagdiezel.service;

import java.util.List;

import org.coungard.dagdiezel.model.PlayerDetails;
import org.coungard.dagdiezel.model.PlayerDto;
import org.coungard.dagdiezel.model.ShortPlayerDto;

public interface PlayerService {

  List<PlayerDto> getPlayers();

  PlayerDetails getPlayerDetails(long playerId);

  List<ShortPlayerDto> getShortPlayers();
}
