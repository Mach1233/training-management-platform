# 🔐 Keycloak Integration & IAM Guide

**Strategic Identity and Access Management (IAM) for the Training Management Platform.**

---

## 🚀 Environment Overview
*   **Version**: Keycloak 25.0 (Containerized)
*   **Realm**: `training-platform-realm`
*   **Auth Flow**: OpenID Connect (OIDC) / OAuth 2.0

---

## 🌐 1. Essential Endpoints

| Purpose | Endpoint URL |
| :--- | :--- |
| **Admin Console** | [http://localhost:8080](http://localhost:8080) |
| **Well-Known Config** | `.../realms/training-platform-realm/.well-known/openid-configuration` |
| **Auth Endpoint** | `/protocol/openid-connect/auth` |
| **Token Endpoint** | `/protocol/openid-connect/token` |
| **JWKS (Public Keys)** | `/protocol/openid-connect/certs` |

---

## 👥 2. Roles & Permissions
We utilize a RBAC (Role-Based Access Control) model.

| Role | Description | Default for New Users? |
| :--- | :--- | :--- |
| `LEARNER` | Can access courses and view certifications. | **Yes** (via composite role) |
| `INSTRUCTOR`| Can create and manage course content. | No |
| `MANAGER` | Can manage registrations and workflows. | No |
| `ADMIN` | Full system administrative access. | No |

---

## 🔑 3. Client Configuration

### 💻 Frontend (Next.js)
*   **Client ID**: `training-platform-frontend`
*   **Type**: **Public** (No Secret Required)
*   **Redirect URIs**: `http://localhost:3000/*`

### ⚙️ Backend (Spring Boot Services)
*   **Client ID**: `training-platform-backend`
*   **Type**: **Confidential** (Secret Required)
*   **Purpose**: Token introspection and service-to-service communication.

> [!CAUTION]
> **Client Secret Security**: The `KEYCLOAK_BACKEND_CLIENT_SECRET` must **never** be committed to source control. It should be injected via environment variables or secure secrets management tools.

---

## 📝 4. Administration Tasks

### Adding a New User Manually
1. Navigate to the **Users** section in the Admin Console.
2. Click **Add User** and provide the necessary details.
3. Under the **Credentials** tab, set a permanent password.
4. Go to **Role Mappings** to assign specific platform roles (e.g., `INSTRUCTOR`).

### Inspecting Tokens
To verify claims and roles during development:
1. Copy the `access_token` from your browser or API response.
2. Paste it into [JWT.io](https://jwt.io) to inspect the payload.
3. Look for the `realm_access.roles` claim.

---

*This document is updated as of January 09, 2026.*
