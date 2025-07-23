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



# Reference commands
  * docker run --name mysql-docker -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=testdb -e TZ=Asia/Kolkata -p 3306:3306 -d mysql:8.0
  
  * if you remove the container sql data not stored below comamnd using Use a Docker volume to retain MySQL data across restarts and container rebuilds. \
  docker run --name mysql-docker -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=testdb -e TZ=Asia/Kolkata -v mysql_data:/var/lib/mysql -p 3306:3306 -d mysql:8.0
  
  * cmd line docker mysql login \
  	docker exec -it mysql-docker mysql -u root -p \
  	username - root \
  	password - rootpassword \
    SHOW DATABASES; \
    USE testdb;


## Build the jar first
mvn clean package (need to install maven in local machine)

## Above command error below use(This avoids the Hibernate connection error during testing.)
mvn clean package -DskipTests

## Start both services(if you have any changes in the spirngboot project you need to restart)
docker-compose up --build

## If you only want to rebuild and restart the Spring Boot app container (and not MySQL):
docker-compose up --build app

