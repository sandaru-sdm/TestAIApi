# User Authentication API Documentation

## Base URL
```
http://localhost:8080/api
```

## Authentication
All authenticated endpoints require a JWT token in the Authorization header:
```
Authorization: Bearer <your_jwt_token>
```

## Endpoints

### Authentication

#### Register New User
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

#### User Login
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

### User Management

#### Get Current User
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

#### Update Current User
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

## Error Responses

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
