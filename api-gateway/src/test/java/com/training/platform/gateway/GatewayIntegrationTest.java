package com.training.platform.gateway;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "spring.cloud.gateway.routes[0].id=user-service",
                "spring.cloud.gateway.routes[0].uri=http://localhost:${wiremock.server.port}",
                "spring.cloud.gateway.routes[0].predicates[0]=Path=/api/users/**",
                "spring.cloud.gateway.routes[0].filters[0]=RewritePath=/api/users/(?<segment>.*), /${segment}",
                "spring.cloud.gateway.routes[1].id=training-service",
                "spring.cloud.gateway.routes[1].uri=http://localhost:${wiremock.server.port}",
                "spring.cloud.gateway.routes[1].predicates[0]=Path=/api/courses/**",
                "spring.cloud.gateway.routes[1].filters[0]=RewritePath=/api/(?<segment>.*), /${segment}"
        })
@AutoConfigureWireMock(port = 0)
class GatewayIntegrationTest {

    private WebTestClient webTestClient;

    @Autowired
    private ApplicationContext context;

    @BeforeEach
    void setup() {
        this.webTestClient = WebTestClient.bindToApplicationContext(context)
                .apply(springSecurity())
                .configureClient()
                .build();
    }

    @Test
    void whenRequestUserService_thenPathIsRewrittenAndRouted() {
        // Stub for rewritten path /me
        stubFor(get(urlEqualTo("/me"))
                .willReturn(aResponse()
                        .withBody("{\"user\": \"test-user\"}")
                        .withHeader("Content-Type", "application/json")));

        webTestClient.mutateWith(mockJwt())
                .get()
                .uri("/api/users/me")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.user").isEqualTo("test-user");
    }

    @Test
    void whenRequestTrainingService_thenPathIsRewrittenAndRouted() {
        // Stub for rewritten path /courses/all
        stubFor(get(urlEqualTo("/courses/all"))
                .willReturn(aResponse()
                        .withBody("{\"status\": \"success\"}")
                        .withHeader("Content-Type", "application/json")));

        webTestClient.mutateWith(mockJwt())
                .get()
                .uri("/api/courses/all")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("success");
    }
}
