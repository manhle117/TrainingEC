CREATE TABLE Department (
    departmentId INT AUTO_INCREMENT PRIMARY KEY,
    departmentName VARCHAR(100)
);

CREATE TABLE Student (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    studentCode VARCHAR(50),
    fullName VARCHAR(100),
    dateOfBirth DATE,
    yearOfAdmission INT,
    entranceScore DECIMAL(3,1),
    departmentId INT,
	trainingLocation VARCHAR(100),
    FOREIGN KEY (departmentId) REFERENCES Department(departmentId)
);
 
CREATE TABLE Enrollment (
    enrollmentId INT AUTO_INCREMENT PRIMARY KEY,
    studentId INT,
    semesterName VARCHAR(50),
    averageScore DECIMAL(3,1),
    FOREIGN KEY (studentId) REFERENCES Student(Id)
);