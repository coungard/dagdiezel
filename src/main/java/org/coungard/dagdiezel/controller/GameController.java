package org.coungard.dagdiezel.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Game;
import org.coungard.dagdiezel.model.GameDetails;
import org.coungard.dagdiezel.model.request.CreateGameRequest;
import org.coungard.dagdiezel.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

  private final GameService gameService;

  @PostMapping
  public ResponseEntity<?> createGame(@RequestBody @Validated CreateGameRequest request) {
    gameService.createGame(request);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public List<Game> getAllGames() {
    return gameService.getAllGames();
  }

  @GetMapping("/{id}")
  public ResponseEntity<GameDetails> getGameDetails(@PathVariable("id") long gameId) {
    GameDetails gameDetails = gameService.getGameDetails(gameId);
    return ResponseEntity.ok(gameDetails);
  }

  @GetMapping("/detailed/all")
  public List<GameDetails> getAllGameDetails() {
    return gameService.getAllDetailedGames();
  }
}
