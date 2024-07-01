package org.coungard.dagdiezel.service.impl;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Player;
import org.coungard.dagdiezel.entity.Scoring;
import org.coungard.dagdiezel.entity.Talent;
import org.coungard.dagdiezel.mapper.PlayerMapper;
import org.coungard.dagdiezel.model.MatchResult;
import org.coungard.dagdiezel.model.PlayerDetails;
import org.coungard.dagdiezel.model.PlayerDto;
import org.coungard.dagdiezel.model.ShortPlayerDto;
import org.coungard.dagdiezel.model.TopPlayers;
import org.coungard.dagdiezel.repository.PlayerRepository;
import org.coungard.dagdiezel.repository.ScoringRepository;
import org.coungard.dagdiezel.service.PlayerService;
import org.coungard.dagdiezel.utils.DateUtils;
import org.coungard.dagdiezel.utils.DescriptionUtils;
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
  public List<PlayerDetails> getAllPlayerDetails() {
    return playerRepository.findAll().stream()
        .map(Player::getId)
        .map(this::getPlayerDetails)
        .collect(Collectors.toList());
  }

  @Override
  public PlayerDetails getPlayerDetails(long playerId) {
    Player player = playerRepository.findById(playerId)
        .orElseThrow(() -> new RuntimeException("Player with id=" + playerId + " does not exists"));

    String style = DescriptionUtils.describeStyle(player.getStyle());
    String talent = Optional.ofNullable(player.getTalent()).map(Talent::getTalent).orElse(null);
    int wins = 0;
    int loses = 0;
    int draws = 0;
    int goals = 0;
    List<Scoring> scores = scoringRepository.findAllByPlayerId(playerId);
    for (Scoring scoring : scores) {
      MatchResult result = scoring.getResult();
      switch (result) {
        case WIN -> wins++;
        case LOSE -> loses++;
        case DRAW -> draws++;
      }
      goals += scoring.getGoals();
    }
    double averageScore = scores.stream().mapToDouble(Scoring::getScore).average().orElse(0.0d);
    double averageGoals = scores.stream().mapToDouble(Scoring::getGoals).average().orElse(0.0d);
    double score = MathUtils.round(averageScore, 2);
    double xGoals = MathUtils.round(averageGoals, 2);

    return PlayerDetails.builder()
        .name(player.getName())
        .age(DateUtils.calculateAge(player.getBirthday()))
        .leg(player.getLeg())
        .style(style)
        .talent(talent)
        .games(wins + loses + draws)
        .wins(wins)
        .loses(loses)
        .draws(draws)
        .goals(goals)
        .score(score)
            .xGoals(xGoals)
        .build();
  }

  @Override
  public TopPlayers getTopPlayers(Integer minimumGames, String sortBy) {
    AtomicInteger rating = new AtomicInteger(1);
    List<Player> players = playerRepository.findAll();
    Map<String, String> top = players.stream()
        .map(player -> getPlayerDetails(player.getId()))
        .filter(details -> details.getGames() >= minimumGames)
        .sorted(defineComparator(sortBy))
        .collect(Collectors.toMap(details -> rating.getAndIncrement() + " - " + details.getName(),
                DescriptionUtils::describePlayerDetails,
            (a, b) -> a,
            LinkedHashMap::new));

    return TopPlayers.builder()
        .top(top)
        .build();
  }

  private Comparator<? super PlayerDetails> defineComparator(String sortBy) {
      return switch (sortBy) {
          case "xG" -> Comparator.comparingDouble(PlayerDetails::getXGoals).reversed();
          case "goals" -> Comparator.comparingDouble(PlayerDetails::getGoals).reversed();
          default -> Comparator.comparingDouble(PlayerDetails::getScore).reversed();
      };
  }


}
