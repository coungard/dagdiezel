package org.coungard.dagdiezel.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Player;
import org.coungard.dagdiezel.model.PlayerDto;
import org.coungard.dagdiezel.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

  @GetMapping
  public List<PlayerDto> getPlayers() {
    return playerService.getPlayers();
  }
}
