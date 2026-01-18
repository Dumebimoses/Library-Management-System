Library Management System – Backend
Overview
This project is a Spring Boot RESTful backend for a Library Management System. It provides APIs to manage books, including creating, retrieving, searching, updating, and deleting records. The backend uses Spring Data JPA, H2 in-memory database, and Bean Validation, and communicates using JSON over HTTP.

Technology Stack
1. Java 17
2. Spring Boot 3.x
3. Spring Web MVC
4. Spring Data JPA
5. Hibernate Validator
6. H2 Database (in-memory)
7. Maven
8. SLF4J Logging



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
++Prerequisites
1. Java 17 installed
2. Maven installed

Steps


1. Clone the repository


Navigate to the backend project directory


Run the application:


mvn spring-boot:run



The application starts on:


http://localhost:8080


Database Configuration


Database: H2 (in-memory)


Console URL:


http://localhost:8080/h2-console



JDBC URL:


jdbc:h2:mem:testdb



Username: sa


Password: (leave blank)



API Base URL
http://localhost:8080/api/books


API Endpoints
1. Get All Books
GET /api/books
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


2. Get Book by ID
GET /api/books/{id}
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

3. Create a New Book
POST /api/books
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


4. Update a Book
PUT /api/books/{id}
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


5. Delete a Book
DELETE /api/books/{id}
Response (204 No Content)

6. Search Books by Title
GET /api/books/search?title=java
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


7. Search Books by Author (Paginated)
GET /api/books/search/author?author=bloch&page=0&size=10
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
The following fields are required when creating or updating a book:


title (Not Blank)


author (Not Blank)


isbn (Not Blank)


publishedDate (Not Null)


Validation failures return 400 Bad Request with descriptive error messages.

Logging


Application events such as book creation, update, and deletion are logged using SLF4J.


Logs appear in the console during runtime.



Notes


This backend is designed to be consumed by any HTTP client such as:


JavaFX frontend


Postman


Web or mobile applications

The frontend communicates only via REST APIs and does not directly access backend code or the database.
