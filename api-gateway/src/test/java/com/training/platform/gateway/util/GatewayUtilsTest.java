package com.training.platform.gateway.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class GatewayUtilsTest {

    @Test
    @DisplayName("Should format path correctly")
    void shouldFormatPath() {
        assertEquals("/user/profile", GatewayUtils.formatServicePath("user", "/profile"));
        assertEquals("/user/profile", GatewayUtils.formatServicePath("user", "profile"));
        assertEquals("/profile", GatewayUtils.formatServicePath(null, "/profile"));
        assertEquals("/user/", GatewayUtils.formatServicePath("user", null));
    }

    @Test
    @DisplayName("Should generate correlation id")
    void shouldGenerateCorrelationId() {
        String id1 = GatewayUtils.generateCorrelationId("TEST");
        assertTrue(id1.startsWith("TEST-"));
        assertEquals(13, id1.length()); // TEST- + 8 chars (substring 0-8)

        String id2 = GatewayUtils.generateCorrelationId(null);
        assertTrue(id2.startsWith("REQ-"));
    }

    @Test
    @DisplayName("Should validate path")
    void shouldValidatePath() {
        assertTrue(GatewayUtils.isValidPath("/api/users"));
        assertFalse(GatewayUtils.isValidPath("/api/"));
        assertFalse(GatewayUtils.isValidPath("/other/path"));
        assertFalse(GatewayUtils.isValidPath(null));
        assertFalse(GatewayUtils.isValidPath("   "));
    }
}
