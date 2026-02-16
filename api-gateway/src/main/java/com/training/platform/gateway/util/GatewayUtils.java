package com.training.platform.gateway.util;

import org.springframework.stereotype.Component;

@Component
public class GatewayUtils {

    public static String formatServicePath(String serviceName, String path) {
        if (serviceName == null || serviceName.isBlank()) {
            return path;
        }
        String cleanPath = (path == null) ? "" : path;
        if (!cleanPath.startsWith("/")) {
            cleanPath = "/" + cleanPath;
        }
        return "/" + serviceName.toLowerCase() + cleanPath;
    }

    public static String generateCorrelationId(String prefix) {
        String p = (prefix == null) ? "REQ" : prefix;
        return p + "-" + java.util.UUID.randomUUID().toString().substring(0, 8);
    }

    public static boolean isValidPath(String path) {
        if (path == null || path.isBlank()) {
            return false;
        }
        return path.startsWith("/api/") && path.length() > 5;
    }
}
