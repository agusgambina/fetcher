package app.github.services.impl;

import app.common.models.Position;
import app.github.clients.GithubClient;
import app.github.dtos.PositionDTO;
import app.github.services.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubServiceImpl implements GithubService {

  @Autowired
  private GithubClient githubClient;

  @Override
  public List<Position> getPositions(int count) {
    List<PositionDTO> positionDTOList = githubClient.getPositions(count);
    List<Position> positionList;
    positionList = positionDTOList.stream()
      .filter(element -> element != null)
      .map(element -> mapToPosition(element))
      .collect(Collectors.toList());
    return positionList;
  }

  private Position mapToPosition(PositionDTO positionDTO) {
    Position position = new Position();
    position.setExternalId(positionDTO.getId());
    position.setName(positionDTO.getTitle());
    position.setCurrentCompany(positionDTO.getCompany());
    position.setType(positionDTO.getType());
    position.setLocation(positionDTO.getLocation());
    return position;
  }

}
