# DoReMi – Music Catalog Web Application

## Description

**DoReMi** is a web application built with **Java and Spring Boot** that manages a small music catalog.
The application allows users to browse **bands**, view their **albums**, and read **music-related articles**.

The project follows a **layered MVC architecture**, separating **controllers, services, repositories, and domain models** to keep the code organized and maintainable.

The database is automatically populated with sample data when the application starts, making it easy to test and explore the features.

---

### Layer Responsibilities

**Controllers**

* Handle HTTP requests
* Communicate with services

**Services**

* Contain business logic
* Coordinate operations between controllers and repositories

**Repositories**

* Manage database access
* JPA is used for bands and albums
* JDBC is used for articles

**Models**

* Represent the main domain entities

---

## Features

* Browse a list of **music bands**
* View **albums of each band**
* Display and manage **articles**
* Automatic loading of **sample data**

---

## Running the Project

### Run the application

Run the `DoremiApplication` class.

### Open the application

```
http://localhost:8080
```

---
