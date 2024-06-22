package org.coungard.dagdiezel.service.impl;

import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Game;
import org.coungard.dagdiezel.entity.Injury;
import org.coungard.dagdiezel.entity.Player;
import org.coungard.dagdiezel.entity.Scoring;
import org.coungard.dagdiezel.model.InjuryModel;
import org.coungard.dagdiezel.model.request.CreateInjuryRequest;
import org.coungard.dagdiezel.repository.GameRepository;
import org.coungard.dagdiezel.repository.InjuryRepository;
import org.coungard.dagdiezel.repository.PlayerRepository;
import org.coungard.dagdiezel.repository.ScoringRepository;
import org.coungard.dagdiezel.service.InjuryService;
import org.coungard.dagdiezel.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultInjuryService implements InjuryService {

  private final InjuryRepository injuryRepository;
  private final GameRepository gameRepository;
  private final PlayerRepository playerRepository;
  private final ScoringRepository scoringRepository;

  @Override
  public Long createInjury(CreateInjuryRequest request) {
    Game game = gameRepository.findById(request.getGameId())
        .orElseThrow(() -> new RuntimeException("Game with id=" + request.getGameId() + " does not exists"));
    Player player = playerRepository.findById(request.getPlayerId())
        .orElseThrow(() -> new RuntimeException("Player with id=" + request.getPlayerId() + " does not exists"));
    Injury injury = new Injury();
    injury.setGame(game);
    injury.setPlayer(player);
    injury.setType(request.getType());
    injury.setReason(request.getReason());

    Injury saved = injuryRepository.save(injury);
    return saved.getId();
  }

  @Override
  public List<InjuryModel> getAllInjuries() {
    List<Injury> injuries = injuryRepository.findAll();
    return injuries.stream()
        .map(injury -> InjuryModel.builder()
            .game(injury.getGame().getGridiron() + ", " + injury.getGame().getDate())
            .player(injury.getPlayer().getName())
            .type(injury.getType())
            .reason(injury.getReason())
            .dateAbsent(defineDateAbsent(injury))
            .build())
        .collect(Collectors.toList());
  }

  private String defineDateAbsent(Injury injury) {
    Player player = injury.getPlayer();
    LocalDateTime injuryDate = injury.getGame().getDate();
    List<Scoring> scores = scoringRepository.findAllByPlayerId(player.getId());
    LocalDateTime nextGameDate = scores.stream()
            .map(Scoring::getGame)
            .sorted(Comparator.comparing(Game::getDate))
            .map(Game::getDate)
            .filter(date -> date.isAfter(injuryDate))
            .findFirst().orElse(null);

    return DateUtils.dateAbsentDescription(injuryDate, nextGameDate);
  }
}
