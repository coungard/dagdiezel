package org.coungard.dagdiezel.utils;

import java.time.LocalDate;
import java.time.Period;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtils {

  public Integer calculateAge(LocalDate birthDate) {
    if (birthDate == null) {
      return null;
    }
    return Period.between(birthDate, LocalDate.now()).getYears();
  }
}
