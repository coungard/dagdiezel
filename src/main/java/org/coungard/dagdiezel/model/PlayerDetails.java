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
    private String style;
    @JsonInclude(Include.NON_NULL)
    private String talent;
    @JsonInclude(Include.NON_NULL)
    private String injury;
    @JsonInclude(value = Include.CUSTOM, valueFilter = NonZeroesIncluded.class)
    private int games;
    @JsonInclude(value = Include.CUSTOM, valueFilter = NonZeroesIncluded.class)
    private int wins;
    @JsonInclude(value = Include.CUSTOM, valueFilter = NonZeroesIncluded.class)
    private int loses;
    @JsonInclude(value = Include.CUSTOM, valueFilter = NonZeroesIncluded.class)
    private int draws;
    @JsonInclude(value = Include.CUSTOM, valueFilter = NonZeroesIncluded.class)
    private int goals;
    @JsonInclude(value = Include.CUSTOM, valueFilter = NonZeroesIncluded.class)
    private double score;
}
