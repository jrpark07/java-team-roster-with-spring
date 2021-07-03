package com.launchacademy.teamrosterwithspring.services;

import com.launchacademy.teamrosterwithspring.models.Team;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class TeamSessionBasedService implements TeamService {
  private List<Team> teams;

  public TeamSessionBasedService() {
    this.teams = new ArrayList<Team>();
  }
  @Override
  public List<Team> getTeams() {
    return this.teams;
  }

  @Override
  public void addTeam(Team team) {
    this.teams.add(team);
  }
}
