CREATE DATABASE IF NOT EXISTS `db_quanlidiem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_quanlidiem`;

CREATE TABLE Department (Account
    departmentId INT AUTO_INCREMENT,
    departmentName VARCHAR(255),
    PRIMARY KEY (departmentId)
);

CREATE TABLE Class (
    classId INT AUTO_INCREMENT,
    className VARCHAR(255),
    departmentId INT,
    PRIMARY KEY (classId),
    FOREIGN KEY (departmentId) REFERENCES Department(departmentId)
);

CREATE TABLE Student (
    studentId VARCHAR(10) PRIMARY KEY,
    fullName VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    address VARCHAR(50),
    departmentId INT,
    classId INT,
    FOREIGN KEY (departmentId) REFERENCES Department(departmentId),
    FOREIGN KEY (classId) REFERENCES Class(classId)
);

CREATE TABLE Subject (
    subjectId VARCHAR(10) PRIMARY KEY,
    subjectName VARCHAR(50) NOT NULL,
    credit INT NOT NULL,
    academicYear VARCHAR(10),
    teacher VARCHAR(50),
    departmentId INT,
    FOREIGN KEY (departmentId) REFERENCES Department(departmentId)
);

CREATE TABLE Grade (
    studentId VARCHAR(10),
    subjectId VARCHAR(10),
    processScore FLOAT,
    examScore FLOAT,
    finalScore FLOAT,
    PRIMARY KEY (studentId, subjectId),
    FOREIGN KEY (studentId) REFERENCES Student(studentId),
    FOREIGN KEY (subjectId) REFERENCES Subject(subjectId)
);

CREATE TABLE StudyResult (
    studentId VARCHAR(10) PRIMARY KEY,
    gpa FLOAT,
    classification VARCHAR(20),
    accumulated_credits INT,
    failed_credits INT,
    FOREIGN KEY (studentId) REFERENCES Student(studentId)
);

CREATE TABLE Account (
    username VARCHAR(15) PRIMARY KEY,
    password VARCHAR(64) NOT NULL,
    role VARCHAR(10) NOT NULL DEFAULT 'Member'
);

DROP TRIGGER IF EXISTS trg_update_study_result;
DROP TRIGGER IF EXISTS trg_update_study_result_after_update;


RENAME TABLE Department TO department;
RENAME TABLE Student TO student;
RENAME TABLE Class TO class;
RENAME TABLE Subject TO subject;
RENAME TABLE Grade TO grade;
RENAME TABLE StudyResult TO studyresult;
RENAME TABLE Account TO account;


INSERT INTO department (departmentId, departmentName)
VALUES
(1, 'An toàn thông tin'),
(2, 'Công nghệ thông tin'),
(3, 'Điện tử viễn thông');

INSERT INTO class (classId, className, departmentId)
VALUES
(1, 'AT19A', 1),
(2, 'AT19B', 1),
(3, 'AT19C', 1),
(4, 'AT19D', 1),
(5, 'CT7A', 2),
(6, 'CT7B', 2),
(7, 'CT7C', 2),
(8, 'DT6A', 3),
(9, 'DT6B', 3)




INSERT INTO subject (subjectId, subjectName, credit, academicYear, teacher, departmentId) VALUES
('Chung001', 'Đường lối cách mạng của Đảng CSVN', 3, '2023-2024', 'Nguyễn Văn An', NULL),
('Chung002', 'Giáo dục thể chất 4', 1, '2023-2024', 'Trần Thị Bình', NULL),
('Chung003', 'Tiếng Anh 3', 4, '2023-2024', 'Lê Hoàng Cường', NULL),
('Chung004', 'Toán cao cấp A3', 3, '2023-2024', 'Phạm Ngọc Diệp', NULL),

('CNTT101', 'Cấu trúc dữ liệu và giải thuật', 2, '2023-2024', 'Vũ Đức Duy', 2),
('CNTT102', 'Chương trình dịch', 2, '2023-2024', 'Hoàng Minh Đức', 2),
('CNTT103', 'Công nghệ mạng máy tính', 3, '2023-2024', 'Đặng Thu Hà', 2),
('CNTT104', 'Công nghệ phần mềm nhúng', 2, '2023-2024', 'Ngô Xuân Hùng', 2),
('CNTT105', 'Lý thuyết cơ sở dữ liệu', 2, '2023-2024', 'Cao Văn Oanh', 2),
('CNTT106', 'Phát triển ứng dụng web', 2, '2023-2024', 'Đinh Công Phú', 2),
('CNTT107', 'Quản trị mạng máy tính', 2, '2023-2024', 'Hồ Sỹ Quý', 2),
('CNTT108', 'Thiết kế hệ thống nhúng', 3, '2023-2024', 'Lê Thị Thu', 2),
('CNTT109', 'Hệ quản trị cơ sở dữ liệu', 2, '2023-2024', 'Võ Thị Xuân', 2),
('CNTT110', 'Lập trình căn bản', 3, '2023-2024', 'Lê Văn Việt', 2),
('CNTT111', 'Lập trình hướng đối tượng', 2, '2023-2024', 'Phạm Thị Thu Hà', 2),
('CNTT112', 'Nguyên lý hệ điều hành', 2, '2023-2024', 'Hoàng Thanh Mai', 2),
('CNTT113', 'An toàn và bảo mật trong phát triển PM di động', 3, '2023-2024', 'Trần Tuấn Anh', 2),
('CNTT114', 'Phân tích, thiết kế hệ thống', 2, '2023-2024', 'Lê Hoàng Long', 2),
('CNTT115', 'An toàn và bảo mật trong hệ thống nhúng', 3, '2023-2024', 'Phạm Minh Đức', 2),


('ĐTVT101', 'Hệ thống thông tin di động', 2, '2023-2024', 'Đỗ Tiến Khải', 3),
('ĐTVT102', 'Hệ thống viễn thông', 3, '2023-2024', 'Lưu Thanh Liêm', 3),
('ĐTVT103', 'Kỹ thuật truyền số liệu', 2, '2023-2024', 'Phùng Văn Mạnh', 3),
('ĐTVT104', 'Xử lý tín hiệu số', 2, '2023-2024', 'Bùi Thị Nga', 3),
('ĐTVT105', 'Điện tử tương tự và điện tử số', 3, '2023-2024', 'Phan Văn Uyên', 3),
('ĐTVT106', 'Kỹ thuật vi xử lý', 2, '2023-2024', 'Trần Mạnh Hùng', 3),

('ATTT101', 'Tổng quan về An toàn Thông tin', 3, '2023-2024', 'Ngô Tấn Anh', 1),
('ATTT102', 'Mật mã học', 3, '2023-2024', 'Đỗ Văn Khải', 1),
('ATTT103', 'An ninh mạng', 3, '2023-2024', 'Trần Nguyên Vũ', 1),
('ATTT104', 'Kiểm thử xâm nhập', 3, '2023-2024', 'Lê Công Thành', 1),
('ATTT105', 'Pháp luật về An toàn Thông tin', 2, '2023-2024', 'Phạm Anh Tuấn', 1);


-- Sửa đổi bảng grade
ALTER TABLE grade
DROP COLUMN processScore, -- Xóa cột processScore (nếu tồn tại)
DROP COLUMN examScore,    -- Xóa cột examScore (nếu tồn tại)
ADD COLUMN componentScore FLOAT DEFAULT NULL AFTER subjectId,
ADD COLUMN midtermScore FLOAT DEFAULT NULL AFTER componentScore,
MODIFY COLUMN finalScore FLOAT DEFAULT NULL AFTER midtermScore,
ADD COLUMN finalGrade FLOAT AS (((componentScore * 0.3) + (midtermScore * 0.7)) * 0.3 + (finalScore * 0.7)) STORED AFTER finalScore,
ADD COLUMN letterGrade VARCHAR(2) DEFAULT NULL AFTER finalGrade;

-- Tạo trigger (nếu trigger chưa tồn tại)
DELIMITER //

CREATE TRIGGER IF NOT EXISTS update_letter_grade
BEFORE INSERT ON grade
FOR EACH ROW
BEGIN
    SET NEW.letterGrade =
        CASE
            WHEN NEW.finalGrade >= 9.0 THEN 'A+'
            WHEN NEW.finalGrade >= 8.5 THEN 'A'
            WHEN NEW.finalGrade >= 8.0 THEN 'B+'
            WHEN NEW.finalGrade >= 7.0 THEN 'B'
            WHEN NEW.finalGrade >= 6.5 THEN 'C+'
            WHEN NEW.finalGrade >= 5.5 THEN 'C'
            WHEN NEW.finalGrade >= 5.0 THEN 'D+'
            WHEN NEW.finalGrade >= 4.0 THEN 'D'
            ELSE 'F'
        END;
END //

DELIMITER ;

-- Tạo trigger UPDATE (nếu trigger chưa tồn tại)
DELIMITER //

CREATE TRIGGER IF NOT EXISTS update_letter_grade_on_update
BEFORE UPDATE ON grade
FOR EACH ROW
BEGIN
    SET NEW.finalGrade = (((NEW.componentScore * 0.3) + (NEW.midtermScore * 0.7)) * 0.3 + (NEW.finalScore * 0.7));
    SET NEW.letterGrade =
        CASE
            WHEN NEW.finalGrade >= 9.0 THEN 'A+'
            WHEN NEW.finalGrade >= 8.5 THEN 'A'
            WHEN NEW.finalGrade >= 8.0 THEN 'B+'
            WHEN NEW.finalGrade >= 7.0 THEN 'B'
            WHEN NEW.finalGrade >= 6.5 THEN 'C+'
            WHEN NEW.finalGrade >= 5.5 THEN 'C'
            WHEN NEW.finalGrade >= 5.0 THEN 'D+'
            WHEN NEW.finalGrade >= 4.0 THEN 'D'
            ELSE 'F'
        END;
END //

DELIMITER ;


DELIMITER //

CREATE TRIGGER trg_update_study_result
AFTER INSERT ON grade
FOR EACH ROW
BEGIN
    DECLARE current_gpa FLOAT DEFAULT 0;
    DECLARE current_classification VARCHAR(20);
    DECLARE current_accumulated_credits INT DEFAULT 0;
    DECLARE current_failed_credits INT DEFAULT 0;
    DECLARE total_grade_points FLOAT DEFAULT 0;
    DECLARE total_credits INT DEFAULT 0;

    SELECT SUM(finalGrade * credit), SUM(credit)
    INTO total_grade_points, total_credits
    FROM grade g
    JOIN subject s ON g.subjectId = s.subjectId
    WHERE g.studentId = NEW.studentId AND g.finalGrade >= 4;

    SELECT SUM(credit)
    INTO current_failed_credits
    FROM grade g
    JOIN subject s ON g.subjectId = s.subjectId
    WHERE g.studentId = NEW.studentId AND g.finalGrade < 4;

    IF total_credits > 0 THEN
        SET current_gpa = total_grade_points / total_credits;
    ELSE
        SET current_gpa = 0;
    END IF;

    SET current_classification =
        CASE
            WHEN current_gpa >= 8.5 THEN 'Xuất sắc'
            WHEN current_gpa >= 8.0 THEN 'Giỏi'
            WHEN current_gpa >= 7.0 THEN 'Khá'
            WHEN current_gpa >= 5.0 THEN 'Trung bình'
            ELSE 'Yếu'
        END;

    IF current_gpa IS NULL THEN
        INSERT INTO studyresult (studentId, gpa, classification, accumulated_credits, failed_credits)
        VALUES (NEW.studentId, current_gpa, current_classification, total_credits, current_failed_credits);
    ELSE
        UPDATE studyresult
        SET gpa = current_gpa,
            classification = current_classification,
            accumulated_credits = total_credits,
            failed_credits = current_failed_credits
        WHERE studentId = NEW.studentId;
    END IF;
END //

DELIMITER //

CREATE TRIGGER trg_update_study_result_after_update
AFTER UPDATE ON grade
FOR EACH ROW
BEGIN
    DECLARE current_gpa FLOAT DEFAULT 0; -- Đã thêm dấu chấm phẩy
    DECLARE current_classification VARCHAR(20);
    DECLARE current_accumulated_credits INT DEFAULT 0;
    DECLARE current_failed_credits INT DEFAULT 0;
    DECLARE total_grade_points FLOAT DEFAULT 0;
    DECLARE total_credits INT DEFAULT 0;

    SELECT SUM(finalGrade * credit), SUM(credit)
    INTO total_grade_points, total_credits
    FROM grade g
    JOIN subject s ON g.subjectId = s.subjectId
    WHERE g.studentId = NEW.studentId AND g.finalGrade >= 4;

    SELECT SUM(credit)
    INTO current_failed_credits
    FROM grade g
    JOIN subject s ON g.subjectId = s.subjectId
    WHERE g.studentId = NEW.studentId AND g.finalGrade < 4;

    IF total_credits > 0 THEN
        SET current_gpa = total_grade_points / total_credits;
    ELSE
        SET current_gpa = 0;
    END IF;

    SET current_classification =
        CASE
            WHEN current_gpa >= 8.5 THEN 'Xuất sắc'
            WHEN current_gpa >= 8.0 THEN 'Giỏi'
            WHEN current_gpa >= 7.0 THEN 'Khá'
            WHEN current_gpa >= 5.0 THEN 'Trung bình'
            ELSE 'Yếu'
        END;

    UPDATE studyresult
    SET gpa = current_gpa,
        classification = current_classification,
        accumulated_credits = total_credits,
        failed_credits = current_failed_credits
    WHERE studentId = NEW.studentId;
END //

DELIMITER ;

