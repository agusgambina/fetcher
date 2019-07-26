package app.vonmises.controllers;

import app.common.models.Position;
import app.common.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vonMises")
public class VonMisesController {

  @Autowired
  PositionService positionService;

  @RequestMapping("/positions")
  public Iterable<Position> getPositionsJavaInSanFrancisco() {
    return positionService.search("name:data scientist");
  }

}
