package com.telstra.codechallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestClientException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {
        "git.base.url=https://api.github.com",
})
public class MicroServiceMainTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Value("${git.base.url}")
  private String gitBaseUrl;

  @Test
  public void testGetOldUserAccounts() throws RestClientException, MalformedURLException {
    ResponseEntity<String> response = restTemplate
        .getForEntity(new URL("http://localhost:" + port + "/old-users-account?limit=2")
            .toString(), String.class);
    assertNotNull(response.getBody());
  }
}
