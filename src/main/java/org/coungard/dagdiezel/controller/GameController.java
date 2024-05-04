package org.coungard.dagdiezel.controller;

import java.util.List;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.model.GameDetails;
import org.coungard.dagdiezel.model.Gridiron;
import org.coungard.dagdiezel.model.request.CreateGameRequest;
import org.coungard.dagdiezel.model.response.GameTypesResponse;
import org.coungard.dagdiezel.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}")
  public ResponseEntity<?> getGameDetails(@PathVariable("id") long gameId) {
    GameDetails gameDetails = gameService.getGameDetails(gameId);
    return ResponseEntity.ok(gameDetails);
  }
}
