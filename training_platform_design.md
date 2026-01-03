# Training Management Platform - Complete Task Breakdown

> **Architecture Decision**: Using Keycloak for Authentication & Authorization  
> **Project Duration**: 6 months (26 weeks)  
> **Total Tasks**: 140+ tasks across 13 phases

---

# 🔑 AUTHENTICATION STRATEGY: KEYCLOAK

## Why Keycloak?
- ✅ Production-ready authentication server (no need to build from scratch)
- ✅ Built-in user management, roles, and permissions
- ✅ OAuth2, OpenID Connect, SAML support
- ✅ Social login integration (Google, GitHub, etc.)
- ✅ User federation (LDAP, Active Directory)
- ✅ Multi-factor authentication (MFA) out of the box
- ✅ Admin UI for user management
- ✅ RESTful API for user operations
- ✅ Perfect for microservices architecture

## What We Build
Instead of a full Auth Service, we create a **lightweight User Service** that:
- Syncs users from Keycloak
- Stores additional user profile data (phone, company, bio)
- Manages user preferences
- Acts as a bridge between Keycloak and other services

---

# PHASE 1: PROJECT FOUNDATION (WEEKS 1-2)

## 🛠️ Setup & Infrastructure

### 1.1 Development Environment Setup
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Install JDK 17 or 21
- [ ] Install IntelliJ IDEA or Eclipse
- [ ] Install Node.js (v18+) and npm
- [ ] Install Docker Desktop
- [ ] Install PostgreSQL 15+
- [ ] Install Postman for API testing
- [ ] Install Git
- [ ] Install VS Code for frontend
- [ ] Install kubectl (for Kubernetes)
- [ ] Install oc CLI (for OpenShift)

**Acceptance Criteria**: All tools installed and verified working

---

### 1.2 Git Repository Setup
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create GitHub/GitLab repository: `training-management-platform`
- [ ] Setup branch protection for `main` branch
- [ ] Create `develop` branch for development
- [ ] Configure branch strategy (GitFlow)
- [ ] Create `.gitignore` for Java and Node.js
- [ ] Add all team members as collaborators
- [ ] Create initial README.md
- [ ] Setup GitHub Projects board
- [ ] Create initial project structure:

```
training-platform/
├── keycloak/                  # Keycloak configuration
├── user-service/              # User profiles & preferences
├── course-service/            # Course management
├── registration-service/      # Enrollments & progress
├── workflow-service/          # Approvals & notifications
├── certification-service/     # Certificates & badges
├── analytics-service/         # Reports & insights
├── api-gateway/               # Spring Cloud Gateway
├── frontend/                  # Next.js application
├── docker/                    # Docker compose files
├── kubernetes/                # K8s deployment files
└── docs/                      # Documentation
```

**Acceptance Criteria**: Repository accessible with proper structure

---

### 1.3 Database Setup
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Install PostgreSQL 15+
- [ ] Create database: `training_platform`
- [ ] Create schemas:
  - [ ] `user_schema` (for User Service)
  - [ ] `course_schema` (for Course Service)
  - [ ] `registration_schema` (for Registration Service)
  - [ ] `workflow_schema` (for Workflow Service)
  - [ ] `certification_schema` (for Certification Service)
  - [ ] `analytics_schema` (for Analytics Service)
- [ ] Create database user: `training_admin`
- [ ] Grant proper permissions to each schema
- [ ] Configure connection pooling
- [ ] Test connections from localhost
- [ ] Create `application.properties` template with DB config
- [ ] Document database credentials securely

**Acceptance Criteria**: Database ready, all schemas created, connection tested

---

### 1.4 Docker Configuration
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Create `docker-compose.yml` in `docker/` folder
- [ ] Add PostgreSQL container (port 5432)
- [ ] Add Keycloak container (port 8080)
- [ ] Add Redis container (port 6379) for caching
- [ ] Add PgAdmin container (port 5050) for DB GUI
- [ ] Configure network: `training-network`
- [ ] Configure volume mappings for data persistence
- [ ] Add environment variables file `.env`
- [ ] Test: `docker-compose up -d`
- [ ] Verify all containers running: `docker ps`
- [ ] Access Keycloak admin UI: http://localhost:8080
- [ ] Access PgAdmin: http://localhost:5050

**Acceptance Criteria**: All containers running, accessible, and communicating

---

### 1.5 CI/CD Pipeline Setup
**Duration**: 2 days | **Priority**: 🟡 High

- [ ] Create `.github/workflows/backend-build.yml`
- [ ] Create `.github/workflows/frontend-build.yml`
- [ ] Configure Java build with Maven
- [ ] Configure Node.js build with npm
- [ ] Add unit test execution on PR
- [ ] Add code coverage reporting
- [ ] Setup Docker image building
- [ ] Configure image push to registry
- [ ] Add status badges to README
- [ ] Test pipeline with sample commit

**Acceptance Criteria**: Automated build and test on every push

---

# PHASE 2: KEYCLOAK SETUP (WEEK 3)

## 🔐 Authentication Server Configuration

### 2.1 Keycloak Installation & Configuration
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Start Keycloak container via docker-compose
- [ ] Access admin console: http://localhost:8080
- [ ] Login with admin credentials (admin/admin)
- [ ] Create realm: `training-platform-realm`
- [ ] Configure realm settings (session timeout, tokens)
- [ ] Enable user registration
- [ ] Configure password policies (min 8 chars, numbers, special chars)
- [ ] Setup email settings (SMTP for notifications)
- [ ] Test email delivery

**Acceptance Criteria**: Keycloak running, realm created, email working

---

### 2.2 Keycloak Client Configuration
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create client: `training-platform-backend`
  - [ ] Client Protocol: openid-connect
  - [ ] Access Type: confidential
  - [ ] Valid Redirect URIs: http://localhost:8080/*
  - [ ] Web Origins: http://localhost:3000
- [ ] Get client secret from Credentials tab
- [ ] Create client: `training-platform-frontend`
  - [ ] Access Type: public
  - [ ] Valid Redirect URIs: http://localhost:3000/*
- [ ] Save client IDs and secrets securely

**Acceptance Criteria**: Both clients configured, credentials saved

---

### 2.3 Keycloak Roles Configuration
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create realm roles:
  - [ ] `ADMIN` - Full system access
  - [ ] `MANAGER` - Approval and team management
  - [ ] `INSTRUCTOR` - Course creation and management
  - [ ] `LEARNER` - Default role for students
- [ ] Set `LEARNER` as default role
- [ ] Configure role mappings
- [ ] Create composite roles if needed
- [ ] Document role permissions matrix

**Acceptance Criteria**: All roles created and configured

---

### 2.4 Test User Creation
**Duration**: 0.5 day | **Priority**: 🟡 High

- [ ] Create test users in Keycloak:
  - [ ] admin@example.com (ADMIN role)
  - [ ] manager@example.com (MANAGER role)
  - [ ] instructor@example.com (INSTRUCTOR role)
  - [ ] learner@example.com (LEARNER role)
- [ ] Set temporary passwords
- [ ] Test login for each user
- [ ] Verify role assignments
- [ ] Test password reset flow

**Acceptance Criteria**: All test users can login successfully

---

### 2.5 Keycloak Integration Documentation
**Duration**: 1 day | **Priority**: 🟡 High

- [ ] Document Keycloak URLs and endpoints
- [ ] Document realm configuration
- [ ] Document client IDs and how to get secrets
- [ ] Create guide for adding new users
- [ ] Create guide for role management
- [ ] Document token structure (JWT)
- [ ] Create integration guide for services
- [ ] Add to project wiki/docs

**Acceptance Criteria**: Complete Keycloak documentation available

---

# PHASE 3: API GATEWAY (WEEK 4)

## 🌐 Central Entry Point

### 3.1 Gateway Project Initialization
**Duration**: 0.5 day | **Priority**: 🔴 Critical

- [ ] Create Spring Boot project via start.spring.io
  - [ ] Group: com.linsoft
  - [ ] Artifact: api-gateway
  - [ ] Dependencies: Gateway, Security, OAuth2 Client, OAuth2 Resource Server
- [ ] Set server port: 8080 (in application.yml)
- [ ] Create package structure
- [ ] Add to parent project structure

**Acceptance Criteria**: Gateway project created and running

---

### 3.2 Gateway Routing Configuration
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create `application.yml` with route configuration:
  - [ ] Route to User Service (http://localhost:8082)
  - [ ] Route to Course Service (http://localhost:8083)
  - [ ] Route to Registration Service (http://localhost:8084)
  - [ ] Route to Workflow Service (http://localhost:8085)
  - [ ] Route to Certification Service (http://localhost:8086)
  - [ ] Route to Analytics Service (http://localhost:8087)
- [ ] Configure route predicates (Path matching)
- [ ] Add route filters (logging, header manipulation)
- [ ] Test routing with sample endpoint

**Acceptance Criteria**: Gateway routes requests to services correctly

---

### 3.3 Keycloak Integration in Gateway
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Add Keycloak Spring Boot Adapter dependency
- [ ] Configure OAuth2 Resource Server in application.yml:
  - [ ] Issuer URI: http://localhost:8080/realms/training-platform-realm
  - [ ] JWK Set URI for token validation
- [ ] Create SecurityConfig class
- [ ] Configure security rules:
  - [ ] Public endpoints (no auth needed)
  - [ ] Protected endpoints (require authentication)
  - [ ] Role-based access control
- [ ] Add JWT token validation filter
- [ ] Extract user info from JWT
- [ ] Forward user context to downstream services
- [ ] Test with Postman (get token from Keycloak, call protected endpoint)

**Acceptance Criteria**: Gateway validates tokens, enforces security

---

### 3.4 CORS & Rate Limiting
**Duration**: 1 day | **Priority**: 🟡 High

- [ ] Configure CORS in application.yml:
  - [ ] Allow origin: http://localhost:3000 (frontend)
  - [ ] Allow credentials: true
  - [ ] Allow methods: GET, POST, PUT, DELETE
  - [ ] Allow headers: Authorization, Content-Type
- [ ] Add Redis rate limiter dependency
- [ ] Configure rate limiting:
  - [ ] 100 requests per minute per user
  - [ ] Different limits for different endpoints
- [ ] Test CORS from browser
- [ ] Test rate limiting with multiple requests

**Acceptance Criteria**: CORS working, rate limiting active

---

### 3.5 Gateway Testing & Dockerization
**Duration**: 1 day | **Priority**: 🟡 High

- [ ] Write unit tests for security config
- [ ] Write integration tests for routing
- [ ] Test all routes with Postman
- [ ] Create Postman collection with auth
- [ ] Create Dockerfile
- [ ] Build Docker image
- [ ] Add to docker-compose.yml
- [ ] Test gateway in Docker

**Acceptance Criteria**: Gateway tested, dockerized, documented

---

# PHASE 4: USER SERVICE (WEEK 5)

## 👤 User Profile & Preferences Management

### 4.1 User Service Project Setup
**Duration**: 0.5 day | **Priority**: 🔴 Critical

- [ ] Create Spring Boot project
  - [ ] Dependencies: Web, JPA, PostgreSQL, Validation, Lombok, OAuth2 Resource Server
- [ ] Set server port: 8082
- [ ] Configure database connection to `user_schema`
- [ ] Configure Keycloak for token validation
- [ ] Create package structure

**Acceptance Criteria**: Project initialized, connects to DB and Keycloak

---

### 4.2 User Entities Creation
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create `UserProfile` entity:
  - [ ] id, keycloak_user_id (UUID from Keycloak)
  - [ ] phone, company, redhat_partner_id
  - [ ] job_title, bio, avatar_url, linkedin_url
  - [ ] created_at, updated_at
- [ ] Create `UserPreferences` entity:
  - [ ] id, user_profile_id
  - [ ] language, timezone
  - [ ] email_notifications, push_notifications
  - [ ] theme (light/dark)
  - [ ] preferences (JSON for flexible settings)
- [ ] Create repositories for both entities
- [ ] Add custom query: `findByKeycloakUserId(String keycloakId)`

**Acceptance Criteria**: Entities created with proper relationships

---

### 4.3 Keycloak User Sync Service
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Add Keycloak Admin Client dependency
- [ ] Create `KeycloakUserService` class
- [ ] Implement `syncUserFromKeycloak(String keycloakUserId)`:
  - [ ] Fetch user details from Keycloak API
  - [ ] Create or update UserProfile in database
  - [ ] Extract email, name, roles from Keycloak
  - [ ] Store Keycloak user ID as reference
- [ ] Implement automatic sync on first login
- [ ] Add scheduled job to sync users periodically
- [ ] Handle Keycloak API errors gracefully

**Acceptance Criteria**: Users automatically synced from Keycloak

---

### 4.4 User Service Business Logic
**Duration**: 2 days | **Priority**: 🟡 High

- [ ] Create DTOs:
  - [ ] UserProfileRequest
  - [ ] UserProfileResponse
  - [ ] UserPreferencesRequest
  - [ ] UserPreferencesResponse
- [ ] Create `UserService` interface
- [ ] Implement `UserServiceImpl`:
  - [ ] getUserProfile(String keycloakUserId)
  - [ ] updateUserProfile(String keycloakUserId, UserProfileRequest)
  - [ ] uploadAvatar(String keycloakUserId, MultipartFile file)
  - [ ] getUserPreferences(String keycloakUserId)
  - [ ] updateUserPreferences(String keycloakUserId, UserPreferencesRequest)
- [ ] Add input validation
- [ ] Add exception handling

**Acceptance Criteria**: User service logic implemented

---

### 4.5 File Upload for Avatars
**Duration**: 1 day | **Priority**: 🟢 Medium

- [ ] Configure file upload properties (max size: 5MB)
- [ ] Create `FileStorageService` interface
- [ ] Implement local filesystem storage:
  - [ ] Store in `/uploads/avatars/` directory
  - [ ] Generate unique filename
  - [ ] Create thumbnail (100x100px)
- [ ] Add image validation (only jpg, png)
- [ ] Implement file serving endpoint
- [ ] Alternative: Implement S3 storage (optional)

**Acceptance Criteria**: Avatar upload and retrieval working

---

### 4.6 User REST Controllers
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create `UserController`:
  - [ ] GET /api/users/me - Get current user profile
  - [ ] GET /api/users/{id} - Get user by ID
  - [ ] PUT /api/users/me - Update current user profile
  - [ ] POST /api/users/me/avatar - Upload avatar
  - [ ] GET /api/users/me/preferences - Get preferences
  - [ ] PUT /api/users/me/preferences - Update preferences
- [ ] Extract user ID from JWT token (@AuthenticationPrincipal)
- [ ] Add authorization checks
- [ ] Add Swagger documentation

**Acceptance Criteria**: All endpoints working with proper security

---

### 4.7 Testing & Dockerization
**Duration**: 1.5 days | **Priority**: 🟡 High

- [ ] Write unit tests for services (80%+ coverage)
- [ ] Write integration tests for controllers
- [ ] Test with Keycloak tokens
- [ ] Test avatar upload
- [ ] Create Postman collection
- [ ] Create Dockerfile
- [ ] Add to docker-compose.yml
- [ ] Update API Gateway routes
- [ ] Test end-to-end: Login → Get/Update Profile

**Acceptance Criteria**: User service tested, deployed, documented

---

# PHASE 5: COURSE SERVICE (WEEKS 6-7)

## 📚 Course Catalog Management

### 5.1 Course Service Project Setup
**Duration**: 0.5 day | **Priority**: 🔴 Critical

- [ ] Create Spring Boot project (Web, JPA, PostgreSQL, Validation, OAuth2)
- [ ] Set server port: 8083
- [ ] Configure `course_schema`
- [ ] Configure Keycloak token validation
- [ ] Create package structure

**Acceptance Criteria**: Project initialized

---

### 5.2 Course Entities Creation
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create `Course` entity (all fields from architecture doc)
- [ ] Create `Instructor` entity
- [ ] Create `CourseModule` entity
- [ ] Create `CoursePrerequisite` entity
- [ ] Define relationships (@OneToMany, @ManyToOne)
- [ ] Create repositories with custom queries
- [ ] Add indexes for performance

**Acceptance Criteria**: All entities and repositories created

---

### 5.3 Course CRUD Operations
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Create DTOs (CourseRequest, CourseResponse, CourseListResponse)
- [ ] Implement `CourseService` interface
- [ ] Implement create, read, update, delete operations
- [ ] Add pagination support
- [ ] Add filtering (by difficulty, instructor, status, date range)
- [ ] Add sorting options
- [ ] Implement soft delete (archive)
- [ ] Add validation rules

**Acceptance Criteria**: CRUD operations working

---

### 5.4 Course Search & Filtering
**Duration**: 1 day | **Priority**: 🟡 High

- [ ] Implement Specification pattern for dynamic queries
- [ ] Add search by title/description (full-text search)
- [ ] Add filter combinations
- [ ] Optimize queries with proper indexes
- [ ] Test with large dataset (1000+ courses)
- [ ] Add caching for popular queries (Redis)

**Acceptance Criteria**: Advanced search working efficiently

---

### 5.5 Course Modules Management
**Duration**: 1 day | **Priority**: 🟡 High

- [ ] Implement module CRUD operations
- [ ] Add module reordering (drag-and-drop order)
- [ ] Implement prerequisite validation
- [ ] Add module content upload (optional)
- [ ] Test module operations

**Acceptance Criteria**: Module management complete

---

### 5.6 Instructor Management
**Duration**: 1 day | **Priority**: 🟡 High

- [ ] Implement instructor registration
- [ ] Link instructor with Keycloak user
- [ ] Implement instructor profile management
- [ ] Add instructor verification (Red Hat expert status)
- [ ] Get instructor's courses
- [ ] Calculate instructor rating

**Acceptance Criteria**: Instructor features working

---

### 5.7 Course REST Controllers
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Create `CourseController`:
  - [ ] GET /api/courses - List with filters/pagination
  - [ ] POST /api/courses - Create (INSTRUCTOR/ADMIN)
  - [ ] GET /api/courses/{id} - Get details
  - [ ] PUT /api/courses/{id} - Update (Owner/ADMIN)
  - [ ] DELETE /api/courses/{id} - Archive
  - [ ] GET /api/courses/search
- [ ] Create `ModuleController`
- [ ] Create `InstructorController`
- [ ] Add role-based authorization (@PreAuthorize)
- [ ] Add Swagger documentation

**Acceptance Criteria**: All endpoints working with proper security

---

### 5.8 Testing & Dockerization
**Duration**: 2 days | **Priority**: 🟡 High

- [ ] Write comprehensive unit tests
- [ ] Write integration tests
- [ ] Test search performance
- [ ] Test concurrent operations
- [ ] Create Postman collection
- [ ] Dockerize service
- [ ] Update API Gateway
- [ ] Test end-to-end flows

**Acceptance Criteria**: Course service deployed and tested

---

# PHASE 6: REGISTRATION SERVICE (WEEKS 8-9)

## 📝 Enrollment & Progress Tracking

### 6.1 Registration Service Setup
**Duration**: 0.5 day | **Priority**: 🔴 Critical

- [ ] Create Spring Boot project
- [ ] Set port: 8084
- [ ] Configure `registration_schema`
- [ ] Add RestTemplate for inter-service calls
- [ ] Configure Keycloak

**Acceptance Criteria**: Project initialized

---

### 6.2 Registration Entities
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create `Registration` entity
- [ ] Create `Attendance` entity
- [ ] Create `ProgressTracking` entity
- [ ] Create `QuizResult` entity
- [ ] Add unique constraint (user_id, course_id)
- [ ] Create all repositories

**Acceptance Criteria**: Entities created

---

### 6.3 Enrollment Logic
**Duration**: 3 days | **Priority**: 🔴 Critical

- [ ] Implement `RegistrationService`
- [ ] Implement `enrollInCourse()`:
  - [ ] Check course exists (call Course Service)
  - [ ] Check available spots
  - [ ] Check prerequisites
  - [ ] Prevent duplicate enrollment
  - [ ] Create registration (status: PENDING if approval needed)
  - [ ] Decrease available spots
  - [ ] Trigger approval workflow if needed
  - [ ] Send confirmation notification
- [ ] Add @Transactional for atomicity
- [ ] Implement optimistic locking
- [ ] Handle concurrent enrollments
- [ ] Add comprehensive error handling

**Acceptance Criteria**: Enrollment logic robust and tested

---

### 6.4 Attendance Tracking
**Duration**: 1 day | **Priority**: 🟡 High

- [ ] Implement attendance marking (Instructor only)
- [ ] Calculate attendance percentage
- [ ] Generate attendance reports
- [ ] Add attendance notifications

**Acceptance Criteria**: Attendance system working

---

### 6.5 Progress Tracking System
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Implement progress update per module
- [ ] Calculate overall completion percentage
- [ ] Track time spent
- [ ] Trigger milestones (25%, 50%, 75%, 100%)
- [ ] Call Certification Service at 100%
- [ ] Generate progress reports

**Acceptance Criteria**: Progress tracking functional

---

### 6.6 Quiz/Assessment System
**Duration**: 1 day | **Priority**: 🟢 Medium

- [ ] Implement quiz submission
- [ ] Calculate and store scores
- [ ] Track attempts
- [ ] Enforce maximum attempts
- [ ] Update progress based on results

**Acceptance Criteria**: Quiz system working

---

### 6.7 Registration REST Controllers
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Create `RegistrationController`:
  - [ ] POST /api/registrations/enroll
  - [ ] GET /api/registrations/user/{userId}
  - [ ] GET /api/registrations/{id}
  - [ ] PUT /api/registrations/{id}/status
  - [ ] DELETE /api/registrations/{id} (cancel)
- [ ] Create `AttendanceController`
- [ ] Create `ProgressController`
- [ ] Add proper authorization

**Acceptance Criteria**: All endpoints working

---

### 6.8 Inter-Service Communication
**Duration**: 1 day | **Priority**: 🟡 High

- [ ] Create service clients (Course, Workflow, Certification)
- [ ] Add circuit breakers (Resilience4j)
- [ ] Add retry logic
- [ ] Implement fallback responses
- [ ] Test failure scenarios

**Acceptance Criteria**: Robust service communication

---

### 6.9 Testing & Deployment
**Duration**: 2 days | **Priority**: 🟡 High

- [ ] Write unit and integration tests
- [ ] Test concurrent enrollments (load test)
- [ ] Test all edge cases
- [ ] Create Postman collection
- [ ] Dockerize
- [ ] Deploy and test

**Acceptance Criteria**: Service deployed successfully

---

# PHASE 7: WORKFLOW SERVICE (WEEKS 10-11)

## 🔄 Approvals & Notifications

### 7.1 Workflow Service Setup
**Duration**: 0.5 day | **Priority**: 🔴 Critical

- [ ] Create Spring Boot project (add Mail, WebSocket)
- [ ] Set port: 8085
- [ ] Configure `workflow_schema`
- [ ] Configure SMTP for emails

**Acceptance Criteria**: Project ready

---

### 7.2 Workflow Entities
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create `Workflow` entity
- [ ] Create `ApprovalHistory` entity
- [ ] Create `Notification` entity
- [ ] Create repositories

**Acceptance Criteria**: Entities ready

---

### 7.3 Workflow Business Logic
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Implement workflow submission
- [ ] Implement approval process
- [ ] Implement rejection process
- [ ] Track approval history
- [ ] Get pending approvals
- [ ] Call Registration Service to update status

**Acceptance Criteria**: Workflow logic complete

---

### 7.4 Notification System
**Duration**: 2 days | **Priority**: 🟡 High

- [ ] Implement in-app notifications
- [ ] Implement email notifications
- [ ] Create email templates (Thymeleaf)
- [ ] Implement notification preferences
- [ ] Mark as read functionality
- [ ] Batch notifications

**Acceptance Criteria**: Notification system working

---

### 7.5 WebSocket for Real-Time Notifications
**Duration**: 1 day | **Priority**: 🟢 Medium

- [ ] Add WebSocket dependency
- [ ] Configure WebSocket endpoint
- [ ] Implement subscribe/unsubscribe
- [ ] Send real-time notifications
- [ ] Test with multiple clients

**Acceptance Criteria**: Real-time notifications working

---

### 7.6 Workflow REST Controllers
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create `WorkflowController`
- [ ] Create `NotificationController`
- [ ] Implement all endpoints
- [ ] Add proper authorization

**Acceptance Criteria**: Endpoints ready

---

### 7.7 Testing & Deployment
**Duration**: 2 days | **Priority**: 🟡 High

- [ ] Write tests
- [ ] Test email sending
- [ ] Test WebSocket
- [ ] Test approval flow end-to-end
- [ ] Dockerize and deploy

**Acceptance Criteria**: Workflow service live

---

# PHASE 8: CERTIFICATION SERVICE (WEEKS 12-13)

## 🏆 Certificates & Badges

### 8.1 Certification Service Setup
**Duration**: 0.5 day | **Priority**: 🔴 Critical

- [ ] Create Spring Boot project
- [ ] Add PDF library (iText or Apache PDFBox)
- [ ] Set port: 8086
- [ ] Configure `certification_schema`

**Acceptance Criteria**: Project initialized

---

### 8.2 Certification Entities
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create `Certification` entity
- [ ] Create `Badge` entity
- [ ] Create `CertificateTemplate` entity
- [ ] Create repositories

**Acceptance Criteria**: Entities ready

---

### 8.3 PDF Generation System
**Duration**: 3 days | **Priority**: 🔴 Critical

- [ ] Design certificate template (HTML/CSS)
- [ ] Implement PDF generator
- [ ] Add QR code for verification
- [ ] Add digital signature
- [ ] Store PDFs in filesystem/S3
- [ ] Optimize file size
- [ ] Test with sample data

**Acceptance Criteria**: PDF generation working

---

### 8.4 Certification Business Logic
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Implement certificate issuance
- [ ] Generate unique certificate number
- [ ] Generate verification code
- [ ] Implement verification
- [ ] Implement revocation
- [ ] Get user certificates

**Acceptance Criteria**: Certification logic complete

---

### 8.5 Badge System
**Duration**: 1 day | **Priority**: 🟢 Medium

- [ ] Implement badge awarding
- [ ] Create badge types
- [ ] Generate/store badge images
- [ ] Get user badges

**Acceptance Criteria**: Badge system working

---

### 8.6 Red Hat Integration (Mock)
**Duration**: 1 day | **Priority**: 🟢 Medium

- [ ] Create Red Hat integration service
- [ ] Implement mock API
- [ ] Add verification status
- [ ] Document real integration

**Acceptance Criteria**: Mock integration ready

---

### 8.7 Certification REST Controllers
**Duration**: 1 day | **Priority**: 🔴 Critical

- [ ] Create `CertificationController`
- [ ] Create `BadgeController`
- [ ] Implement all endpoints
- [ ] Add authorization

**Acceptance Criteria**: Endpoints working

---

### 8.8 Testing & Deployment
**Duration**: 2 days | **Priority**: 🟡 High

- [ ] Write tests
- [ ] Test PDF generation
- [ ] Test verification
- [ ] Dockerize and deploy

**Acceptance Criteria**: Certification service live

---

# PHASE 9: ANALYTICS SERVICE (WEEKS 14-15)

## 📊 Reports & Insights

### 9.1 Analytics Service Setup
**Duration**: 0.5 day | **Priority**: 🔴 Critical

- [ ] Create Spring Boot project
- [ ] Add Apache POI (Excel)
- [ ] Set port: 8087
- [ ] Configure `analytics_schema`
- [ ] Setup Redis for caching

**Acceptance Criteria**: Project ready

---

### 9.2 Analytics Entities & Event Tracking
**Duration**: 1 day | **Priority**: 🟡 High

- [ ] Create entities
- [ ] Implement event logging
- [ ] Create background aggregation job

**Acceptance Criteria**: Event tracking ready

---

### 9.3 Data Collection System
**Duration**: 2 days | **Priority**: 🟡 High

- [ ] Implement data collection from all services
- [ ] Create scheduled jobs
- [ ] Add aggregation queries
- [ ] Optimize performance

**Acceptance Criteria**: Data collection working

---

### 9.4 Dashboard Metrics
**Duration**: 2 days | **Priority**: 🔴 Critical

- [ ] Implement overview metrics
- [ ] Implement enrollment trends
- [ ] Implement popular courses
- [ ] Implement instructor performance
- [ ] Add Redis caching

**Acceptance Criteria**: Dashboard metrics ready

---

### 9.5 Course & User Analytics
**Duration**: 2 days | **Priority**: 🟡 High

- [ ] Implement course analytics
- [ ] Implement user analytics
- [ ] Add comparison features
- [ ] Generate suggestions

**Acceptance Criteria**: Analytics complete

---

###