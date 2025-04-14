# Student Data Entry System with MySQL & JDBC

## Description
This Java application allows entry, retrieval, update, and deletion of student data using MySQL and JDBC.

## Features
- Add Student
- View All Students
- Search Student (by PRN, by Name)
- Update Student Details
- Delete Student

## Technologies
- Java
- JDBC
- MySQL

## Files
- `Student.java` - Model class
- `DatabaseConnection.java` - JDBC utility
- `StudentDAO.java` - SQL operations
- `StudentService.java` - Business logic
- `Main.java` - User menu

## Setup
1. Create MySQL DB: `studentdb`
2. Use this SQL:

```sql
CREATE TABLE students (
    prn VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    dob VARCHAR(20),
    marks DOUBLE
);
```

## Author Info
- Name: Your Name
- PRN: Your PRN
- Batch: Your Batch

