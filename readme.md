# Student Management System

A Spring Boot application for managing students and their subjects.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project is a Student Management System built with Spring Boot. It provides RESTful APIs for managing students and their subjects.

## Features

- Create and read students
- Assign subjects to students
- JWT-based authentication 

## Prerequisites

Ensure you system have met the following requirements:

- Java Development Kit (JDK) 21 
- Maven 3.6.3 or higher

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Siddpawar9222/techeazy-backend-assessment
   ```

2. **Reach to parent directory:**
   ```bash
     cd xxxxxxxxxxxxxxxxxxx
   ```

3. **Build the project:**
   ```bash
     mvn clean install
   ```



## Running the Application

1. **Run the Spring Boot application:**
   You can run the application using Maven or from your IDE.

   **Using Maven:**
   ```bash
   mvn spring-boot:run
   ```

   **Using the executable WAR:**
   ```bash
   java -jar target/student-management-system.war
   ```

2. **Access the application:**
   Open your web browser and go to `http://localhost:8080/test/welcome`.