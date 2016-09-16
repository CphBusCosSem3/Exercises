
DROP TABLE IF EXISTS STUDENT;
DROP TABLE IF EXISTS STUDYPOINT;

CREATE TABLE STUDENT (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
  FIRSTNAME  VARCHAR(40),
  LASTNAME  VARCHAR(60)
);

CREATE TABLE studypoint (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
  DESCRIPTION VARCHAR(255), 
  MAXVAL INT, 
  SCORE INT, 
  STUDENT_ID INT ,
  FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT(ID)
);


insert into STUDENT(id, firstName, lastName) values (null,"jan", "Hansen");
SET @jan = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'day-1',1,0,@);
SET @id1 = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'day-2',1,0,@jan);
SET @id2 = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'day-3',1,0,@jan);
SET @id3 = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'day-4',1,0,@jan);
SET @id4 = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'StudyPointEx-1',5,0,@jan);
SET @id5 = LAST_INSERT_ID();


insert into STUDENT(id, firstName, lastName) values (null,"Hanne", "olsen");
SET @hanne = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'day-1',1,0,@hanne);
SET @id6 = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'day-2',1,0,@hanne);
SET @id7 = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'day-3',1,0,@hanne);
SET @id8 = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'day-4',1,0,@hanne);
SET @id9 = LAST_INSERT_ID();
insert into STUDYPOINT(id,description, maxVal, score,STUDENT_ID) values(null,'StudyPointEx-1',5,0,@hanne);
SET @id10 = LAST_INSERT_ID();


update STUDYPOINT set score=1 Where STUDENT_ID = @jan AND id = @id1;
update STUDYPOINT set score=1 Where STUDENT_ID = @jan AND id = @id2;
update STUDYPOINT set score=1 Where STUDENT_ID = @jan AND id = @id3;
update STUDYPOINT set score=5 Where STUDENT_ID = @jan AND id = @id5;

update STUDYPOINT set score=1 Where STUDENT_ID = @hanne AND id = @id6;
update STUDYPOINT set score=1 Where STUDENT_ID = @hanne AND id = @id8;
update STUDYPOINT set score=4 Where STUDENT_ID = @hanne AND id = @id10;

commit;
