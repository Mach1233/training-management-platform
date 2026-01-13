# 🧪 Testing Guide

This guide explains how to test the Training Management Platform and its quality standards.

## 🛠️ Prerequisites

- **Java 21** installed.
- **Maven** installed.
- **Keycloak** running (if testing security routes).

---

## 🏃 Quick Test (Root)

To build the entire project and run all standard tests:
```powershell
mvn clean install
```

---

## 💎 Quality & Security Tests

You can run specific quality checks for each module (e.g., in `api-gateway`):

### 1. Code Style (Checkstyle)
Ensures the code follows Google's Java Style Guide.
```powershell
mvn checkstyle:check -pl api-gateway
```
*Output: Check `target/site/checkstyle.html` for results.*

### 2. Vulnerability Scan (OWASP)
Scans dependencies for known security flaws.
```powershell
mvn dependency-check:check -pl api-gateway
```
*Output: Check `target/dependency-check-report.html` for results.*

### 3. Test Coverage (JaCoCo)
Shows which lines of code are covered by tests.
```powershell
mvn test jacoco:report -pl api-gateway
```
*Output: Open `api-gateway/target/site/jacoco/index.html` in your browser.*

### 4. Mutation Testing (PIT)
Tests the *quality* of your tests by injecting bugs into your code.
```powershell
mvn pitest:mutationCoverage -pl api-gateway
```
*Output: Open `api-gateway/target/pit-reports/index.html` in your browser.*

---

## 🌐 API Gateway Manual Testing

1. **Start the Gateway**:
   ```powershell
   cd api-gateway
   mvn spring-boot:run
   ```

2. **Check Health**:
   Open [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health) in your browser.
   *Result should be:* `{"status":"UP"}`

3. **Verify Security**:
   Try accessing a protected route:
   ```powershell
   Invoke-RestMethod -Uri "http://localhost:8080/api/users"
   ```
   *Expected Result: `401 Unauthorized` (Security is working!).*
