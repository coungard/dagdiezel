package org.coungard.dagdiezel.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.mapper.PlayerMapper;
import org.coungard.dagdiezel.model.PlayerDto;
import org.coungard.dagdiezel.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultPlayerService implements PlayerService {

  private final PlayerRepository playerRepository;
  private final PlayerMapper playerMapper = PlayerMapper.INSTANCE;

  @Override
  public List<PlayerDto> getPlayers() {
    return playerMapper.toPlayerDtoList(playerRepository.findAll());
  }
}
