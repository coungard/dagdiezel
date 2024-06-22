package org.coungard.dagdiezel.controller;

import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Style;
import org.coungard.dagdiezel.model.GameType;
import org.coungard.dagdiezel.model.Gridiron;
import org.coungard.dagdiezel.model.response.GameTypesResponse;
import org.coungard.dagdiezel.service.StyleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {

    private final StyleService styleService;

    @GetMapping("/gridirons")
    public List<Gridiron> getGridirons() {
        return List.of(Gridiron.values());
    }

    @GetMapping("/game-types")
    public GameTypesResponse getGameTypes() {
        Map<String, String> types = new HashMap<>();
        for (GameType type : GameType.values()) {
            types.put(type.name(), type.getLocal());
        }
        return GameTypesResponse.builder().gameTypes(types).build();
    }

    @GetMapping("/styles")
    public List<Style> getStyles() {
        return styleService.getStyles();
    }
}
