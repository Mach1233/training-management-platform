# CI/CD Pipeline & Automated Testing

This project uses **GitHub Actions** for Continuous Integration and Continuous Deployment (CI/CD). The pipeline ensures that every commit is strictly tested, built, and secure.

## 🚀 Workflows Overview

We have two main workflows located in `.github/workflows/`:

### 1. `backend-build.yml` (Backend Pipeline)
**Trigger**: Push/PR to `main` or `develop` (files in `*-service/**`, `api-gateway/**`, `pom.xml`).

| Step | Command / Tool | Description |
| :--- | :--- | :--- |
| **Linting** | `mvn checkstyle:check` | Enforces Google Java Style guidelines. |
| **Security** | `mvn dependency-check:check` | Scans dependencies for known vulnerabilities (OWASP). |
| **Build** | `mvn clean package` | Compiles the code and packages JARs. |
| **Unit Tests** | `mvn verify jacoco:report` | Runs JUnit tests and checks coverage (>80%). |
| **Mutation Testing** | `mvn pitest:mutationCoverage` | Modifies code to ensure tests kill mutants (>85%). |
| **Quality Gate** | **SonarCloud** | Scans code quality and security hotspots. |
| **Docker Build** | `docker build` | Builds the Spring Boot Docker image. |
| **Docker Push** | `docker push` | Pushes image to Docker Hub (tagged with commit SHA). |

### 2. `frontend-build.yml` (Frontend Pipeline)
**Trigger**: Push/PR to `main` or `develop` (files in `frontend/**`).

| Step | Command / Tool | Description |
| :--- | :--- | :--- |
| **Linting** | `npm run lint` | checks for code errors (ESLint) and vulnerabilities (`npm audit`). |
| **Unit Tests** | `npm run test:coverage` | Runs Jest tests with coverage checks. |
| **Mutation** | `npm run test:mutation` | Runs Stryker to test test-quality. |
| **Accessibility** | `npm run test:a11y` | Checks for A11y violations using `jest-axe`. |
| **Build** | `npm run build` | Compiles the React application. |
| **Docker Push** | `docker push` | pushes the optimized Nginx+React image. |

---

## 🛠️ How to Verify & Test

### 1. Automated Verification (GitHub)
The easiest way to verify is to push your code.
1.  **Commit & Push**:
    ```bash
    git add .
    git commit -m "Test CI/CD pipeline"
    git push origin develop
    ```
2.  **Check Actions**: Go to your repository's **Actions** tab. You should see `Backend CI/CD` and `Frontend CI/CD` running.
3.  **Check Badges**: The status badges in the main `README.md` will update (Green = Pass, Red = Fail).

### 2. Local Verification
You can run the same checks locally before pushing.

**Backend (Requires Maven)**:
```bash
mvn clean verify
```
*This runs Lint, Unit Tests, internal Integration Tests, and Coverage.*

**Frontend (Requires Node)**:
```bash
cd frontend
npm run lint      # Check style
npm run test      # Run tests
```

**Full Environment Check**:
Use the provided script to spin up the environment and run basic checks:
```bash
./test-local.sh
```

---

## 🔑 Required Secrets
Ensure these are set in **GitHub Settings > Secrets**:
- `DOCKER_USERNAME`: Your Docker Hub ID.
- `DOCKER_PASSWORD`: Your Docker Hub Access Token.
- `SONAR_TOKEN`: Token from SonarCloud project.

