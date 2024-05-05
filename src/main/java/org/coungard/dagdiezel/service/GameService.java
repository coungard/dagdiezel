package org.coungard.dagdiezel.service;

import java.util.List;

import org.coungard.dagdiezel.entity.Game;
import org.coungard.dagdiezel.model.GameDetails;
import org.coungard.dagdiezel.model.GameType;
import org.coungard.dagdiezel.model.Gridiron;
import org.coungard.dagdiezel.model.request.CreateGameRequest;
import org.coungard.dagdiezel.model.response.GameTypesResponse;

public interface GameService {

  void createGame(CreateGameRequest request);

  GameDetails getGameDetails(long gameId);

  List<Game> getAllGames();
}
