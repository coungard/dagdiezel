package org.coungard.dagdiezel.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;
import org.coungard.dagdiezel.model.Leg;

@Converter(autoApply = true)
public class LegConverter implements AttributeConverter<Leg, String> {

  @Override
  public String convertToDatabaseColumn(Leg leg) {
    if (leg == null) {
      return null;
    }
    return leg.name();
  }

  @Override
  public Leg convertToEntityAttribute(String leg) {
    if (leg == null) {
      return Leg.NO_INFO;
    }

    return Stream.of(Leg.values())
        .filter(l -> l.name().equals(leg))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}