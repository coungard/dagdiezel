package org.coungard.dagdiezel.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

  public String dateAbsentDescription(LocalDateTime injuryDate, LocalDateTime dateAbsent) {
    if (dateAbsent == null) {
      Period period = Period.between(injuryDate.toLocalDate(), LocalDate.now());
      return "Травмирован до сих пор. " + period.toString();
    }
    Period between = Period.between(injuryDate.toLocalDate(), dateAbsent.toLocalDate());
    return "Выбыл из игры на период + " + between;
  }
}
