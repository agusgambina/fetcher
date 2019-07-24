package app.github.clients.impl;

import app.github.clients.GithubClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GithubClientImplTest {

  GithubClient githubClient = new GithubClientImpl();

  Map<String, String> mapToConvert;

  @BeforeEach
  public void setup() {
    mapToConvert = new HashMap<String, String>();
    mapToConvert.put("page", String.valueOf(1));
  }

  @Test
  void construct_uri_positions() {
    Map<String, String> queryParams = new HashMap<String, String>();
    queryParams.put("page", String.valueOf(1));

    assertEquals(
      "https://jobs.github.com/positions.json?page=1",
      githubClient.construct_uri_positions(queryParams));
  }

}