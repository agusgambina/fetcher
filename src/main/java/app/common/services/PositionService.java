package app.common.services;

import app.common.models.Position;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {

  Iterable<Position> retrieveAndSaveGithubPositions(int count);

  Iterable<Position> searchAllJavaInSanFrancisco();

  Iterable<Position> searchAllDataScientist();

  Iterable<Position> searchAllFullTimeInNewYork();

}
