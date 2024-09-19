package com.jpa.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="competition")
public class CompetitionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, columnDefinition = "VARCHAR(100)")
  private String name;

  //para campos compuestos se recomienda renombrar el campo en snake_case
  @Column(name="quantity_price")
  private Integer quantityPrice;

  @Column(name="start_date", columnDefinition = "DATE")
  private LocalDate startDate;

  @Column(name="end_date", columnDefinition = "DATE")
  private LocalDate endDate;

}
