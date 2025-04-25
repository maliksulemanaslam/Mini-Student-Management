-- Insert students
INSERT INTO students (student_name, student_email, student_grade) VALUES ('suleman', 'suleman.a@i.com', 'A');
INSERT INTO students (student_name, student_email, student_grade) VALUES ('ibrahim', 'ibrahim.a@i.com', 'B+');
INSERT INTO students (student_name, student_email, student_grade) VALUES ('Ansa', 'ansa.a@e.com', 'A-');

-- Insert courses
INSERT INTO courses (course_name) VALUES ('Mathematics');
INSERT INTO courses (course_name) VALUES ('History');
INSERT INTO courses (course_name) VALUES ('Computer Science');

-- Insert enrollments
INSERT INTO enrollments (student_id, course_id, grade) VALUES (1, 1, 'A+');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (1, 2, 'B+');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (2, 1, 'A-');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (2, 3, 'A');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (3, 2, 'B');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (3, 3, 'A+');