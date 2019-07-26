package app.common.services.impl;

import app.common.models.Position;
import app.common.repositories.PositionRepository;
import app.common.repositories.utils.SearchCriteria;
import app.common.services.PositionService;
import app.github.clients.GithubClient;
import app.github.services.GithubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

  Logger logger = LoggerFactory.getLogger(PositionServiceImpl.class);


  @Autowired
  GithubService githubService;

  @Autowired
  PositionRepository positionRepository;

  @Override
  public Iterable<Position> retrieveAndSaveGithubPositions(int count) {
    logger.info("retrieveAndSaveGithubPositions");
    List<Position> positions = githubService.getPositions(count);
    return positionRepository.saveAll(positions);
  }

  @Override
  public Iterable<Position> search(String search) {
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

}
