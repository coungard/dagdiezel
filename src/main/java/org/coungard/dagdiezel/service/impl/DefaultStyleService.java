package org.coungard.dagdiezel.service.impl;

import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.entity.Style;
import org.coungard.dagdiezel.repository.StylesRepository;
import org.coungard.dagdiezel.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultStyleService implements StyleService {

    private final StylesRepository stylesRepository;

    @Override
    public List<Style> getStyles() {
        return stylesRepository.findAll();
    }
}
