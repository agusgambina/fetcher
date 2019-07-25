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

@Component
public class GithubServiceImpl implements GithubService {

  @Autowired
  private GithubClient githubClient;

  @Override
  public List<Position> getPositions(int count) {
    List<PositionDTO> positionDTOList = githubClient.getPositions(count);
    List<Position> positionList;
    positionList = positionDTOList.stream()
      .filter(element -> element != null)
      .map(element -> new Position(
        1,
        LocalDateTime.now(),
        LocalDateTime.now(),
        element.getId(),
        element.getTitle(),
        element.getCompany(),
        element.getType(),
        element.getLocation()
      ))
      .collect(Collectors.toList());
    return positionList;
  }



}
