package org.coungard.dagdiezel.utils;

import lombok.experimental.UtilityClass;
import org.coungard.dagdiezel.entity.Style;
import org.coungard.dagdiezel.model.PlayerDetails;

@UtilityClass
public class DescriptionUtils {

  public String describeStyle(Style style) {
    return style.getName().toUpperCase() + ". "
        + style.getDescription()
        + " Совместимые позиции: " + style.getPositions();
  }

  public String describePlayerDetails(PlayerDetails details) {
    return details.getScore()
            + ", игр: " + details.getGames()
            + ", голов: " + details.getGoals()
            + ", xG: " + details.getXGoals();
  }
}
