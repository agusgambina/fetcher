package app.common.controllers;

import app.common.repositories.PositionRepository;
import app.github.clients.GithubClient;
import app.github.dtos.PositionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

  Logger logger = LoggerFactory.getLogger(GreetingController.class);

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