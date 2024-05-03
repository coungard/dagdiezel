package org.coungard.dagdiezel.model;

import lombok.Data;

@Data
public class GameDetails {

    private Long gameId;
    private Gridiron gridiron;
    private String total;
}
