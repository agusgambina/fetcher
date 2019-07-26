package app.freetochoose.controllers;

import app.common.models.Position;
import app.common.services.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("freeToChoose")
public class FreeToChooseController {

  Logger logger = LoggerFactory.getLogger(FreeToChooseController.class);

  @Autowired
  PositionService positionService;

  @RequestMapping("/positions")
  public Iterable<Position> getAllFullTimeInNewYork() {
    logger.info("getAllFullTimeInNewYork");
    return positionService.searchAllFullTimeInNewYork();
  }

}
