package org.coungard.dagdiezel.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Game;
import org.coungard.dagdiezel.entity.Scoring;
import org.coungard.dagdiezel.model.GameDetails;
import org.coungard.dagdiezel.model.request.CreateGameRequest;
import org.coungard.dagdiezel.repository.GameRepository;
import org.coungard.dagdiezel.repository.ScoringRepository;
import org.coungard.dagdiezel.service.GameService;
import org.coungard.dagdiezel.service.StatisticService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultGameService implements GameService {

  private final GameRepository gameRepository;
  private final StatisticService statisticService;
  private final ScoringRepository scoringRepository;

  @Override
  public void createGame(CreateGameRequest request) {
    Game game = new Game();
    game.setDate(request.getDate());
    game.setType(request.getType());
    game.setGridiron(request.getGridiron());
    game.setTotal(request.getTotal());
    game.setTeams(request.getTeams());

    gameRepository.save(game);
  }

  @Override
  public List<Game> getAllGames() {
    return gameRepository.findAll();
  }

  @Override
  public List<GameDetails> getAllDetailedGames() {
    return getAllGames().stream()
        .map(Game::getId)
        .map(this::getGameDetails)
        .collect(Collectors.toList());
  }

  @Override
  public GameDetails getGameDetails(long gameId) {
    Game game = gameRepository.findById(gameId)
        .orElseThrow(() -> new RuntimeException("Game with id=" + gameId + " does not exists"));

    return GameDetails.builder()
        .gameType(game.getType())
        .gridiron(game.getGridiron())
        .total(game.getTotal())
        .date(game.getDate())
        .details(statisticService.getStatisticByGame(game))
        .totalRanked(defineTotalRankByGame(game))
        .build();
  }

  private Double defineTotalRankByGame(Game game) {
    List<Scoring> scoring = scoringRepository.findAllByGameId(game.getId());

    return scoring.stream()
        .map(Scoring::getScore)
        .reduce(Double::sum)
        .orElseThrow(() -> new RuntimeException("Error while getting total score"));
  }
}
