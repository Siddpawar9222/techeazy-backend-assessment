# Student Management System

A Spring Boot application for managing students and their subjects.

## Prerequisites

Ensure you system have met the following requirements:

- Java Development Kit (JDK) 21
- Maven 3.6.3 or higher (Optional)

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Siddpawar9222/techeazy-backend-assessment.git
   ```

2. **Reach to parent directory:**

   ```bash
     cd student-management-system
   ```

3. **Open Project in your favourite IDE(I use Intellij)**

## Running the Application

1. **Run the Spring Boot application:**
   You can run the application using Maven or from your IDE.

   **Build the project:**

   ```bash
   mvn clean install
   ```

   **Using Maven:**

   ```bash
   mvn spring-boot:run
   ```

   **Using the executable WAR:**

   ```bash
   java -jar target/student-management-system.war
   ```

2. **Access the application:**
   Open your web browser and go to `http://localhost:8080/test/welcome`. This this open url to test application.

## Postman Collection

To make it easier to interact with the API, we have provided a Postman collection that includes all the necessary requests.

**Download the Postman Collection**:

- [Download Student Management System Postman Collection](./docs/student-management-system.postman_collection.json)

## Sequence to Execute API

To properly interact with the API, follow this sequence:

1. **Auth API**:

   - Execute the `register` endpoint to create a new user.
   - Execute the `login` endpoint to authenticate the user and obtain a token.

2. **Subject API**:

   - Execute the `createSubjects` endpoint to create new subjects.

3. **Student API**:
   - Execute the `createStudent` endpoint to create a new student.
   - Execute the `assignSubjectsToStudentById/{id}` endpoint to assign subjects to a student.
   - Execute the `getAllStudents` endpoint to retrieve all students.
   - Execute the `getStudentById/{id}` endpoint to retrieve a specific student by ID.

### Project Status

---

The project is working fine and has been made as per your requirements. All APIs are functioning correctly.

I am submitting this README file along with the project for review. Please raise any further issues or suggestions for modifications.

## Project Understanding

I encountered some doubts related to understanding and implementing the project:

1. **Spring MVC**:

   - The project does not use Spring MVC for view rendering, so page redirection is not possible.
   - Instead, I created REST APIs and tested them using Postman.

2. **Roles**:
   - Currently, I have assigned all authorities to both the `student` and `admin` roles.
   - This approach may need to be refined in the future to implement role-specific permissions.

---
