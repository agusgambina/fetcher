package app.common.services;

import app.common.models.Position;
import app.github.clients.GithubClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PositionService {

  Iterable<Position> retrieveAndSaveGithubPositions(int count);

  Iterable<Position> search(String search);

}
