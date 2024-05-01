package org.coungard.dagdiezel.model.response;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameTypesResponse {

  private Map<String, String> gameTypes;
}
