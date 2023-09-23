create table student(
	id INT PRIMARY KEY AUTO_INCREMENT,
  fullName VARCHAR(100) NOT NULL,
  doB DATE NOT NULL ,
  sex tinyint NOT NULL, 
  phoneNumber VARCHAR(10) NOT NULL unique,
  universityName VARCHAR(100) NOT NULL,
  gradeLevel VARCHAR(20) NOT NULL,
  type tinyint not null ,
  gpa DECIMAL(3, 1) check ( 0 < gpa <= 10 ),
  bestRewardName VARCHAR(100),
  englishScore int check (10 <englishScore < 990),
  entryTestScore DECIMAL(3, 1) check (0 < entryTestScore <= 10)
); 
