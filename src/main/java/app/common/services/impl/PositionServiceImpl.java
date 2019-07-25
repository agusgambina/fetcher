package app.common.services.impl;

import app.common.models.Position;
import app.common.repositories.PositionRepository;
import app.common.services.PositionService;
import app.github.clients.GithubClient;
import app.github.services.GithubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
