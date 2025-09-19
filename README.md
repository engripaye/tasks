# 📝 Todo App (Spring Boot + PostgreSQL + JWT + Liquibase)

A **backend Todo application** built with **Java 21** and **Spring Boot 3.5**, featuring user authentication, secure REST APIs, and database version control with **Liquibase**.
This project demonstrates core backend development skills such as **API design, authentication/authorization, database schema migrations, CI/CD readiness, and deployment**.

---

## 🚀 Features

* 🔐 **User Authentication & Authorization** with JWT (register & login)
* 🗂️ **CRUD APIs** for managing Todos (per authenticated user)
* 🛠️ **Spring Boot 3.5** (REST Controllers, Services, Repositories)
* 🗄️ **PostgreSQL Database** with schema migrations via **Liquibase**
* ⏱️ **Cron Jobs Ready** (extendable for scheduled tasks)
* 🔄 **GitLab CI/CD Ready** for automated build & deploy
* ☁️ Deployable on **Render / Railway / Heroku**

---

## 📂 Tech Stack

* **Backend:** Java 21, Spring Boot 3.5
* **Database:** PostgreSQL
* **Migrations:** Liquibase (SQL format)
* **Security:** Spring Security + JWT
* **Build Tool:** Maven
* **Version Control:** Git + GitLab/GitHub
* **Deployment:** Render / Railway

---

## ⚙️ Project Structure

```
src/main/java/com/example/todo/
├── TodoApp.java               # Main entry point
├── config/SecurityConfig.java # Spring Security setup
├── controller/                # REST API controllers
├── dto/                       # Data transfer objects
├── exception/                 # Custom exception handling
├── model/                     # Entities (User, Todo)
├── repository/                # Spring Data JPA Repos
├── security/                  # JWT util & filters
└── service/                   # Business logic
```

---

## 🛠️ Setup Instructions

### 1. Clone Repository

```bash
git clone https://github.com/your-username/todo-app.git
cd todo-app
```

### 2. Configure Database

Create a PostgreSQL database and update `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/tododb
    username: postgres
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true
  liquibase:
    change-log: classpath:db/changelog/db.changelog-master.xml
```

### 3. Run Locally

```bash
./mvnw spring-boot:run
```

or

```bash
mvn clean package
java -jar target/todo-app-0.0.1-SNAPSHOT.jar
```

### 4. Test APIs with Postman

* **POST** `/api/auth/register` → Register new user
* **POST** `/api/auth/login` → Get JWT token
* **POST** `/api/todos` → Create todo (JWT required)
* **GET** `/api/todos` → List user’s todos
* **PUT** `/api/todos/{id}` → Update todo
* **DELETE** `/api/todos/{id}` → Delete todo

---

## 📦 Deployment (Render Example)

1. Push code to GitHub.
2. Create a **PostgreSQL instance** on Render.
3. Add environment variables in Render dashboard:

   * `SPRING_DATASOURCE_URL`
   * `SPRING_DATASOURCE_USERNAME`
   * `SPRING_DATASOURCE_PASSWORD`
   * `JWT_SECRET`
4. Deploy the service → Test with your deployed URL.

---

## 🧪 Example API Requests (cURL)

```bash
# Register User
curl -X POST http://localhost:8080/api/auth/register \
-H "Content-Type: application/json" \
-d '{"username":"john","password":"123456"}'

# Login User
curl -X POST http://localhost:8080/api/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"john","password":"123456"}'

# Create Todo
curl -X POST http://localhost:8080/api/todos \
-H "Authorization: Bearer <JWT_TOKEN>" \
-H "Content-Type: application/json" \
-d '{"title":"Finish Spring Boot Project"}'
```

---

## 📌 Roadmap

* [ ] Add scheduled **cron jobs** (e.g., daily todo reminders)
* [ ] Add **frontend UI** (React or Angular)
* [ ] Deploy with **Docker & Kubernetes** for scalability

---

## 👨‍💻 Author

**Babatunde Olabowale**
Full Stack Backend Developer | Java | Spring Boot | PostgreSQL | DevOps

---

⚡ *This project highlights backend engineering skills for building secure, scalable, and production-ready APIs.*

---
