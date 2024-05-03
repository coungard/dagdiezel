package org.coungard.dagdiezel.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.model.Gridiron;
import org.coungard.dagdiezel.model.request.CreateGameRequest;
import org.coungard.dagdiezel.model.response.CreateGameResponse;
import org.coungard.dagdiezel.model.response.GameTypesResponse;
import org.coungard.dagdiezel.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
  public ResponseEntity<CreateGameResponse> createGame(@RequestBody @Validated CreateGameRequest request) {
    gameService.createGame(request);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/gridirons")
  public List<Gridiron> getGridirons() {
    return gameService.getGridirons();
  }

  @GetMapping("/game-types")
  public GameTypesResponse getGameTypes() {
    return gameService.getGameTypes();
  }
}
