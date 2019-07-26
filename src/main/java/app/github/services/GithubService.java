package app.github.services;

import app.common.models.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GithubService {

  List<Position> getPositions(int count);

}
