package app.github.clients;

import app.github.dtos.PositionDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import javax.swing.text.Position;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface GithubClient {

  String construct_uri_positions(Map<String, String> queryParams);

  List<PositionDTO> getPositions(int quantity);

}
