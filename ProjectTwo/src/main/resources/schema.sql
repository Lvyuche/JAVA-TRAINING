CREATE TABLE student (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255)
);

CREATE TABLE teacher (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255)
);

CREATE TABLE student_teacher (
                                 student_id BIGINT,
                                 teacher_id BIGINT,
                                 PRIMARY KEY (student_id, teacher_id),
                                 FOREIGN KEY (student_id) REFERENCES student(id),
                                 FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);
