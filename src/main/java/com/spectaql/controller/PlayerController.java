package com.spectaql.controller;

import lombok.RequiredArgsConstructor;
import com.spectaql.model.Player;
import com.spectaql.model.Team;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.spectaql.service.PlayerService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PlayerController {
  private final PlayerService playerService;

  @QueryMapping
  public List<Player> findAll() {
    return playerService.findAll();
  }

  @QueryMapping
  public Optional<Player> findById(@Argument Integer id) {
    return playerService.findById(id);
  }

  @QueryMapping
  public List<Player> findByTeam(@Argument Team team) {
    return playerService.findByTeam(team);
  }

  @MutationMapping
  public Player createPlayer(@Argument String name, @Argument Team team, @Argument String city) {
    return playerService.createPlayer(name, team, city);
  }
}
