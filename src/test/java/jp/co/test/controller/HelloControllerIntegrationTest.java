package jp.co.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testHelloEndpointIntegration() {
        String url = "http://localhost:" + port + "/hello";
        String response = restTemplate.getForObject(url, String.class);
        
        assertThat(response).isEqualTo("jp.co.hello world");
    }

    @Test
    void testHelloEndpointNotNull() {
        String url = "http://localhost:" + port + "/hello";
        String response = restTemplate.getForObject(url, String.class);
        
        assertThat(response).isNotNull();
        assertThat(response).contains("hello");
    }
}
