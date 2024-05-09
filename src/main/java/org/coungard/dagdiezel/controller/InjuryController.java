package org.coungard.dagdiezel.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.model.InjuryModel;
import org.coungard.dagdiezel.model.request.CreateInjuryRequest;
import org.coungard.dagdiezel.service.InjuryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/injuries")
@RequiredArgsConstructor
public class InjuryController {

  private final InjuryService injuryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Long> createInjury(@RequestBody CreateInjuryRequest request) {
    Long injuryId = injuryService.createInjury(request);
    return ResponseEntity.ok(injuryId);
  }

  @GetMapping
  public List<InjuryModel> getAllInjuries() {
    return injuryService.getAllInjuries();
  }
}
