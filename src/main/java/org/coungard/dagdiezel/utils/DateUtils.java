package org.coungard.dagdiezel.utils;

import java.time.LocalDate;
import java.time.Period;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtils {

  public int calculateAge(LocalDate birthDate) {
    return Period.between(birthDate, LocalDate.now()).getYears();
  }
}
