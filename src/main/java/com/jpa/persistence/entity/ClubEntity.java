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
@Table(name = "club")
public class ClubEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToOne(targetEntity = CoachEntity.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name="coach_id") //personalizo el nombre del foreign key
  private CoachEntity coach; //aca se define la clave foranea, esta tabla es la dueña clave foranea

  @OneToMany(targetEntity = PlayerEntity.class, fetch = FetchType.LAZY, mappedBy = "club")
  private List<PlayerEntity> players;

  @ManyToOne(targetEntity = FootballAssociationEntity.class)
  private FootballAssociationEntity footballAssociation;

  @ManyToMany(targetEntity = CompetitionEntity.class, fetch = FetchType.LAZY)
  @JoinTable(name = "club_competition", joinColumns = @JoinColumn(name = "club_id"), inverseJoinColumns = @JoinColumn(name = "competition_id"))
  private List<CompetitionEntity> competitionList;
}
