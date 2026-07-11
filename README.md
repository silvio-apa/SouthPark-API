# SouthPark API

This project is a Spring Boot REST API for managing South Park characters and quotes.

Users can create, read, update and delete characters. They can also create, read, update and delete quotes that belong to a character.

## Features

* Show all characters
* Show one character by ID
* Create a character
* Update a character
* Delete a character
* Show all quotes
* Show one quote by ID
* Show all quotes of one character
* Create a quote for a character
* Update a quote
* Delete a quote
* Validation for input data
* Structured error responses
* Automated tests

## Technologies

* Java 21
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* PostgreSQL
* Docker Compose
* Maven
* Bean Validation
* JUnit
* Mockito

## Installation

### 1. Requirements

* Java 21
* Maven
* Docker Desktop
* Git
* IntelliJ IDEA
* Insomnia or Postman for testing the API

### 2. Clone the project

```bash
git clone https://github.com/silvio-apa/SouthPark-API.git
cd SouthPark-API
```

### 3. Start PostgreSQL

Start the PostgreSQL database with Docker Compose:

```bash
docker compose up -d
```

The database connection is:

```text
Host: localhost
Port: 5432
Database: southpark
Username: southpark
Password: southpark
```

### 4. Start the application

Start the application in IntelliJ with:

```text
SouthparkApiApplication.java
```

Or start it with Maven:

```bash
mvn spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

The REST endpoints are available under:

```text
http://localhost:8080/api/characters
http://localhost:8080/api/quotes
```

Important: The PostgreSQL Docker container must be running before starting the Spring Boot application.

## Database

The project uses PostgreSQL with Docker Compose.

After the first start, the database is empty. New characters and quotes can be created with the API endpoints.

## API endpoints

### Characters

```text
GET     /api/characters
GET     /api/characters/{id}
POST    /api/characters
PUT     /api/characters/{id}
DELETE  /api/characters/{id}
```

### Quotes

```text
GET     /api/quotes
GET     /api/quotes/{id}
GET     /api/characters/{characterId}/quotes
POST    /api/characters/{characterId}/quotes
PUT     /api/quotes/{id}
DELETE  /api/quotes/{id}
```

## Example requests

### Create a character

```http
POST /api/characters
```

```json
{
  "name": "Eric Cartman",
  "age": 10,
  "gender": "Male",
  "occupation": "Student",
  "status": "Alive",
  "imageUrl": "https://example.com/cartman.png"
}
```

### Create a quote for a character

```http
POST /api/characters/{characterId}/quotes
```

```json
{
  "text": "Respect my authority!",
  "season": 2,
  "episode": 4
}
```

## Error handling

Invalid input data returns a structured validation error.

Example:

```json
{
  "status": 400,
  "message": "Validation failed",
  "errors": [
    "Name must not be empty",
    "Age must be at least 0"
  ]
}
```

If a character or quote is not found, the API returns a structured not found error.

Example:

```json
{
  "status": 404,
  "message": "Character with id 999 was not found",
  "errors": []
}
```

## Tests

Run all automated tests with:

```bash
mvn test
```

Run a full build with tests:

```bash
mvn clean install
```

The project contains automated tests for:

* Repository logic
* Service logic
* Error handling in the service
* Quote creation
* Controller validation
* Spring Boot application context

## Function test after installation

After starting PostgreSQL and the Spring Boot application, the API can be tested with Insomnia or Postman.

Recommended checks:

* Create a character with `POST /api/characters`
* Show all characters with `GET /api/characters`
* Update a character with `PUT /api/characters/{id}`
* Create a quote with `POST /api/characters/{characterId}/quotes`
* Show quotes of a character with `GET /api/characters/{characterId}/quotes`
* Delete a character without quotes with `DELETE /api/characters/{id}`
* Send invalid character data and check the validation error
* Request a non-existing character ID and check the not found error

## Project structure

```text
src/main/java/ch/wiss/southparkapi
├── controller
├── dto
├── exception
├── mapper
├── model
├── repository
├── service
└── SouthparkApiApplication.java

src/test/java/ch/wiss/southparkapi
├── controller
├── repository
├── service
└── SouthparkApiApplicationTests.java
```