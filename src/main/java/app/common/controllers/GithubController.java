package app.common.controllers;

import app.common.models.Position;
import app.common.services.PositionService;
import app.github.services.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("github")
public class GithubController {

  @Autowired
  PositionService positionService;

  @RequestMapping("/positions")
  public String retrieveAndSave(@RequestParam(value="count", defaultValue = "100") Integer count) {
    Iterable<Position> positions = positionService.retrieveAndSaveGithubPositions(count);
    return positions.toString();
  }
}
