package org.coungard.dagdiezel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerDetails {

    private String name;
    private Leg leg;
    private Integer age;
    private String position;
    @JsonInclude(Include.NON_EMPTY)
    private String role;
    private int games;
    private int wins;
    private int loses;
    private int draws;
    private double score;
}
