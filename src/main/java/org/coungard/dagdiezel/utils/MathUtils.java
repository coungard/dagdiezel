package org.coungard.dagdiezel.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MathUtils {

  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
  }
}
