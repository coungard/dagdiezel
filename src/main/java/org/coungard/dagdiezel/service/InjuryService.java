package org.coungard.dagdiezel.service;

import java.util.List;
import org.coungard.dagdiezel.model.InjuryModel;
import org.coungard.dagdiezel.model.request.CreateInjuryRequest;

public interface InjuryService {

  Long createInjury(CreateInjuryRequest request);

  List<InjuryModel> getAllInjuries();
}
