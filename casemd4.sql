create database casemd4;

use casemd4;

CREATE TABLE Users (
                       user_id INT PRIMARY KEY AUTO_INCREMENT,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       phone_number VARCHAR(50) NOT NULL,
                       full_name VARCHAR(255) NOT NULL,
                       date_of_birth DATE NOT NULL,
                       address VARCHAR(255) NOT NULL,
                       identity VARCHAR(255) NOT NULL,
                       role ENUM('Admin', 'Giảng viên', 'Học viên', 'Giáo vụ') NOT NULL
);

CREATE TABLE Classes (
                         class_id INT PRIMARY KEY AUTO_INCREMENT,
                         class_name VARCHAR(255) NOT NULL,
                         teacher_id INT,
                         FOREIGN KEY (teacher_id) REFERENCES Users(user_id)
);

CREATE TABLE Students (
                          student_id INT PRIMARY KEY AUTO_INCREMENT,
                          user_id INT,
                          class_id INT,
                          status ENUM('Thôi học', 'Đình chỉ', 'Chờ chuyển lớp', 'Đang học') NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES Users(user_id),
                          FOREIGN KEY (class_id) REFERENCES Classes(class_id)
);

CREATE TABLE FeeStatus (
                           fee_status_id INT PRIMARY KEY AUTO_INCREMENT,
                           student_id INT,
                           due_date DATE NOT NULL,
                           status ENUM('Nợ học phí', 'Đã đóng') NOT NULL,
                           FOREIGN KEY (student_id) REFERENCES Students(student_id)
);

CREATE TABLE Grades (
                        grade_id INT PRIMARY KEY AUTO_INCREMENT,
                        student_id INT,
                        subject VARCHAR(255) NOT NULL,
                        theoretical DECIMAL(5,2) NOT NULL,
                        practical DECIMAL(5,2) NOT NULL,
                        average DECIMAL(5,2) GENERATED ALWAYS AS ((theoretical + practical) / 2) STORED,
                        FOREIGN KEY (student_id) REFERENCES Students(student_id)
);

CREATE TABLE DailyLogs (
                           log_id INT PRIMARY KEY AUTO_INCREMENT,
                           teacher_id INT,
                           class_id INT,
                           student_id INT,
                           log_date DATE NOT NULL,
                           content TEXT NOT NULL,
                           FOREIGN KEY (teacher_id) REFERENCES Users(user_id),
                           FOREIGN KEY (class_id) REFERENCES Classes(class_id),
                           FOREIGN KEY (student_id) REFERENCES Students(student_id)
);

CREATE TABLE Subjects (
                          subject_id INT PRIMARY KEY AUTO_INCREMENT,
                          subject_name VARCHAR(255) NOT NULL
);

CREATE TABLE EmailQueue (
                            email_id INT PRIMARY KEY AUTO_INCREMENT,
                            user_id INT,
                            subject VARCHAR(255) NOT NULL,
                            body TEXT NOT NULL,
                            send_date DATE NOT NULL,
                            status ENUM('Pending', 'Sent') NOT NULL,
                            FOREIGN KEY (user_id) REFERENCES Users(user_id)
);




INSERT INTO Users (email, password, phone_number, full_name, date_of_birth, address, identity, role)
VALUES ('admin@gmail.com', '123', '0123456789', 'Nguyen Admin', '2001-01-01', 'Address', 'Identity', 'Giảng viên');


CREATE TRIGGER after_user_insert
    AFTER INSERT ON Users
    FOR EACH ROW
BEGIN
    DECLARE email_subject VARCHAR(255);
   DECLARE email_body TEXT;

   SET email_subject = 'Thông tin tài khoản của bạn';
   SET email_body = CONCAT('Tài khoản: ', NEW.email, '\nMật khẩu: ', NEW.password);

    INSERT INTO EmailQueue (user_id, subject, body, send_date, status)
    VALUES (NEW.user_id, email_subject, email_body, CURDATE(), 'Pending');
END;


SELECT * FROM Users
WHERE email = 'user@gmail.com' AND password = '123';



SELECT * FROM Classes
WHERE teacher_id = 1;



SELECT Students.student_id, Users.full_name, Users.email, Users.phone_number, Students.status
FROM Students
         JOIN Users ON Students.user_id = Users.user_id
WHERE Students.class_id = 1;


SELECT Students.student_id, Users.full_name, Users.email, Users.phone_number, Students.status
FROM Students
         JOIN Users ON Students.user_id = Users.user_id
WHERE Students.class_id = 1 AND Students.status = 'Đang học';




SELECT Students.student_id, Users.full_name, Users.email, Users.date_of_birth, Users.address, Users.phone_number, Students.status
FROM Students
         JOIN Users ON Students.user_id = Users.user_id
WHERE Students.student_id = 1;


INSERT INTO DailyLogs (teacher_id, class_id, log_date, content)
VALUES (1, 1, CURDATE(), 'Nội dung nhật ký');


INSERT INTO DailyLogs (teacher_id, class_id, student_id, log_date, content)
VALUES (1, 1, 1, CURDATE(), 'Nội dung nhật ký');



CREATE TRIGGER before_fee_due_date
    BEFORE INSERT ON FeeStatus
    FOR EACH ROW
BEGIN
    IF NEW.due_date = CURDATE() + INTERVAL 3 DAY THEN
      DECLARE email_subject VARCHAR(255);
      DECLARE email_body TEXT;

      SET email_subject = 'Thông báo đóng học phí';
      SET email_body = 'Hạn nộp học phí của bạn sắp đến. Vui lòng nộp học phí trước hạn.';

    INSERT INTO EmailQueue (user_id, subject, body, send_date, status)
    VALUES ((SELECT user_id FROM Students WHERE student_id = NEW.student_id), email_subject, email_body, CURDATE(), 'Pending');
END IF;
END;



SELECT * FROM FeeStatus
WHERE student_id = 1;


SELECT * FROM Grades
WHERE student_id = 1;


UPDATE Grades
SET theoretical = 8.5, practical = 7.0
WHERE student_id = 1 AND subject = 'Math';


UPDATE Students
SET status = 'Chờ chuyển lớp'
WHERE student_id = 1;


SELECT Users.user_id, Users.full_name, COUNT(Students.student_id) AS total_students
FROM Users
         JOIN Classes ON Users.user_id = Classes.teacher_id
         JOIN Students ON Classes.class_id = Students.class_id
GROUP BY Users.user_id, Users.full_name;


SELECT Classes.class_id, Classes.class_name, AVG(Grades.average) AS average_grade
FROM Classes
         JOIN Students ON Classes.class_id = Students.class_id
         JOIN Grades ON Students.student_id = Grades.student_id
GROUP BY Classes.class_id, Classes.class_name;


CREATE TABLE MonthlyTeacherData (
                                    record_id INT PRIMARY KEY AUTO_INCREMENT,
                                    teacher_id INT,
                                    record_month DATE,
                                    total_classes INT,
                                    total_students INT,
                                    FOREIGN KEY (teacher_id) REFERENCES Users(user_id)
);


CREATE TRIGGER monthly_teacher_data
    AFTER INSERT ON Classes
    FOR EACH ROW
BEGIN
    INSERT INTO MonthlyTeacherData (teacher_id, record_month, total_classes, total_students)
    SELECT teacher_id, CURDATE(), COUNT(DISTINCT class_id), COUNT(DISTINCT student_id)
    FROM Classes
             JOIN Students ON Classes.class_id = Students.class_id
    WHERE teacher_id = NEW.teacher_id
    GROUP BY teacher_id, MONTH(CURDATE());
END;



INSERT INTO Subjects (subject_name)
VALUES ('New Subject');