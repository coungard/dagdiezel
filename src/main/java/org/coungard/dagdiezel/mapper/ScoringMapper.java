package org.coungard.dagdiezel.mapper;

import java.util.List;
import org.coungard.dagdiezel.entity.Scoring;
import org.coungard.dagdiezel.model.request.ScoringDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScoringMapper {

  ScoringMapper INSTANCE = Mappers.getMapper(ScoringMapper.class);

  List<Scoring> toScoringEntityList(List<ScoringDto> scoringDtoList);
}
