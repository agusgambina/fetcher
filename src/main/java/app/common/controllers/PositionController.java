package app.common.controllers;

import app.common.models.Position;
import app.common.repositories.PositionRepository;
import app.common.repositories.utils.SearchCriteria;
import app.common.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("positions")
public class PositionController {

  @Autowired
  PositionService positionService;

  @Autowired
  PositionRepository positionRepository;

  @RequestMapping(method = RequestMethod.GET, value = "")
  @ResponseBody
  public List<Position> findAll(@RequestParam(value = "search", required = false) String search) {
    List<SearchCriteria> params = new ArrayList<SearchCriteria>();
    if (search != null) {
      Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
      Matcher matcher = pattern.matcher(search + ",");
      while (matcher.find()) {
        params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
      }
    }
    return positionRepository.search(params);
  }

//  @RequestMapping("/positions/")
//  public List<PositionDTO> index() {
//    ObjectMapper mapper = new ObjectMapper();
//    List<PositionDTO> positions= githubClient.getPositions(50);
//    return positions;
//  }

}
