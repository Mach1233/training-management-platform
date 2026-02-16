# 📚 Project Documentation

Welcome to the Training Management Platform documentation. This repository contains the documentation for our microservices architecture, infrastructure setup, and development guidelines.

## 📝 Executive Summary

The **Training Management Platform** is a scalable, secure microservices-based application designed to manage educational courses and registrations. 

At the heart of the architecture is the **API Gateway**, which serves as the unified entry point. It handles:
- **Dynamic Routing**: Intelligently forwarding requests to services like `user-service` and `training-service`.
- **Centralized Security**: Externalizing authentication to **Keycloak** and validating tokens.
- **Resilience**: Protecting systems with rate limiting and circuit breakers.
- **Observability**: Providing real-time health checks and metrics.

## 🚀 Getting Started

- **[Development Setup](DEVELOPMENT.md)**: How to set up your local environment.
- **[Docker Setup](DOCKER_SETUP.md)**: Running the infrastructure (PostgreSQL, Redis, Keycloak) using Docker Compose.

## 🛠️ Components

- **[API Gateway](api-gateway.md)**: Detailed routing, security, and configuration roles.
- **[Keycloak Integration](KEYCLOAK_INTEGRATION.md)**: Authentication and authorization details.
- **[pgAdmin Guide](pgadmin_guide.md)**: Accessing the database management UI.

## ⛓️ Infrastructure & DevOps

- **[CI/CD Pipeline](CI_CD.md)**: GitHub Actions and Automated Testing details.

---

*Last Updated: January 2026*
