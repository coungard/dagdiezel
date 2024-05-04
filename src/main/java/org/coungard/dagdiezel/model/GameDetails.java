package org.coungard.dagdiezel.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GameDetails {

    private Gridiron gridiron;
    private GameType gameType;
    private String total;
    private LocalDateTime date;
    private String details;
}
