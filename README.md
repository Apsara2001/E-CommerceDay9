# E-CommerceDay9
# 💼 Employee Management System (Spring Boot)

A RESTful Spring Boot application tailored for managing organizational departments (with planned employee integration). The system emphasizes modular design, layered architecture, and clean API endpoint exposure.

---

## 📖 Overview

This application provides endpoints for managing department data within an organization. While employee entities are referenced, their functionality remains unimplemented. The goal is to demonstrate CRUD operations and architecture in a Spring Boot RESTful service.

---

## 🏗️ Application Architecture

The project follows a 4-layered architecture:

### ➤ Model Layer

- **Department.java**
  - Fields:
    - `id` (Long): Primary Key
    - `name` (String): Department name
    - `establishedDate` (Date): Date of creation
    - `employees` (List): One-to-many relationship with `Employee` (future feature)

- **Employee.java**
  - Planned entity (not implemented in the provided code)

---

### ➤ Repository Layer

- **DepartmentRepo**
  - Interface extending `JpaRepository<Department, Long>`
  - Handles all standard CRUD operations via Spring Data JPA

---

### ➤ Service Layer

- **DepartmentService**
  - Provides business logic for:
    - Retrieving all departments
    - Fetching a department by ID
  - Keeps controller layer clean and testable

---

### ➤ Controller Layer

- **DepartmentController**
  - REST API entry point for department operations:
    - `GET /dept`: List all departments
    - `GET /dept/{id}`: Get a department by ID
  - Contains commented-out stubs for:
    - POST (Create)
    - PUT (Update)
    - DELETE (Delete)

---

## 🗃️ Database Configuration

Set up MySQL and ensure the following configuration is defined in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```
## ▶️ How to Run the Application

Follow these steps to get the application up and running:

1. **Install** Java 11 or higher and MySQL

2. **Create a MySQL database** named `employee`

3. **Clone the repository** and open it in your preferred IDE

4. **Configure the database connection** inside `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/employee
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   ```

5. **Build the project** using Maven:

   ```bash
   mvn clean install
   ```

6. **Run the application** using:

   ```bash
   mvn spring-boot:run
   ```

7. Access the endpoints (e.g., [http://localhost:8080/dept](http://localhost:8080/dept)) in your browser or use Postman.

## 📡 REST Endpoints

### ✅ Active Endpoints:

| Method | URL         | Description             | Response                        |
|--------|-------------|-------------------------|---------------------------------|
| GET    | `/dept`     | Retrieve all departments | List of Department objects      |
| GET    | `/dept/{id}`| Retrieve department by ID| Single Department or 404 error  |

![WhatsApp Image 2025-05-18 at 2 02 52 PM](https://github.com/user-attachments/assets/5a25dcfe-8757-4cda-99bf-ba7b02bc6297)
![WhatsApp Image 2025-05-18 at 2 03 00 PM](https://github.com/user-attachments/assets/9318e7ee-d23b-4eb1-b183-fcf9d629d6a7)
![WhatsApp Image 2025-05-18 at 2 03 07 PM](https://github.com/user-attachments/assets/f8b66fd1-caf9-4f99-8261-69fb3eb42496)
### 📝 Commented Department Endpoints

The following endpoints are present in the codebase but are currently commented out. These can be activated in the future as needed:

| Method | URL     | Description                         | Response                                | Notes                                                  |
|--------|---------|-------------------------------------|-----------------------------------------|--------------------------------------------------------|
| GET    | `/dept` | Fetch the complete list of departments | JSON array of Department objects         | Saves departments using the repository (to be enabled) |

![WhatsApp Image 2025-05-18 at 2 03 29 PM](https://github.com/user-attachments/assets/1d8cc3d0-8289-4475-95a4-245dced05cbf):

| Method | URL          | Description                      | Path Parameter | Response                     | Notes                                                             |
|--------|--------------|----------------------------------|----------------|------------------------------|-------------------------------------------------------------------|
| GET    | `/dept/{id}` | Retrieve a department by its ID | `id` (Long)    | Department object or 404     | Uses repository to fetch and save; currently commented out        |

![WhatsApp Image 2025-05-18 at 2 03 39 PM](https://github.com/user-attachments/assets/bd35391c-b88d-419c-a81e-370a654c51c2)
| Method | URL      | Description           | Request Body           | Response                  | Notes                                   |
|--------|----------|-----------------------|-----------------------|---------------------------|-----------------------------------------|
| POST   | `/dept`  | Create a new department | Department JSON object | Confirmation message "New Department added" | Saves new department via repository (commented out) |

![WhatsApp Image 2025-05-18 at 2 03 15 PM](https://github.com/user-attachments/assets/714afd7a-411d-46a2-85d1-407aaed9c4cc)
| Method | URL          | Description                    | Path Parameter | Request Body           | Response                                            | Notes                                               |
|--------|--------------|--------------------------------|----------------|-----------------------|-----------------------------------------------------|-----------------------------------------------------|
| PUT    | `/dept/{id}` | Update an existing department   | `id` (Department ID) | Updated Department JSON | Success: "The Department Updated" <br> Error: "Couldn't find the department" | Checks existence before updating and saving department |

![WhatsApp Image 2025-05-18 at 2 03 22 PM](https://github.com/user-attachments/assets/45eadf34-fd3e-4654-bdf1-961657047433)

| Method | URL          | Description                 | Path Parameter | Response                                              | Notes                                        |
|--------|--------------|-----------------------------|----------------|-------------------------------------------------------|----------------------------------------------|
| DELETE | `/dept/{id}` | Delete a department by ID    | `id` (Department ID) | Success: "The Department Deleted" <br> Error: "Couldn't find the department" | Verifies existence before deletion          |

![WhatsApp Image 2025-05-18 at 2 03 46 PM](https://github.com/user-attachments/assets/f020458e-b590-4dee-8c6e-9aad7dcde0ae)

## Entity Relationships

- A single **Department** can have multiple **Employees**, establishing a **one-to-many** relationship.
- This association is represented via the `department` field in the **Employee** entity.

---

## Additional Notes

- The **DepartmentController** supports two implementation methods:
  1. **Service Layer Approach** (active): Uses `DepartmentService` to handle all business logic.
  2. **Direct Repository Approach** (commented out): Performs CRUD operations directly on the repository.
- The direct repository methods cover all CRUD operations — retrieving, creating, updating, and deleting departments.
- To switch to the repository approach, uncomment the relevant code in the controller and disable the service-based logic.
- Before deploying, it's recommended to implement thorough error handling and validate input data.
- Future enhancements will include completing the **Employee** entity and adding endpoints to manage employees.

---

## Project Dependencies

- **Spring Boot**
- **Spring Data JPA**
- **MySQL Connector**
- **Jakarta Persistence API**














