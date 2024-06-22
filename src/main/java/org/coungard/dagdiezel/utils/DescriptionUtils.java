package org.coungard.dagdiezel.utils;

import lombok.experimental.UtilityClass;
import org.coungard.dagdiezel.entity.Style;

@UtilityClass
public class DescriptionUtils {

  public String describeStyle(Style style) {
    return style.getName().toUpperCase() + ". "
        + style.getDescription()
        + " Совместимые позиции: " + style.getPositions();
  }
}
