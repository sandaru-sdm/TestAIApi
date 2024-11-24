# TestAIApi
Test API generated using AI 
# Spring Boot User Authentication API

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

For detailed API documentation, please refer to [API_DOCUMENTATION.md](API_DOCUMENTATION.md)

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
