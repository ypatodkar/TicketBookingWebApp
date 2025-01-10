# Book A Show – Movie Ticket Booking Web Application

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Architecture](#architecture)
5. [Setup and Installation](#setup-and-installation)
6. [Usage](#usage)
7. [Challenges and Solutions](#challenges-and-solutions)
8. [Future Enhancements](#future-enhancements)
9. [Screenshots](#screenshots)
10. [Conclusion](#conclusion)

---

## Project Overview

**Book A Show** is a comprehensive movie ticket booking web application developed as part of the PG-Diploma in Advanced Computing at CDAC Pune. The application facilitates users to browse and book movie tickets seamlessly, manage theatre seats, and handle administrative tasks with role-based access control. The project was developed using Java, Spring Boot, Spring Security, ReactJS, and MySQL, adhering to best practices in software development to ensure scalability, security, and user-friendliness.

---

## Features

- **User Authentication and Authorization:**
  - **Roles:** Admin, Theatre Owner, and Users.
  - **Secure Login:** Implemented using Spring Security with role-based access control.
  
- **Movie Browsing and Booking:**
  - **Movie Listings:** Users can browse currently available movies.
  - **Showtimes:** Detailed showtime information for each movie.
  - **Seat Selection:** Interactive seat map for selecting preferred seats.
  - **Booking Confirmation:** Users receive confirmation upon successful booking.
  
- **Theatre Management (Admin & Theatre Owner):**
  - **Theatre Administration:** Manage multiple theatres, screens, and showtimes.
  - **Seat Management:** Configure seating layouts and manage seat availability.
  - **Movie Management:** Add, update, or remove movies and associated showtimes.
  
- **User Management:**
  - **Profile Management:** Users can update personal information and view booking history.
  - **Password Management:** Secure password change functionality.
  
- **Responsive Design:**
  - Ensures optimal user experience across devices (desktop, tablet, mobile).

---

## Technologies Used

- **Frontend:**
  - **ReactJS:** For building dynamic and responsive user interfaces.
  - **HTML5 & CSS3:** Structuring and styling the web pages.
  - **Bootstrap:** For responsive design and pre-built components.

- **Backend:**
  - **Java & Spring Boot:** Building robust and scalable RESTful APIs.
  - **Spring Security:** Implementing secure authentication and authorization mechanisms.
  - **MySQL:** Relational database management for storing user, movie, and booking data.

- **Tools & Platforms:**
  - **Git & GitHub:** Version control and repository management.
  - **Postman:** API testing and documentation.
  - **Docker:** Containerization for consistent development and deployment environments.

---

## Architecture

The application follows a **Monolithic Architecture**, integrating both frontend and backend components within a single cohesive system. This approach simplifies development and deployment processes, especially suitable for the project's scope.

- **Frontend:** Developed with ReactJS, the frontend communicates with the backend via RESTful APIs. It handles user interactions, form validations, and dynamic content rendering.
  
- **Backend:** Spring Boot serves as the backbone, managing business logic, data processing, and communication with the MySQL database. Spring Security ensures secure access based on user roles.
  
- **Database:** MySQL stores all persistent data, including user information, movie details, showtimes, and bookings. Proper indexing and normalization are employed to optimize query performance.

---

## Setup and Installation

### Prerequisites

- **Node.js & npm:** For running the React frontend.
- **Java Development Kit (JDK) 11+:** Required for Spring Boot.
- **MySQL Server:** To host the application database.
- **Git:** For version control.

### Steps

1. Clone the Repository:

bash
git clone https://github.com/ypatodkar/TicketBookingWebApp
cd book-a-show

2. Backend Setup
Navigate to the Backend Directory:

bash

cd backend
Configure the application.properties File:

Open the application.properties file located in the src/main/resources directory.

Update the following properties with your MySQL credentials:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/book_a_show
spring.datasource.username=your_username
spring.datasource.password=your_password
Ensure the Database Exists:

Make sure that the MySQL server is running.

Create the book_a_show database if it doesn't already exist:

sql

CREATE DATABASE book_a_show;
Build and Run the Spring Boot Application:

Ensure Maven is Installed:

If Maven is not installed, download and install it from the Maven Official Website.

Build the Application:

bash

mvn clean install
Run the Application:

bash

mvn spring-boot:run
Verify the Application is Running:

Once the application starts, it should be accessible at http://localhost:8080. You can verify by opening the URL in your web browser or by using a tool like Postman to test the API endpoints.

Troubleshooting:

Common Issues:

Port Already in Use: If port 8080 is occupied, you can change the server port by adding the following line to application.properties:

properties

server.port=9090
Database Connection Errors: Ensure that MySQL is running and that the credentials in application.properties are correct. Verify that the user has the necessary permissions to access the book_a_show database.

Logs:

Monitor the console logs for any errors during the build or run process. Logs provide valuable information for diagnosing issues.

Database Migration (Optional):

If you have predefined data or need to run migrations, ensure that your migration scripts are placed in the src/main/resources/db/migration directory (if using Flyway) or configured appropriately for your migration tool.

Environment Variables (Optional):

For enhanced security, consider using environment variables to store sensitive information like database credentials instead of hardcoding them in the application.properties file.

bash

export SPRING_DATASOURCE_USERNAME=your_username
export SPRING_DATASOURCE_PASSWORD=your_password
Then, modify application.properties to reference these variables:

properties

spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
3. Database Setup
Create the book_a_show Database in MySQL:

sql

CREATE DATABASE book_a_show;
Run Database Migrations:

If your project uses migration tools like Flyway or Liquibase, ensure that all migration scripts are executed to set up the necessary tables and seed data.

4. Frontend Setup
Open a New Terminal Window.

Navigate to the Frontend Directory:

bash

cd frontend
Install Dependencies and Start the React Application:

bash

npm install
npm start
Access the Application:

Once the frontend is running, open your web browser and navigate to http://localhost:3000 to access the application.

Future Enhancements
Payment Integration: Incorporate secure payment gateways (e.g., Stripe, PayPal) to facilitate online ticket purchases.
User Reviews and Ratings: Allow users to rate and review movies, enhancing community engagement.
Notification System: Implement email and SMS notifications for booking confirmations and reminders.
Advanced Analytics: Provide administrators with detailed analytics and reporting tools to monitor application usage and performance.
Microservices Architecture: Transition to a microservices-based architecture for improved scalability and maintainability.





Contact
Yash Patodkar
Email: ypatodkar@scu.edu
LinkedIn: linkedin.com/in/yash-patodkar
GitHub: github.com/ypatodkar

