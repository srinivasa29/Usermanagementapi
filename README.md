# 🧑‍💼 User Management API

A Spring Boot-based REST API for managing users with CRUD functionality. Built using JPA, Hibernate, Lombok, and an RDBMS (like MySQL/PostgreSQL).

---

## 🚀 Features

- Create, Read, Update, Delete Users
- Validation using Jakarta Bean Validation
- JPA & Hibernate for ORM
- Lombok for boilerplate-free model classes
- Timestamps for created/updated fields
- Unit & Integration tests using JUnit and Spring Test

---

## 🧱 Tech Stack

- **Backend**: Java, Spring Boot
- **Database**: MySQL / PostgreSQL (configurable)
- **ORM**: Spring Data JPA + Hibernate
- **Validation**: Jakarta Validation
- **Testing**: JUnit 5, Spring Boot Test
- **Boilerplate Reduction**: Lombok

---

## 🗂 Project Structure

```plaintext
UserManagementAPI/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/UserManagementAPI/
│   │   │       ├── Controller/
│   │   │       │   └── UserController.java
│   │   │       ├── Model/
│   │   │       │   └── User.java
│   │   │       ├── Repository/
│   │   │       │   └── UserRepository.java
│   │   │       └── Service/
│   │   │           └── UserService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql (optional)
│   └── test/
│       └── java/com/example/UserManagementAPI/
│           ├── UserControllerTest.java
│           └── UserRepositoryTest.java
├── .gitignore
├── pom.xml
└── README.md
