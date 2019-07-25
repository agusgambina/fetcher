package app.common.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import app.common.models.Position;
import app.common.repositories.PositionRepository;
import app.github.clients.GithubClient;
import app.github.dtos.PositionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @Autowired
  GithubClient githubClient;

  @RequestMapping("/")
  public List<PositionDTO> index() {
    ObjectMapper mapper = new ObjectMapper();
    List<PositionDTO> positions= githubClient.getPositions(50);
    return positions;
  }

  @Autowired
  PositionRepository positionRepository;

}