package org.coungard.dagdiezel.model;

import lombok.Data;

@Data
public class PlayerDto {

  private Long id;
  private String name;
  private String position;
  private Leg leg;
  private Integer age;
}
