package app.github.clients.impl;

import app.github.clients.GithubClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GithubClientImplTest {

  private GithubClient githubClient = new GithubClientImpl();

  Map<String, String> mapToConvert;

  @BeforeEach
  public void setup() {
    mapToConvert = new HashMap<String, String>();
    mapToConvert.put("page", String.valueOf(1));
  }

  @Test
  void constructUriPositions() {
    Map<String, String> queryParams = new HashMap<String, String>();
    queryParams.put("page", String.valueOf(1));

    assertEquals(
      "https://jobs.github.com/positions.json?page=1",
      githubClient.constructUriPositions(queryParams));
  }

}