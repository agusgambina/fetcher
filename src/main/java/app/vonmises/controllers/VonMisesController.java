package app.vonmises.controllers;

import app.common.models.Position;
import app.common.services.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vonMises")
public class VonMisesController {

  Logger logger = LoggerFactory.getLogger(VonMisesController.class);

  @Autowired
  PositionService positionService;

  @RequestMapping("/positions")
  public Iterable<Position> VonMisesController() {
    logger.info("VonMisesController");
    return positionService.searchAllDataScientist();
  }

}
