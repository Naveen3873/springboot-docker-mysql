# 🚀 Spring Boot CRUD API with Docker and MySQL

This project is a simple **Java 17 Spring Boot REST API** application for managing users. It uses:

- **Spring Boot**
- **Spring Data JPA**
- **MySQL (Dockerized)**
- **Lombok**
- **Docker + Docker Compose**

---

## 📦 Features

✅ Create, Read, Update, Delete (CRUD) operations  
✅ Uses `Lombok` to avoid boilerplate code  
✅ Stores data in `MySQL` database via JPA  
✅ Dockerized with a single `docker-compose up`  
✅ Easy to extend and scale

---

Before running this project, make sure you have the following installed:

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- Git

---

## 🚀 Getting Started

### 🛠 Step 1: Clone and Build

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
mvn clean package -DskipTests
```

### 🐳 Step 2: Start MySQL + Spring Boot App

docker-compose up --build
* MySQL runs on: localhost:3306
* Spring Boot runs on: http://localhost:8080

| Method | Endpoint      | Description       |
| ------ | ------------- | ----------------- |
| GET    | `/users`      | Get all users     |
| GET    | `/users/{id}` | Get user by ID    |
| POST   | `/users`      | Create a new user |
| PUT    | `/users/{id}` | Update user       |
| DELETE | `/users/{id}` | Delete user       |

Example JSON:
{
  "name": "John",
  "age": 30,
  "salary": 50000,
  "role": "Developer"
}

### 🧾 Sample MySQL Configuration
Inside application.properties:

* spring.datasource.url=jdbc:mysql://localhost:3306/testdb
* spring.datasource.username=root
* spring.datasource.password=rootpassword
* spring.jpa.hibernate.ddl-auto=update
* spring.jpa.show-sql=true
* spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

### 🐳 Docker Setup
📄 Dockerfile
* FROM openjdk:17
* COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
* ENTRYPOINT ["java", "-jar", "app.jar"]


### 🙋‍♂️ Author
Naveen K
Full Stack Developer
