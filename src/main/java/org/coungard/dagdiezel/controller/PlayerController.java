package org.coungard.dagdiezel.controller;

import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.model.PlayerDetails;
import org.coungard.dagdiezel.model.PlayerDto;
import org.coungard.dagdiezel.model.ShortPlayerDto;
import org.coungard.dagdiezel.model.TopPlayers;
import org.coungard.dagdiezel.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<PlayerDto> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/short")
    public List<ShortPlayerDto> getShortPlayers() {
        return playerService.getShortPlayers();
    }

    @GetMapping("/{id}")
    public PlayerDetails getPlayerDetails(@PathVariable("id") long playerId) {
        return playerService.getPlayerDetails(playerId);
    }

    @GetMapping("/all")
    public List<PlayerDetails> getAllPlayersDetails() {
        return playerService.getAllPlayerDetails();
    }

    @GetMapping(value = "/top")
    public TopPlayers getTopPlayers() {
        return playerService.getTopPlayers();
    }
}
