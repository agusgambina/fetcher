package app.common.services.impl;

import app.common.models.Position;
import app.common.repositories.PositionRepository;
import app.common.services.PositionService;
import app.github.services.GithubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
  public Iterable<Position> searchAllJavaInSanFrancisco() {
    logger.info("searchAllJavaInSanFrancisco");
    return positionRepository.findAllJavaInSanFrancisco();
  }

  @Override
  public Iterable<Position> searchAllDataScientist() {
    logger.info("searchAllDataScientist");
    return positionRepository.findAllDataScientist();
  }

  @Override
  public Iterable<Position> searchAllFullTimeInNewYork() {
    logger.info("searchAllFullTimeInNewYork");
    return positionRepository.findAllFullTimeInNewYork();
  }

}
