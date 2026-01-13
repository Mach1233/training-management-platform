package com.training.platform.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GatewayRoutingTest {

    @Autowired
    private RouteLocator routeLocator;

    @Test
    void verifyRoutesAreConfigured() {
        routeLocator.getRoutes().collectList().subscribe(routes -> {
            assertThat(routes).isNotEmpty();
            assertThat(routes).anyMatch(route -> route.getId().equals("user-service"));
            assertThat(routes).anyMatch(route -> route.getId().equals("training-service"));
        });
    }
}
