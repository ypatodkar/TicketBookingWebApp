Project Overview
Book A Show is a comprehensive movie ticket booking web application developed as part of the PG-Diploma in Advanced Computing at CDAC Pune. The application facilitates users to browse and book movie tickets seamlessly, manage theatre seats, and handle administrative tasks with role-based access control. The project was developed using Java, Spring Boot, Spring Security, ReactJS, and MySQL, adhering to best practices in software development to ensure scalability, security, and user-friendliness.

Features
User Authentication and Authorization:

Roles: Admin, Theatre Owner, and Users.
Secure Login: Implemented using Spring Security with role-based access control.
Movie Browsing and Booking:

Movie Listings: Users can browse currently available movies.
Showtimes: Detailed showtime information for each movie.
Seat Selection: Interactive seat map for selecting preferred seats.
Booking Confirmation: Users receive confirmation upon successful booking.
Theatre Management (Admin & Theatre Owner):

Theatre Administration: Manage multiple theatres, screens, and showtimes.
Seat Management: Configure seating layouts and manage seat availability.
Movie Management: Add, update, or remove movies and associated showtimes.
User Management:

Profile Management: Users can update personal information and view booking history.
Password Management: Secure password change functionality.
Responsive Design:

Ensures optimal user experience across devices (desktop, tablet, mobile).
Technologies Used
Frontend:

ReactJS: For building dynamic and responsive user interfaces.
HTML5 & CSS3: Structuring and styling the web pages.
Bootstrap: For responsive design and pre-built components.
Backend:

Java & Spring Boot: Building robust and scalable RESTful APIs.
Spring Security: Implementing secure authentication and authorization mechanisms.
MySQL: Relational database management for storing user, movie, and booking data.
Tools & Platforms:

Git & GitHub: Version control and repository management.
Postman: API testing and documentation.
Docker: Containerization for consistent development and deployment environments.
Architecture
The application follows a Monolithic Architecture, integrating both frontend and backend components within a single cohesive system. This approach simplifies development and deployment processes, especially suitable for the project's scope.

Frontend: Developed with ReactJS, the frontend communicates with the backend via RESTful APIs. It handles user interactions, form validations, and dynamic content rendering.

Backend: Spring Boot serves as the backbone, managing business logic, data processing, and communication with the MySQL database. Spring Security ensures secure access based on user roles.

Database: MySQL stores all persistent data, including user information, movie details, showtimes, and bookings. Proper indexing and normalization are employed to optimize query performance.

Setup and Installation
Prerequisites
Node.js & npm: For running the React frontend.
Java Development Kit (JDK) 11+: Required for Spring Boot.
MySQL Server: To host the application database.
Git: For version control.
Steps
Clone the Repository:

bash
Copy code
git clone https://github.com/ypatodkar/book-a-show.git
cd book-a-show
Backend Setup:

Navigate to the backend directory:
bash
Copy code
cd backend
Configure the application.properties file with your MySQL credentials:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/book_a_show
spring.datasource.username=your_username
spring.datasource.password=your_password
Build and run the Spring Boot application:
bash
Copy code
mvn clean install
mvn spring-boot:run
Database Setup:

Create the book_a_show database in MySQL:
sql
Copy code
CREATE DATABASE book_a_show;
The application will automatically create the necessary tables upon running.
Frontend Setup:

Open a new terminal window.
Navigate to the frontend directory:
bash
Copy code
cd frontend
Install dependencies and start the React application:
bash
Copy code
npm install
npm start
The application will be accessible at http://localhost:3000.
Usage
Accessing the Application:

Open your web browser and navigate to http://localhost:3000.
User Registration and Login:

New users can register by providing necessary details.
Existing users can log in using their credentials.
Browsing and Booking Movies:

After logging in, users can browse available movies and showtimes.
Select desired showtime and proceed to seat selection.
Choose seats from the interactive seat map and confirm booking.
Admin and Theatre Owner Functions:

Admins can manage all theatres, movies, and showtimes.
Theatre Owners can manage their respective theatres and associated showtimes.
Challenges and Solutions
Role-Based Access Control:

Challenge: Implementing secure and efficient role-based access to different parts of the application.
Solution: Utilized Spring Security to define roles and restrict access to specific endpoints based on user roles, ensuring that only authorized users can perform certain actions.
Interactive Seat Selection:

Challenge: Creating an intuitive and responsive seat selection interface that accurately reflects seat availability.
Solution: Developed a dynamic seat map using ReactJS and integrated real-time data fetching from the backend to display current seat statuses, enhancing user experience and preventing double bookings.
Responsive Design:

Challenge: Ensuring the application is accessible and user-friendly across various devices and screen sizes.
Solution: Implemented Bootstrap for responsive layouts and conducted thorough testing on multiple devices to ensure consistent performance and appearance.
Database Optimization:

Challenge: Managing complex queries and ensuring efficient data retrieval for large datasets.
Solution: Designed a normalized database schema with appropriate indexing, and optimized queries to improve performance and reduce latency.
Future Enhancements
Payment Integration: Incorporate secure payment gateways (e.g., Stripe, PayPal) to facilitate online ticket purchases.
User Reviews and Ratings: Allow users to rate and review movies, enhancing community engagement.
Notification System: Implement email and SMS notifications for booking confirmations and reminders.
Advanced Analytics: Provide administrators with detailed analytics and reporting tools to monitor application usage and performance.
Microservices Architecture: Transition to a microservices-based architecture for improved scalability and maintainability.
