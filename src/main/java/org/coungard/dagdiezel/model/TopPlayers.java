package org.coungard.dagdiezel.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class TopPlayers {

    private Map<String, String> top;
}
