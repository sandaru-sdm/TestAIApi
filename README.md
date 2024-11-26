# TestAIApi - Spring Boot User Authentication API

A secure REST API built with Spring Boot that provides user authentication and management functionality using JWT (JSON Web Tokens).

## Features

- User registration and login
- JWT-based authentication
- Password encryption using BCrypt
- User profile management
- Global exception handling
- Input validation
- MySQL database integration

## Technologies

- Java 17
- Spring Boot 3.0.4
- Spring Security
- Spring Data JPA
- MySQL
- JWT (JSON Web Tokens)
- Maven
- Lombok
- Jakarta Validation

## Prerequisites

- JDK 17 or later
- Maven 3.6+
- MySQL 8.0+

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/sandaru-sdm/TestAIApi.git
cd TestAIApi
```

### 2. Configure MySQL
Create a MySQL database and update the application.yml file with your database configuration:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/user_auth_db?createDatabaseIfNotExist=true
    username: your_username
    password: your_password
```

### 3. Configure JWT Secret
Update the JWT secret key in application.yml:
```yaml
application:
  security:
    jwt:
      secret-key: your_secret_key
      expiration: 86400000  # 24 hours in milliseconds
```

### 4. Build the project
```bash
mvn clean install
```

### 5. Run the application
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080/api`

## Project Structure

```
src/main/java/com/sdm/auth/
├── config/                 # Configuration classes
│   ├── ApplicationConfig
│   ├── SecurityConfig
│   └── JwtAuthenticationFilter
├── controller/            # REST controllers
│   ├── AuthController
│   └── UserController
├── dto/                   # Data Transfer Objects
├── entity/               # Entity classes
├── exception/            # Exception handling
├── repository/           # Data repositories
└── service/              # Business logic
```

## Security

- Passwords are encrypted using BCrypt
- JWT tokens are used for authentication
- CSRF protection is disabled for stateless API
- Endpoints are protected using Spring Security
- Input validation using Jakarta Validation

## API Documentation

### Base URL
```
http://localhost:8080/api
```

### Authentication
All authenticated endpoints require a JWT token in the Authorization header:
```
Authorization: Bearer <your_jwt_token>
```

### Endpoints

#### Authentication

##### Register New User
```http
POST /auth/register
```

**Request Body:**
```json
{
  "email": "string",      
  "password": "string",   
  "fullName": "string"    
}
```

**Response:** `200 OK`
```json
{
  "accessToken": "string",
  "user": {
    "id": "number",
    "email": "string",
    "fullName": "string",
    "createdAt": "string (ISO DateTime)"
  }
}
```

**Possible Errors:**
- `400 Bad Request`: Validation errors or email already registered
- `500 Internal Server Error`: Server error

##### User Login
```http
POST /auth/login
```

**Request Body:**
```json
{
  "email": "string",    
  "password": "string"  
}
```

**Response:** `200 OK`
```json
{
  "accessToken": "string",
  "user": {
    "id": "number",
    "email": "string",
    "fullName": "string",
    "createdAt": "string (ISO DateTime)"
  }
}
```

**Possible Errors:**
- `401 Unauthorized`: Invalid credentials
- `400 Bad Request`: Validation errors
- `500 Internal Server Error`: Server error

#### User Management

##### Get Current User
```http
GET /users/me
```

**Response:** `200 OK`
```json
{
  "id": "number",
  "email": "string",
  "fullName": "string",
  "createdAt": "string (ISO DateTime)"
}
```

**Possible Errors:**
- `401 Unauthorized`: Invalid or missing token
- `500 Internal Server Error`: Server error

##### Update Current User
```http
PUT /users/me
```

**Request Body:**
```json
{
  "fullName": "string",     
  "password": "string"      
}
```

**Response:** `200 OK`
```json
{
  "id": "number",
  "email": "string",
  "fullName": "string",
  "createdAt": "string (ISO DateTime)"
}
```

**Possible Errors:**
- `401 Unauthorized`: Invalid or missing token
- `400 Bad Request`: Validation errors
- `500 Internal Server Error`: Server error

### Error Responses

All error responses follow this format:
```json
{
  "error": "string"  
}
```

For validation errors:
```json
{
  "fieldName": "error message"
}
```

## Error Handling

The application includes a global exception handler that manages:
- Validation errors
- Authentication errors
- Runtime exceptions
- Custom business exceptions

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License
This project is licensed under the MIT License.

## Contact
For any inquiries, please contact Sandaru Gunathilake, maduhansadilshan@gmail.com
