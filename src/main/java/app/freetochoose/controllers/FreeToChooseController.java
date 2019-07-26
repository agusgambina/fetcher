package app.freetochoose.controllers;

import app.common.models.Position;
import app.common.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("freeToChoose")
public class FreeToChooseController {

  @Autowired
  PositionService positionService;

  @RequestMapping("/positions")
  public Iterable<Position> getPositionsJavaInSanFrancisco() {
    return positionService.search("type:Full Time,location:New York");
  }

}
