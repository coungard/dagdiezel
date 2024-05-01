package org.coungard.dagdiezel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Game;
import org.coungard.dagdiezel.model.GameType;
import org.coungard.dagdiezel.model.Gridiron;
import org.coungard.dagdiezel.model.request.CreateGameRequest;
import org.coungard.dagdiezel.model.response.GameTypesResponse;
import org.coungard.dagdiezel.repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultGameService implements GameService {

  private final GameRepository gameRepository;

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
  public List<Gridiron> getGridirons() {
    return List.of(Gridiron.values());
  }

  @Override
  public GameTypesResponse getGameTypes() {
    Map<String, String> types = new HashMap<>();
    for (GameType type : GameType.values()) {
      types.put(type.name(), type.getLocal());
    }
    return GameTypesResponse.builder().gameTypes(types).build();
  }
}
