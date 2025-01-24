package org.coungard.dagdiezel.service.impl;

import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Game;
import org.coungard.dagdiezel.entity.OwnGoals;
import org.coungard.dagdiezel.entity.Player;
import org.coungard.dagdiezel.entity.Scoring;
import org.coungard.dagdiezel.model.GameType;
import org.coungard.dagdiezel.model.Shirt;
import org.coungard.dagdiezel.repository.OwnGoalsRepository;
import org.coungard.dagdiezel.repository.ScoringRepository;
import org.coungard.dagdiezel.service.StatisticService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.coungard.dagdiezel.model.Shirt.RED;

@Service
@RequiredArgsConstructor
public class DefaultStatisticService implements StatisticService {

    private final ScoringRepository scoringRepository;
    private final OwnGoalsRepository ownGoalsRepository;

    private static final String DETAILS_TEMPLATE = """

            Команда красных:
            %s

            Команда синих:
            %s

            %s
            """;

    @Override
    public String getStatisticByGame(Game game) {
        StringBuilder redTeam = new StringBuilder();
        StringBuilder blueTeam = new StringBuilder();
        if (GameType.TEAM_3_PLAYS_6x6 == game.getType()) {
            throw new UnsupportedOperationException("Game type with 3 teams doesn't support yet!");
        }
        List<Scoring> scores = scoringRepository.findAllByGameId(game.getId());
        StringBuilder currentBuilder;
        for (Scoring scoring : scores) {
            Player player = scoring.getPlayer();
            Shirt shirt = scoring.getShirt();
            currentBuilder = shirt == RED ? redTeam : blueTeam;
            currentBuilder.append(player.getName())
                    .append(", голы = ").append(scoring.getGoals())
                    .append(", балл = ").append(scoring.getScore()).append("\n");
        }
        OwnGoals ownGoals = ownGoalsRepository.findOwnGoalsByGameId(game.getId()).orElse(null);
        String ownGoalsDetails = "";
        if (ownGoals != null) {
            ownGoalsDetails = "Автогол: " + ownGoals.getPlayer().getName();
        }
        return String.format(DETAILS_TEMPLATE, redTeam, blueTeam, ownGoalsDetails);
    }
}
