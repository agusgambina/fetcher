package app.common.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import app.common.models.Position;
import app.common.repositories.PositionRepository;
import app.github.clients.GithubClient;
import app.github.dtos.PositionDTO;
import app.models.Greeting;
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

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new Greeting(counter.incrementAndGet(),
      String.format(template, name));
  }

  @Autowired
  PositionRepository positionRepository;

  @GetMapping(path="/add") // Map ONLY GET Requests
  public @ResponseBody
  String addNewPosition () {
    Position position = new Position();
    position.setExternalId("test-id");
    position.setName("test-name");
    position.setCurrentCompany("test-current-company");
    position.setLocation("test-location");
    position.setType("test-type");
    positionRepository.save(position);
    return "Saved";
  }

}