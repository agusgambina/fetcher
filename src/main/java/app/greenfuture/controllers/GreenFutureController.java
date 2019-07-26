package app.greenfuture.controllers;

import app.common.models.Position;
import app.common.services.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greenFuture")
public class GreenFutureController {

  Logger logger = LoggerFactory.getLogger(GreenFutureController.class);

  @Autowired
  PositionService positionService;

  @RequestMapping("/positions")
  public Iterable<Position> getPositionsJavaInSanFrancisco() {
    logger.info("getPositionsJavaInSanFrancisco");
    return positionService.searchAllJavaInSanFrancisco();
  }

}
