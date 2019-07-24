package app.github.clients.impl;

import app.github.clients.GithubClient;
import app.github.dtos.PositionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Component
public class GithubClientImpl implements GithubClient {

  private final String SCHEME = "https";
  private final String HOST = "jobs.github.com";
  private final String PATH_POSITIONS = "positions.json";
  private final int PAGINATING_ELEMENTS = 50;

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }


  @Override
  public String construct_uri_positions(Map<String, String> queryParams) {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
    for (Map.Entry<String, String> entry : queryParams.entrySet()) {
      params.add(entry.getKey(), entry.getValue());
    }

    UriComponents uriComponents = UriComponentsBuilder.newInstance()
      .scheme(SCHEME).host(HOST)
      .path(PATH_POSITIONS)
      .queryParams(params).build();

    return uriComponents.toString();
  }

  ObjectMapper mapper = new ObjectMapper();


  @Override
  public List<PositionDTO> getPositions(int quantity) {

    int pagesToRequest = (quantity + PAGINATING_ELEMENTS - 1) / PAGINATING_ELEMENTS;
    Map<String, String> queryParams = new HashMap<String, String>();
    List<PositionDTO> positionDTOList = new ArrayList<PositionDTO>();

    for(int page = 1; page <= pagesToRequest; page++) {
      if(queryParams.isEmpty()) {
        queryParams.put("pages", String.valueOf(page));
      } else {
        queryParams.clear();
        queryParams.put("pages", String.valueOf(page));
      }
      ResponseEntity<List<PositionDTO>> response  = restTemplate().exchange(
        construct_uri_positions(queryParams),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<PositionDTO>>(){});
      positionDTOList.addAll(response.getBody());
    }

    return positionDTOList;
  }
}