package com.training.platform.gateway.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.junit.jupiter.api.DisplayName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecurityConfigTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ApplicationContext context;

    @Test
    void securityFilterChainBeanExists() {
        assertThat(context.getBean(SecurityWebFilterChain.class)).isNotNull();
    }

    @Test
    void whenAccessActuatorHealth_thenOk() {
        webTestClient.get()
            .uri("/actuator/health")
            .exchange()
            .expectStatus().isOk();
    }

    @Test
    void whenAccessActuatorInfo_thenOk() {
        webTestClient.get()
            .uri("/actuator/info")
            .exchange()
            .expectStatus().isOk();
    }

    @Test
    void whenAccessProtectedRouteWithoutToken_thenUnauthorized() {
        webTestClient.get()
            .uri("/api/users")
            .exchange()
            .expectStatus().isUnauthorized();
    }

    @Test
    @DisplayName("Should return 401 for protected service paths")
    void shouldReturn401ForServicePaths() {
        String[] paths = {"/api/users/me", "/api/courses/1", "/api/formations/enroll"};
        for (String path : paths) {
            webTestClient.get()
                .uri(path)
                .exchange()
                .expectStatus().isUnauthorized();
        }
    }

    @Test
    @DisplayName("Should return 401 for any api path without token")
    void shouldReturn401ForAnyApiPath() {
        webTestClient.post()
            .uri("/api/any/path")
            .exchange()
            .expectStatus().isUnauthorized();
    }
}
