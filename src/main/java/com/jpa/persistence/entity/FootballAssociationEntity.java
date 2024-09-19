package com.jpa.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="football_association")
public class FootballAssociationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String country;
  private String chairman;

  //mappedBy es el nombre del atributo de la clase destino para crear la relacion
  @OneToMany(targetEntity = ClubEntity.class, fetch = FetchType.LAZY, mappedBy = "footballAssociation")
  private List<ClubEntity> clubList;
}
