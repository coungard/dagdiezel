package org.coungard.dagdiezel.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerDetails {

    private String name;
    private Leg leg;
    private Integer age;
    private String position;
    private int games;
    private int wins;
    private int loses;
    private int draws;
    private double score;
}
