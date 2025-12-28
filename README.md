# Student Registration System 🎓

A simple web-based application to manage student records using **Java Servlets**, **JSP**, and **PostgreSQL**. This project demonstrates the CRUD operations (Create, Read) following the MVC (Model-View-Controller) architecture.

## 🚀 Features

*   **Student Registration:** A form to add new students to the database.
*   **List Students:** View a comprehensive list of all registered students.
*   **Database Integration:** specific implementation using JDBC and PostgreSQL.
*   **MVC Architecture:** Clean separation of concerns (DAO, Model, Controller, View).

## 🛠️ Tech Stack

*   **Backend:** Java (JDK 8+), Jakarta EE / Java Servlets
*   **Frontend:** JSP (JavaServer Pages), HTML, CSS
*   **Database:** PostgreSQL
*   **Build/IDE:** Eclipse (Dynamic Web Project), Maven structure
*   **Server:** Apache Tomcat 9/10

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.student
│   │       ├── dao         # Data Access Object (DB Logic)
│   │       ├── model       # POJO classes (Student entity)
│   │       ├── util        # Database Connection utility
│   │       └── web         # Servlets (Controllers)
│   │
│   └── webapp
│       ├── META-INF
│       ├── WEB-INF
│       │   ├── lib         # PostgreSQL Driver (postgresql-42.7.8.jar)
│       │   └── web.xml     # Deployment Descriptor
│       ├── list-students.jsp
│       └── register.jsp
└── resources
    └── db.properties       # Database credentials
[1]
⚙️ Setup & Installation
1. Prerequisites
Java Development Kit (JDK) installed.
Apache Tomcat Server installed.
PostgreSQL Database installed.
Eclipse IDE for Enterprise Java Developers.
2. Database Setup
Create a database in PostgreSQL and run the following SQL command to create the table:
code
SQL
CREATE DATABASE studentdb;

-- Connect to studentdb and run:
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    department VARCHAR(50)
);
3. Configuration
Update the src/main/resources/db.properties (or wherever your db.properties is located) with your database credentials:
code
Properties
db.url=jdbc:postgresql://localhost:5432/studentdb
db.username=postgres
db.password=your_password
db.driver=org.postgresql.Driver
4. Import into Eclipse
Open Eclipse.
File > Open Projects from File System...
Select the AP_LabProject folder.
Click Finish.
5. Run the Application
Right-click on the project in "Project Explorer".
Select Run As > Run on Server.
Choose your Tomcat server instance.
Navigate to: http://localhost:8080/AP_LabProject/list-students.jsp (or your configured welcome file).
📝 Usage
Register: Navigate to the registration page, fill in the student details, and click "Submit".[2]
View: After submission, you will be redirected to the student list to see the newly added record.
🤝 Contributing
Fork the repository.
Create a new branch (git checkout -b feature-branch).
Commit your changes (git commit -m 'Add new feature').
Push to the branch (git push origin feature-branch).
Open a Pull Request.