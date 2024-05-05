package org.coungard.dagdiezel.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Player;
import org.coungard.dagdiezel.entity.Scoring;
import org.coungard.dagdiezel.mapper.PlayerMapper;
import org.coungard.dagdiezel.model.MatchResult;
import org.coungard.dagdiezel.model.PlayerDetails;
import org.coungard.dagdiezel.model.PlayerDto;
import org.coungard.dagdiezel.model.ShortPlayerDto;
import org.coungard.dagdiezel.repository.PlayerRepository;
import org.coungard.dagdiezel.repository.ScoringRepository;
import org.coungard.dagdiezel.service.PlayerService;
import org.coungard.dagdiezel.utils.DateUtils;
import org.coungard.dagdiezel.utils.MathUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultPlayerService implements PlayerService {

  private final PlayerRepository playerRepository;
  private final ScoringRepository scoringRepository;
  private final PlayerMapper playerMapper = PlayerMapper.INSTANCE;

  @Override
  public List<PlayerDto> getPlayers() {
    return playerMapper.toPlayerDtoList(playerRepository.findAll());
  }

  @Override
  public List<ShortPlayerDto> getShortPlayers() {
    return playerMapper.toShortPlayerDtoList(playerRepository.findAll());
  }

  @Override
  public PlayerDetails getPlayerDetails(long playerId) {
    Player player = playerRepository.findById(playerId)
        .orElseThrow(() -> new RuntimeException("Player with id=" + playerId + " does not exists"));

    int wins = 0;
    int loses = 0;
    int draws = 0;

    List<Scoring> scores = scoringRepository.findAllByPlayerId(playerId);
    for (Scoring scoring : scores) {
      MatchResult result = scoring.getResult();
      switch (result) {
        case WIN -> wins++;
        case LOSE -> loses++;
        case DRAW -> draws++;
      }
    }
    double average = scores.stream().mapToDouble(Scoring::getScore).average().orElse(0.0d);
    double score = MathUtils.round(average, 2);

    return PlayerDetails.builder()
        .name(player.getName())
        .age(DateUtils.calculateAge(player.getBirthday()))
        .leg(player.getLeg())
        .position(player.getPosition())
        .games(wins + loses + draws)
        .wins(wins)
        .loses(loses)
        .draws(draws)
        .score(score)
        .build();
  }
}
