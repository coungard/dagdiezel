package org.coungard.dagdiezel.service;

import java.util.List;
import org.coungard.dagdiezel.model.request.ScoringDto;

public interface ScoringService {

  void scoringMatch(List<ScoringDto> scores);
}
