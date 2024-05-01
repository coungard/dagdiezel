package org.coungard.dagdiezel.model.request;

import java.util.List;
import lombok.Data;

@Data
public class ScoreMatchRequest {

  List<ScoreRequest> scores;
}
