# 🏢 Training Management Platform
### Cloud-Native Microservices System (Architecture-First Design)

This project demonstrates a **production-grade, enterprise-style microservices platform** designed for training management.  
It was built using a **distributed microservices architecture**, secure authentication, event-driven messaging, and modern DevOps practices.  

> ⚠️ Note: Core architecture and infrastructure are fully designed and implemented. Business services are under progressive development. The focus is on **system design, security, scalability, and deployment readiness**.

---

## 🚀 High-Level Vision

The platform is designed to:

- Manage courses, users, enrollments, sessions, and notifications  
- Support multiple roles with **Keycloak authentication** (OAuth2, JWT, RBAC)  
- Enable asynchronous event-driven communication via **Kafka and RabbitMQ**  
- Scale independently per service  
- Integrate fully with **CI/CD pipelines** for production-ready deployment  
- Demonstrate **senior-level cloud-native and DevOps engineering practices**

---

## 🏗 System Architecture & Layers

### Layered Architecture
<img width="2186" height="1107" alt="image" src="https://github.com/user-attachments/assets/8909bb8c-3c91-49ab-981a-0d73734d2a0a" />



> **Rationale:**  
> - **API Gateway** centralizes authentication, logging, and routing.  
> - **Keycloak** provides secure, scalable identity management.  
> - **Independent microservices + DBs** allow horizontal scaling and failure isolation.  
> - **Kafka + RabbitMQ hybrid** provides robust event-driven architecture: Kafka for domain events, RabbitMQ for reliable notifications.  
> - **Docker + Kubernetes** ensures environment parity, reproducibility, and cloud readiness.

---

## 🔐 Security & Authentication

- **Keycloak** for centralized OAuth2 / OpenID Connect  
- JWT-based token validation at API Gateway  
- RBAC enforcing least privilege access  
- Secure communication between services (internal traffic only)  
- Secrets managed via environment variables / planned Vault integration

---

## 🧩 Microservices Design Principles

- Independently deployable  
- Stateless services  
- Database per service  
- Async event-driven communication  
- Resilient to failures  
- Horizontal scaling enabled  

> **Design decisions explained:**  
> - **Spring Boot**: mature ecosystem, microservices-ready, integrates with Kafka/RabbitMQ  
> - **Next.js frontend**: performant, responsive, SEO-ready, easy integration with API Gateway  
> - **Hybrid async messaging**: separates critical notifications from domain events for better reliability

---

## 🎨 Frontend

- Responsive landing page (Next.js)  
- Smooth animations (CSS / Framer Motion)  
- Validates UI/UX standards  
- Mobile-first design  
- Landing page can serve as portfolio showcase  

**Embed screenshots / demo GIF:**

```markdown
### Desktop View
![Desktop](docs/images/landing-desktop.png)

### Demo Animation
![Demo](docs/images/demo.gif)
