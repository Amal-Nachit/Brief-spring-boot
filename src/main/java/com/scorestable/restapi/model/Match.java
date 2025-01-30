package com.scorestable.restapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "Matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Team A is required")
    @Size(min = 1, max = 50, message = "Team A must have between 1 and 50 characters")
    private String teamA;

    @NotNull(message = "Team B is required")
    @Size(min = 1, max = 50, message = "Team B must have between 1 and 50 characters")
    private String teamB;

    @NotNull(message = "Score A is required")
    private Integer scoreA;

    @NotNull(message = "Score B is required")
    private Integer scoreB;

    public Match() {
    }

    public Match(String teamA, String teamB, int scoreA, int scoreB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }
}