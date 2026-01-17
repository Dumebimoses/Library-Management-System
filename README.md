Library Management System - Backend (Spring Boot)

Overview

This project is a Spring Boot RESTful backend for a Library Management System.
It provides APIs to manage books, including creating, retrieving, searching, updating, and deleting records.
The backend uses Spring Data JPA, H2 in-memory database, and Bean Validation, and communicates using JSON over HTTP.

Technology Stack

 Java 17
 Spring Boot
 Spring Web MVC
 Spring Data JPA
 H2 Database (in-memory)
 Maven
 Hibernate Validator
 SLF4J Logging

Project Structure

src/main/java
 └── mozay.library_management_system_backend
     ├── Controller
     │    └── BookController.java
     ├── Service
     │    └── BookService.java
     ├── Repository
     │    └── BookRepository.java
     └── Entity
          └── Book.java

src/main/resources
 ├── application.properties
 

Running the Application

Prerequisites

 Java 17 installed
 Maven installed

Steps

1. Clone the repository
2. Navigate to the backend project directory
3. Run:

   mvn spring-boot:run
The application starts on:

   http://localhost:8080

API Base URL

http://localhost:8080/api/books

API Endpoints

Get All Books

GET

1. /api/books

Response (200 OK)

[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert C. Martin",
    "isbn": "9780132350884",
    "publishedDate": "2008-08-01"
  }
]

Get Book by ID

GET

2. /api/books/{id}

Response (200 OK)

{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "publishedDate": "2008-08-01"
}

Response (404 Not Found)
If the book does not exist.

Create a New Book

POST

/api/books

Request Body

{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "publishedDate": "2018-01-06"
}

Response (201 Created)

{
  "id": 2,
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "publishedDate": "2018-01-06"
}

Update a Book

PUT

/api/books/{id}

Request Body

{
  "title": "Effective Java (3rd Edition)",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "publishedDate": "2018-01-06"
}

Response (200 OK)

{
  "id": 2,
  "title": "Effective Java (3rd Edition)",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "publishedDate": "2018-01-06"
}

Delete a Book

DELETE

/api/books/{id}

Response (204 No Content)

Search Books by Title

GET

/api/books/search?title=java

Response (200 OK)

[
  {
    "id": 2,
    "title": "Effective Java",
    "author": "Joshua Bloch",
    "isbn": "9780134685991",
    "publishedDate": "2018-01-06"
  }
]

Search Books by Author (Paginated)

GET

/api/books/search/author?author=bloch&page=0&size=10

Response (200 OK)

{
  "content": [
    {
      "id": 2,
      "title": "Effective Java",
      "author": "Joshua Bloch",
      "isbn": "9780134685991",
      "publishedDate": "2018-01-06"
    }
  ],
  "totalElements": 1,
  "totalPages": 1,
  "size": 10,
  "number": 0
}

Validation Rules

The following fields are mandatory when creating or updating a book:

 title (Not Blank)
 author (Not Blank)
 isbn (Not Blank)
 publishedDate (Not Null)

If validation fails, the API returns 400 Bad Request with validation messages.

Logging

 Application events such as book creation, update, and deletion are logged using SLF4J.
 Logs are visible in the application console during runtime.

Notes

 This backend is designed to be consumed by any HTTP client such as:

   JavaFX frontend
   Postman
   Web or mobile applications
 The frontend communicates only via REST APIs and does not directly access backend code or database.

Conclusion

This backend provides a clean, validated, RESTful API for managing library books and is ready for integration with any frontend client.
