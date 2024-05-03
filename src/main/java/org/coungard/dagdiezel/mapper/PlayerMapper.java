package org.coungard.dagdiezel.mapper;

import java.util.List;
import org.coungard.dagdiezel.entity.Player;
import org.coungard.dagdiezel.entity.Scoring;
import org.coungard.dagdiezel.model.PlayerDto;
import org.coungard.dagdiezel.model.request.ScoringDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerMapper {

  PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

  @Mapping(source = "birthday", target = "age", expression = "java(DateUtils.calculateAge(player.getBirthday())")
  PlayerDto toPlayerDto(Player player);

  List<PlayerDto> toPlayerDtoList(List<Player> playerList);
}
