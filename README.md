# Training Management Platform
[![Backend CI/CD](https://github.com/Mach1233/training-management-platform/actions/workflows/backend-build.yml/badge.svg)](https://github.com/Mach1233/training-management-platform/actions/workflows/backend-build.yml)
[![Frontend CI/CD](https://github.com/Mach1233/training-management-platform/actions/workflows/frontend-build.yml/badge.svg)](https://github.com/Mach1233/training-management-platform/actions/workflows/frontend-build.yml)

Project for training platform.

## Quick Start (Docker)
The project infrastructure (Database, Keycloak, Redis) is managed via Docker.

**Start the environment:**
```bash
docker compose -f docker/docker-compose.yml up -d
```

For full details, credentials, and troubleshooting, see [Docker Documentation](docs/README.md).

## Branches
- main: Stable
- develop: Dev
- feature/: Feature branch
- release/: Release branch
- hotfix/: Hotfix branch




