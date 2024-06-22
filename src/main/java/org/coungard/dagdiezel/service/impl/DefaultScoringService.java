package org.coungard.dagdiezel.service.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Game;
import org.coungard.dagdiezel.entity.Player;
import org.coungard.dagdiezel.entity.Scoring;
import org.coungard.dagdiezel.model.request.ScoringDto;
import org.coungard.dagdiezel.repository.GameRepository;
import org.coungard.dagdiezel.repository.PlayerRepository;
import org.coungard.dagdiezel.repository.ScoringRepository;
import org.coungard.dagdiezel.service.ScoringService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultScoringService implements ScoringService {

  private final ScoringRepository scoringRepository;
  private final GameRepository gameRepository;
  private final PlayerRepository playerRepository;

  @Override
  public void scoringMatch(long gameId, List<ScoringDto> dtoScores) {
    List<Scoring> list = new ArrayList<>();
    for (ScoringDto dto : dtoScores) {
      Scoring scoring = new Scoring();
      scoring.setGoals(dto.getGoals());
      scoring.setShirt(dto.getShirt());
      scoring.setResult(dto.getResult());
      scoring.setScore(dto.getScore());

      Game game = gameRepository.findById(gameId)
          .orElseThrow(() -> new RuntimeException("Game with id=" + gameId + " does not exists"));
      Player player = playerRepository.findById(dto.getPlayerId())
          .orElseThrow(() -> new RuntimeException("Player with id=" + dto.getPlayerId() + " does not exists"));

      scoring.setGame(game);
      scoring.setPlayer(player);
      list.add(scoring);
    }
    scoringRepository.saveAll(list);
  }

  @Override
  public Double checkAverageScoring() {
    return null; // TODO
  }
}
