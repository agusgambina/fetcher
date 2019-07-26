package app.common.controllers;

import app.common.models.Position;
import app.common.services.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("github")
public class GithubController {

  Logger logger = LoggerFactory.getLogger(GithubController.class);

  @Autowired
  PositionService positionService;

  @RequestMapping("/positions")
  public String retrieveAndSave(@RequestParam(value="count", defaultValue = "100") Integer count) {
    logger.info("retrieveAndSave");
    Iterable<Position> positions = positionService.retrieveAndSaveGithubPositions(count);
    return positions.toString();
  }
}
