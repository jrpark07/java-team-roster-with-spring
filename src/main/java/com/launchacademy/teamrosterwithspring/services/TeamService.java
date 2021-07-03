package com.launchacademy.teamrosterwithspring.services;

import com.launchacademy.teamrosterwithspring.models.Team;
import java.util.List;

public interface TeamService {
  List<Team> getTeams();
  void addTeam(Team team);
}
