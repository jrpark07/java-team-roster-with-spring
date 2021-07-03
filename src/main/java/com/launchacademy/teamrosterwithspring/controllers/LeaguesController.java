package com.launchacademy.teamrosterwithspring.controllers;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Team;
import java.util.List;

import com.launchacademy.teamrosterwithspring.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/")
public class LeaguesController {
  private TeamService teamService;

  @Autowired
  public LeaguesController(TeamService teamService) {
    this.teamService = teamService;
  }

  @GetMapping("/")
  public String getTeamsIndex(Model model) {
    model.addAttribute("teams", League.getLeague().getTeams());
    return "teams/index";
  }

  @GetMapping("/teams/{id}")
  public String getTeamShow(@PathVariable Integer id, Model model) {
    List<Team> teams = League.getLeague().getTeams();
    try {
      Team thisTeam = teams.get(id);
      model.addAttribute("team", thisTeam);
      return "teams/show";
    } catch (IndexOutOfBoundsException exc) {
      throw new ResponseStatusException(
              HttpStatus.NOT_FOUND, "that team doesn't exist"
      );
    }
  }

  @GetMapping("/fantasy/teams/new")
  public String getNewTeamForm(@ModelAttribute Team team) {
    return "teams/new";
  }

  @PostMapping("/fantasy/teams")
  public String createNewTeam(@ModelAttribute Team team) {
    System.out.println(this.teamService.getTeams());
    this.teamService.addTeam(team);
    return "redirect:/fantasy/teams";
  }

  @GetMapping("/fantasy/teams")
  public String getFantasyTeamsIndex(Model model) {
    model.addAttribute("teams", this.teamService.getTeams());
    return "teams/index";
  }
}
