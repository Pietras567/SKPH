
---

# Humanitarian Aid Coordination System

A web application designed to support the coordination of relief efforts during crises such as natural disasters and environmental catastrophes. This system serves as an innovative solution to streamline humanitarian aid by integrating several modern technologies.

## Table of Contents

* [Overview](#overview)
* [Features](#features)
* [Technology Stack](#technology-stack)
* [Project Requirements](#project-requirements)
* [Architecture](#architecture)
* [Installation](#installation)
* [Usage](#usage)
* [Testing & Quality Assurance](#testing--quality-assurance)

## Overview

The **Humanitarian Aid Coordination System** is built to assist organizations and teams in managing and coordinating relief during crisis situations. With a focus on reliability, security, and scalability, the application integrates a variety of technologies to create a robust platform that meets the demands of dynamic emergency response scenarios.

### Key Goals

* **Enhance Coordination:** Facilitate effective communication and collaboration among humanitarian agencies, volunteers, and emergency responders.
* **Streamlined Operations:** Simplify management processes such as resource allocation, event tracking, and automated notifications.
* **Scalable & Secure:** Support high loads during emergencies with security best practices and efficient resource management.

## Features

* **Crisis Event Management:** Add, update, and monitor crisis events with dynamic dashboards and detailed statistics.
* **Role-based User Management:**

  * **Administrators** can manage user roles, oversee operations, and view comprehensive system logs.
  * **Coordinators and Responders** receive tailored views and functionalities based on their responsibilities.
* **Real-time Notifications:**

  * Push notifications and dynamic alerts keep teams informed.
  * Integration with an email microservice to deliver emergency email alerts promptly.
* **Interactive User Interface:**

  * Responsive design built with React and TailwindCss.
  * Features such as interactive maps and dashboards for location-based event visualization.
* **Secure Communication:**

  * RESTful services secured with industry-standard protocols.
  * JWT-based authentication ensures safe access to the backend API.
* **Logging & Monitoring:** Detailed logs for security auditing and system performance monitoring.

## Technology Stack

* **Java & Spring:** Provides a robust and secure backend framework alongside a RESTful web server.
* **Gradle:** Manages the build lifecycle and dependencies efficiently.
* **React:** Powers the dynamic and responsive user interface.
* **PostgreSQL:** Ensures efficient, scalable, and reliable data storage.
* **Hibernate:** Simplifies database interactions with an ORM framework.
* **TailwindCss:** Allows rapid UI development with utility-first CSS.
* **Go & gRPC:** Drives the dedicated email microservice, ensuring fast and reliable inter-service communication.

## Project Requirements

### Functional Requirements

* **User Authentication & Role Management:**

  * Support for user registration and secure login.
  * Implementation of role-based access control (e.g., Administrator, Coordinator, Responder).
* **Crisis Event Handling:**

  * Ability to create, edit, and delete crisis events.
  * Dynamic dashboards for event monitoring.
* **Notification System:**

  * Automated email notifications using the Go microservice.
  * Real-time in-app alerts for critical updates.
* **Data Visualization:**

  * Interactive maps highlighting crisis zones and resource locations.
  * Graphical representations of resource allocation and activity logs.

### Non-functional Requirements

* **Performance:**

  * Designed to handle a high volume of concurrent users during emergencies.
  * Optimized for quick data retrieval and real-time notifications.
* **Security:**

  * Secure communication channels using HTTPS and JWT for API access.
  * Regular security audits and adherence to best practices.
* **Scalability:**

  * Modular microservice architecture enables horizontal scaling.
  * Database design supports growth in data volume and concurrent operations.
* **Maintainability & Testability:**

  * Comprehensive unit and integration tests are included.
  * Use of Gradle to automate build and test processes.
* **Documentation:**

  * In-line documentation, code comments, and user manuals to support deployment and future enhancements.

## Architecture

The system employs a multi-tiered, microservices architecture to ensure modularity, scalability, and maintainability:

* **Backend Service:**

  * Built using Java and Spring.
  * Managed with Gradle for build automation and dependency management.
* **Email Microservice:**

  * Developed in Go and communicates using gRPC.
  * Dedicated to sending real-time email notifications.
* **Frontend Service:**

  * Developed with React, styled using TailwindCss.
  * Provides an interactive user interface with dashboards and maps.
* **Database:**

  * PostgreSQL is used for persistent data storage, with Hibernate as the ORM layer.

## Installation

Follow these steps to set up the project locally:

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/Pietras567/SKPH.git
   cd SKPH
   ```

2. **Backend Setup:**

   * Ensure you have JDK 21+ installed.
   * Navigate to the backend directory:

     ```bash
     cd Backend
     ```
   * Build the project using Gradle:

     ```bash
     ./gradlew build
     ```
   * Run the Spring Boot server:

     ```bash
     ./gradlew bootRun
     ```

3. **Email Microservice Setup:**

   * Ensure you have Go installed.
   * Navigate to the email microservice directory:

     ```bash
     cd Backend/emailsystem
     ```
   * Build and run the microservice:

     ```bash
     go build
     ./emailsystem
     ```

4. **Frontend Setup:**

   * Ensure you have Node.js and npm/yarn installed.
   * Navigate to the frontend directory:

     ```bash
     cd Frontend
     ```
   * Install dependencies:

     ```bash
     npm install
     yarn install
     ```
   * Start the React application:

     ```bash
     npm start
     yarn run
     ```

5. **Database Configuration:**

* **Option A — Local/Postgres installation**

  * Install PostgreSQL and create a new database.
  * Update the backend configuration file with your database credentials.

* **Option B — Docker**

  * Using provided docker compose file start PostgreSQL in Docker (example in files).

## Usage

* **Accessing the Application:**
  Once all services are running, open your browser and navigate to the frontend URL (commonly [http://localhost:3000](http://localhost:3000)).

* **Managing Crisis Events:**
  Use the dashboard to add, update, and monitor crisis events, manage resources, and communicate with affected teams.

* **Notifications:**
  The integrated email microservice ensures timely delivery of emergency notifications and updates.

## Testing & Quality Assurance

To ensure the system’s stability and reliability, comprehensive testing has been incorporated:

* **Unit Tests:**

  * Backend project include extensive unit tests.
  * Use Gradle to run backend tests:

    ```bash
    ./gradlew test
    ```

---
