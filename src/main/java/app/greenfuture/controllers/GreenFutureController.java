package app.greenfuture.controllers;

import app.common.models.Position;
import app.common.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greenFuture")
public class GreenFutureController {

  @Autowired
  PositionService positionService;

  @RequestMapping("/positions")
  public Iterable<Position> getPositionsJavaInSanFrancisco() {
    return positionService.search("name:Java,location:San Francisco,name:Java");
  }
}
