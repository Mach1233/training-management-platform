# Development & Security Standards

This project adheres to strict security and quality standards automated via our CI/CD pipeline.

## Build Conditions
The build (`mvn clean verify`) will **FAIL** if any of the following conditions are not met.

### 1. Code Quality (Checkstyle)
- **Standard**: Google Java Style.
- **Strictness**: `failOnViolation=true`. Any linting error stops the build.
- **Config**: Root `google_checks.xml`.
- **Fix**: Run `mvn checkstyle:check` locally to see errors.

### 2. Dependency Security (OWASP)
- **Tool**: OWASP Dependency Check.
- **Goal**: Scans all dependencies for known CVEs.
- **Fix**: Upgrade vulnerable dependencies in `pom.xml`.

### 3. Test Coverage (JaCoCo)
- **Minimum Coverage**: **80%** line coverage is required per bundle.
- **Report**: `target/site/jacoco/index.html` after running `mvn verify`.
- **Fix**: Add unit tests for uncovered code.

### 4. Mutation Testing (PITest)
- **Goal**: Verifies the quality of your tests by introducing artificial bugs ("mutants").
- **Threshold**: **85%** mutation coverage.
- **Command**: `mvn org.pitest:pitest-maven:mutationCoverage`.

### 5. Static Analysis (SonarCloud)
- **Quality Gate**: Code must pass the SonarCloud Quality Gate (0 new bugs, 0 new vulnerabilities).
- **Scan**: Auto-runs on push via `mvn sonar:sonar`.

---

## Local Development Flow

Before pushing to GitHub, you should verify your code passes checks:

```bash
# 1. Fast build (compile & test only)
mvn clean package

# 2. Full Verification (what the pipeline runs)
mvn verify 

# 3. Fix linting issues manually, or check them:
mvn checkstyle:check
```

## Docker Build
The Docker image is built using a multi-stage process with a **Maven** base image to ensure the build environment consists only of standard tools.

```bash
docker build -f backend/Dockerfile -t <image-name> .
```
