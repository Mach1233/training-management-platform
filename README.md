# 🏢 Training Management Platform (Microservices Architecture)

An enterprise-grade Training Management Platform built using a distributed microservices architecture.

This project demonstrates modern cloud-native system design using Spring Boot microservices, API Gateway, Keycloak authentication, asynchronous messaging, and a Next.js frontend.

⚠️ The platform is currently under active development. Core architectural components are implemented, and business services are being progressively integrated.

---

## 🏗 Architecture Overview

The system follows a distributed microservices pattern with:

- API Gateway (Spring Boot)
- Keycloak (OAuth2 / OpenID Connect)
- Independent Spring Boot Microservices
- Asynchronous communication (Kafka & RabbitMQ)
- Next.js Frontend
- CI/CD pipeline design
- Containerized deployment strategy

---

## 🔐 Authentication & Security

Authentication is handled via Keycloak:

- OAuth2 Authorization Server
- JWT token validation
- Role-Based Access Control (RBAC)
- Centralized identity management

All requests pass through the API Gateway, which validates tokens before routing to downstream services.

---

## 🧩 Microservices Design (Planned & Partially Implemented)

Planned services include:

- User Service
- Course Service
- Enrollment Service
- Notification Service
- Training Session Service

Each service:
- Independent database
- Independent deployment
- REST API exposure
- Async event publishing/subscribing

---

## 🔄 Asynchronous Messaging Architecture

To ensure loose coupling and scalability:

Kafka:
- Event streaming
- User registration events
- Enrollment events

RabbitMQ:
- Notification dispatch
- Email/SMS queue handling

This hybrid approach allows:
- Event-driven communication
- Resilience
- Horizontal scaling
- Failure isolation

---

## 🌐 API Gateway

Implemented using Spring Boot.

Responsibilities:
- Central routing
- Token validation
- Load balancing
- Cross-cutting concerns handling

---

## 🎨 Frontend

Built with Next.js.

- Modern responsive landing page
- Authentication-ready structure
- API integration ready
- Optimized performance

The landing page validates the UI/UX design direction of the platform.

---

## 🚀 DevOps & CI/CD Design

Planned pipeline:

- Service-level Dockerization
- GitHub Actions pipeline
- Multi-stage Docker builds
- Container registry push
- Kubernetes deployment
- Environment-based configuration

Future Deployment Target:
- Kubernetes cluster
- Containerized microservices
- Externalized configuration
- Secure secrets management

---

## 📐 Scalability Strategy

- Stateless services
- Independent scaling
- Async messaging for decoupling
- Gateway-level routing
- Token-based security
- Cloud-ready containerization

---

## 🧠 Engineering Focus

This project demonstrates:

- Distributed systems architecture
- API Gateway pattern
- Centralized authentication with Keycloak
- Event-driven design principles
- Cloud-native system planning
- CI/CD architectural thinking

---

## 📌 Current Status

✔ API Gateway implemented  
✔ Keycloak integration configured  
✔ Landing page completed  
✔ Microservices architecture designed  
⚠ Business services under development  
⚠ Full deployment pipeline pending  

---

## 🔮 Future Roadmap

- Complete User Service
- Complete Course Service
- Implement Kafka event producers/consumers
- Implement RabbitMQ notification service
- Full Docker Compose local environment
- Kubernetes deployment
- Observability stack (Prometheus + Grafana)
- Centralized logging (ELK)

---

## 👨‍💻 Author

Architected and developed as a cloud-native distributed system project.

Focus: Microservices | Security | Event-Driven Systems | DevOps Integration
