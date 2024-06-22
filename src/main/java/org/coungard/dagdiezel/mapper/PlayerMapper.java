package org.coungard.dagdiezel.mapper;

import org.coungard.dagdiezel.entity.Player;
import org.coungard.dagdiezel.model.PlayerDto;
import org.coungard.dagdiezel.model.ShortPlayerDto;
import org.coungard.dagdiezel.utils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(source = "birthday", target = "age", qualifiedByName = "getAge")
    PlayerDto toPlayerDto(Player player);

    List<PlayerDto> toPlayerDtoList(List<Player> playerList);

    List<ShortPlayerDto> toShortPlayerDtoList(List<Player> playerList);

    @Named("getAge")
    default Integer getAge(LocalDate birthday) {
        return DateUtils.calculateAge(birthday);
    }
}
