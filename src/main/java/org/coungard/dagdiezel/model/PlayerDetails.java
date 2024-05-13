package org.coungard.dagdiezel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;
import org.coungard.dagdiezel.filter.NonZeroesIncluded;

@Data
@Builder
public class PlayerDetails {

    private String name;
    private Leg leg;
    @JsonInclude(Include.NON_NULL)
    private Integer age;
    private String position;
    @JsonInclude(Include.NON_EMPTY)
    private String role;
    private int games;
    @JsonInclude(value = Include.CUSTOM, valueFilter = NonZeroesIncluded.class)
    private int wins;
    @JsonInclude(value = Include.CUSTOM, valueFilter = NonZeroesIncluded.class)
    private int loses;
    @JsonInclude(value = Include.CUSTOM, valueFilter = NonZeroesIncluded.class)
    private int draws;
    private double score;
}
