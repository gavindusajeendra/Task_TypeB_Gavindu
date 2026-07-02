# Hello World API

A simple Spring Boot REST API that returns a greeting message based on the first letter of the input name.

## Requirements

-Java 17
-Maven

---

## How to Run

```bash
mvn spring-boot:run

##App runs on:
http://localhost:8080

##Endpoint
GET /hello-world?name=alice

##Rules
A–M → 200 OK → { "message": "Hello Alice" }
N–Z → 400 Bad Request → { "error": "Invalid Input" }
Missing/empty → 400 Bad Request

##Run Tests
mvn test

##Assumptions
Only first letter is validated
Case-insensitive check
Name is trimmed before processing
```
