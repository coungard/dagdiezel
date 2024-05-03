package org.coungard.dagdiezel.service;

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
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultScoringService implements ScoringService {

  private final ScoringRepository scoringRepository;
  private final GameRepository gameRepository;
  private final PlayerRepository playerRepository;

  @Override
  public void scoringMatch(List<ScoringDto> dtoScores) {
    List<Scoring> list = new ArrayList<>();
    for (ScoringDto dto : dtoScores) {
      Scoring scoring = new Scoring();
      scoring.setGoals(dto.getGoals());
      scoring.setShirt(dto.getShirt());

      Game game = gameRepository.findById(dto.getGameId())
          .orElseThrow(() -> new RuntimeException("Game with id=" + dto.getGameId() + " does not exists"));
      Player player = playerRepository.findById(dto.getPlayerId())
          .orElseThrow(() -> new RuntimeException("Player with id=" + dto.getPlayerId() + " does not exists"));

      scoring.setGame(game);
      scoring.setPlayer(player);
      list.add(scoring);
    }
    scoringRepository.saveAll(list);
  }
}
