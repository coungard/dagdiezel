package org.coungard.dagdiezel.service;

import java.util.List;

import org.coungard.dagdiezel.model.PlayerDetails;
import org.coungard.dagdiezel.model.PlayerDto;
import org.coungard.dagdiezel.model.ShortPlayerDto;
import org.coungard.dagdiezel.model.TopPlayers;

public interface PlayerService {

  List<PlayerDto> getPlayers();

  PlayerDetails getPlayerDetails(long playerId);

  List<ShortPlayerDto> getShortPlayers();

    TopPlayers getTopPlayers();
}
