package app.common.controllers;

import app.common.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

  @Autowired
  PositionService positionService;

//  @RequestMapping("/positions/")
//  public List<PositionDTO> index() {
//    ObjectMapper mapper = new ObjectMapper();
//    List<PositionDTO> positions= githubClient.getPositions(50);
//    return positions;
//  }

}
