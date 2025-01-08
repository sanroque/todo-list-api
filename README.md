
# ToDo List API 🚀

A robust and modular RESTful API designed to manage tasks efficiently. The ToDo List API supports CRUD operations, providing an excellent backend foundation for task management or productivity applications.

---

## Features 🌟

- **Task Management**:
  - Create new tasks with a title and description.
  - Retrieve a single task by its unique ID or list all tasks.
  - Update the details of an existing task.
  - Delete tasks by ID.
- **Error Handling**:
  - Handles non-existent task IDs with clear error messages.
  - Validates input data to ensure data integrity.
- **Extendable**:
  - Built with scalability and adaptability in mind.
  - Easy to add new features or integrate with front-end applications.

---

## Tech Stack 🛠️

- **Backend**: Java with Spring Boot.
- **Database**: Relational databases via Spring Data JPA.
- **Mapping**: MapStruct for converting between entities and DTOs.
- **Utilities**: Lombok to reduce boilerplate code.

---

## Project Structure 📂

The project is organized as follows:

```
todo-list-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── tech/sanroque/todo_list_api/
│   │   │       ├── controllers/       # REST controllers for API endpoints
│   │   │       ├── services/          # Business logic for task operations
│   │   │       ├── repositories/      # Interfaces for database interactions
│   │   │       ├── models/            # Data models (DTOs and Entities)
│   │   │       ├── mappers/           # MapStruct mappers for DTO<->Entity conversion
│   │   │       └── TodoListApiApplication.java  # Main application entry point
│   ├── resources/
│       ├── application.properties     # Application configuration
│
├── pom.xml                            # Maven dependencies and project setup
├── README.md                          # Project documentation
```

---

## API Endpoints 📝

| HTTP Method | Endpoint          | Description                        |
|-------------|-------------------|------------------------------------|
| `POST`      | `/api/tasks`      | Create a new task                  |
| `GET`       | `/api/tasks`      | Retrieve all tasks                 |
| `GET`       | `/api/tasks/{id}` | Retrieve a task by its ID          |
| `PUT`       | `/api/tasks/{id}` | Update an existing task by its ID  |
| `DELETE`    | `/api/tasks/{id}` | Delete a task by its ID            |

---

## Getting Started 🏁

### Prerequisites

- **Java**: Ensure Java 17 or later is installed.
- **Maven**: Install Maven for project build and dependency management.
- **Database**: Set up a relational database (e.g., MySQL, PostgreSQL).

### Installation Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/todo-list-api.git
   cd todo-list-api
   ```

2. **Configure the Database**:
   Update the `application.properties` file in `src/main/resources/`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/todo_list
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build and Run the Application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the API**:
   Open your browser or Postman and navigate to:  
   `http://localhost:8080/api/tasks`

---

## Example Requests 💡

### Create a Task
```http
POST /api/tasks
Content-Type: application/json

{
  "title": "Complete project",
  "description": "Finish the ToDo List API development."
}
```

### Retrieve All Tasks
```http
GET /api/tasks
```

### Retrieve a Task by ID
```http
GET /api/tasks/1
```

### Update a Task
```http
PUT /api/tasks/1
Content-Type: application/json

{
  "title": "Complete project (updated)",
  "description": "Add documentation to the ToDo List API."
}
```

### Delete a Task
```http
DELETE /api/tasks/1
```

---

## Testing 🧪

### Unit Tests
- Write tests to validate the functionality of controllers, services, and repositories.
- Use **JUnit** and **Mockito** for test implementation.

### Example:
To run all tests:
```bash
mvn test
```

---

## Next Steps 🚧

1. **Authentication**: Implement user authentication and role-based authorization with Spring Security.
2. **Pagination**: Add pagination support for listing tasks.
3. **Dockerization**: Create a Dockerfile to containerize the application.
4. **Frontend Integration**: Build or integrate a front-end application (e.g., React, Angular).
5. **CI/CD**: Set up Continuous Integration and Deployment pipelines.

---

## Contributing 🤝

Contributions are welcome! Follow these steps to contribute:
1. Fork the repository.
2. Create a new branch (`feature/your-feature`).
3. Commit your changes and push to the branch.
4. Open a Pull Request.

---

## License 📜

This project is licensed under the [MIT License](LICENSE). Feel free to use and modify it as needed.

---

### Connect with Me 🌐

- **GitHub**: [Your Profile](https://github.com/yourusername)  
- **LinkedIn**: [Your Profile](https://www.linkedin.com/in/yourusername/)  

Happy coding! 🚀
