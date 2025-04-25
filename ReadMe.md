# Mini Student Management System API Documentation

## **Overview**
This system provides a RESTful API for managing students, courses, and enrollments in a small school. The API allows you to perform CRUD operations on students and courses, as well as manage student enrollments in various courses.

## **Base URL**
All endpoints are relative to your server's base URL (e.g., http://localhost:8080)

## **Tech Stack**
- **Spring Boot**: Used for building the RESTful API.
- **H2 Database**: An in-memory database used for development and testing.
- **data.sql**: Contains pre-loaded data to initialize the database on application startup.

## **API Endpoints**

### **Student Management**

#### **Get All Students**
- **URL**: /students
- **Method**: GET
- **Description**: Retrieves a list of all students
- **Response**: 200 OK with an array of student objects
- **Example Response**:
  ```json
  [
    {
      "studentId": 1,
      "studentName": "Suleman Aslam",
      "studentEmail": "suleman.a@i.com",
      "studentGrade": "A",
      "enrollments": [...]
    },
    ...
  ]
  ```

#### **Get a Student by ID**
- **URL**: /students/{id}
- **Method**: GET
- **Description**: Retrieves details of a specific student
- **URL Parameters**: id - The ID of the student to retrieve
- **Response**: 200 OK with the student object

#### **Get a Student's Enrolled Courses**
- **URL**: /students/{id}/courses
- **Method**: GET
- **Description**: Retrieves all courses in which a student is enrolled along with grades
- **URL Parameters**: id - The ID of the student
- **Response**: 200 OK with an array of enrollment details
- **Example Response**:
  ```json
  [
    {
      "enrollmentId": 1,
      "courseId": 1,
      "courseName": "Mathematics",
      "grade": "A+"
    },
    {
      "enrollmentId": 2,
      "courseId": 2,
      "courseName": "History",
      "grade": "B"
    }
  ]
  ```

#### **Add a New Student**
- **URL**: /students
- **Method**: POST
- **Description**: Creates a new student record
- **Request Body**: Student JSON object
- **Example Request**:
  ```json
  {
    "studentName": "Suleman Aslam",
    "studentEmail": "suleman.a@i.com",
    "studentGrade": "B"
  }
  ```
- **Response**: 200 OK with success message

#### **Update a Student**
- **URL**: /students/{id}
- **Method**: PUT
- **Description**: Updates an existing student's information
- **URL Parameters**: id - The ID of the student to update
- **Request Body**: Student JSON object with updated fields
- **Example Request**:
  ```json
  {
    "studentName": "Suleman",
    "studentEmail": "suleman@example.com",
    "studentGrade": "A"
  }
  ```
- **Response**: 200 OK with success message

#### **Delete a Student**
- **URL**: /students/{id}
- **Method**: DELETE
- **Description**: Deletes a student record
- **URL Parameters**: id - The ID of the student to delete
- **Response**: 200 OK with success message

### **Course Management**

#### **Get All Courses**
- **URL**: /courses
- **Method**: GET
- **Description**: Retrieves a list of all courses
- **Response**: 200 OK with an array of course objects
- **Example Response**:
  ```json
  [
    {
      "courseId": 1,
      "courseName": "Mathematics",
      "enrollments": [...]
    },
    ...
  ]
  ```

#### **Get a Course by ID**
- **URL**: /courses/{id}
- **Method**: GET
- **Description**: Retrieves details of a specific course
- **URL Parameters**: id - The ID of the course to retrieve
- **Response**: 200 OK with the course object
- **Example Response**:
  ```json
  {
    "courseId": 2,
    "courseName": "History",
    "enrollments": [
      {
        "id": 2,
        "grade": "B+"
      }
    ]
  }
  ```

#### **Add a New Course**
- **URL**: /courses
- **Method**: POST
- **Description**: Creates a new course
- **Request Body**: Course JSON object
- **Example Request**:
  ```json
  {
    "courseName": "Physics"
  }
  ```
- **Response**: 200 OK with success message

#### **Update a Course**
- **URL**: /courses/{id}
- **Method**: PUT
- **Description**: Updates an existing course's information
- **URL Parameters**: id - The ID of the course to update
- **Request Body**: Course JSON object with updated fields
- **Example Request**:
  ```json
  {
    "courseName": "Advanced Physics"
  }
  ```
- **Response**: 200 OK with success message

#### **Delete a Course**
- **URL**: /courses/{id}
- **Method**: DELETE
- **Description**: Deletes a course
- **URL Parameters**: id - The ID of the course to delete
- **Response**: 200 OK with success message

### **Enrollment Management**

#### **Get All Enrollments**
- **URL**: /enrollments
- **Method**: GET
- **Description**: Retrieves all student-course enrollments
- **Response**: 200 OK with an array of enrollment objects
- **Example Response**:
  ```json
  [
    {
      "id": 1,
      "student": {
        "studentId": 1,
        "studentName": "Ibrahim Aslam",
        "studentEmail": "Ibrahim.a@i.com",
        "studentGrade": "A"
      },
      "course": {
        "courseId": 1,
        "courseName": "Mathematics"
      },
      "grade": "A+"
    },
    ...
  ]
  ```

#### **Enroll a Student in a Course**
- **URL**: /enrollments
- **Method**: POST
- **Description**: Enrolls a student in a course
- **Request Body**: Enrollment JSON object
- **Example Request**:
  ```json
  {
    "student": {
      "studentId": 1
    },
    "course": {
      "courseId": 2
    },
    "grade": "B+"
  }
  ```
- **Response**: 200 OK with the created enrollment object

#### **Update a Student's Grade in a Course**
- **URL**: /enrollments/student/{studentId}/course/{courseId}/grade
- **Method**: PUT
- **Description**: Updates a student's grade for a specific course
- **URL Parameters**:
  - studentId - The ID of the student
  - courseId - The ID of the course
- **Request Body**: Grade DTO
- **Example Request**:
  ```json
  {
    "grade": "A-"
  }
  ```
- **Response**: 200 OK with the updated enrollment object

## **Setup Instructions**

1. **Clone the Repository**: Clone the project repository from GitHub.
2. **Build the Project**: Use Maven to build the project.
3. **Run the Application**: Start the application with `./mvnw spring-boot:run` or through your IDE.
4. **Access the API**: The API will be accessible at `http://localhost:8080`.

## **Testing the API**

### **Setup**
1. Start the application with `./mvnw spring-boot:run` or through your IDE.
2. The API will be accessible at `http://localhost:8080`.

### **Testing Flow**
1. **Create Students**:
   - Send POST requests to `/students` to create student records
   - Note the returned student IDs for later use
2. **Create Courses**:
   - Send POST requests to `/courses` to create course records
   - Note the returned course IDs for later use
3. **Enroll Students in Courses**:
   - Send POST requests to `/enrollments` with student and course IDs
   - You can assign initial grades during enrollment
4. **View Enrollments**:
   - Send GET request to `/enrollments` to see all enrollments
   - Each enrollment will show student details, course details, and grade

### **Example Workflow**
1. **Create a student**:
   ```http
   POST /students
   {
     "studentName": "Ayesha Aslam",
     "studentEmail": "ayesha.@i.com",
     "studentGrade": "A"
   }
   ```
2. **Create two courses**:
   ```http
   POST /courses
   {
     "courseName": "Mathematics"
   }
   ```

   ```http
   POST /courses
   {
     "courseName": "History"
   }
   ```
3. **Enroll the student in both courses**:
   ```http
   POST /enrollments
   {
     "student": { "studentId": 1 },
     "course": { "courseId": 1 },
     "grade": "A+"
   }
   ```

   ```http
   POST /enrollments
   {
     "student": { "studentId": 1 },
     "course": { "courseId": 2 },
     "grade": "B"
   }
   ```
4. **View all enrollments**:
   ```http
   GET /enrollments
   ```

## **Data Relationships**
- One student can be enrolled in multiple courses
- One course can have multiple students enrolled
- Each enrollment represents a student-course pair with an associated grade
