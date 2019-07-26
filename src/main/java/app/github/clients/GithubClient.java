package app.github.clients;

import app.github.dtos.PositionDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface GithubClient {

  String constructUriPositions(Map<String, String> queryParams);

  List<PositionDTO> getPositions(int count);

}
