package org.coungard.dagdiezel.controller;

import java.util.List;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.model.request.ScoringDto;
import org.coungard.dagdiezel.service.ScoringService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scoring")
public class ScoringController {

  private final ScoringService scoringService;

  @PostMapping()
  public ResponseEntity<?> scoringMatch(@RequestBody List<ScoringDto> scores, @RequestParam long gameId) {
    scoringService.scoringMatch(gameId, scores);
    return new ResponseEntity<>("Scores saved successfully.", HttpStatus.OK);
  }
}
