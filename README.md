# Spring Security Demo
This is a demo for JWT based authentication for Spring Boot applications  
 - This is a quite basic implementation and does not follow best practices for sure. Just works

## How To Run
- Requires Java 17 and Maven. No special configuration needed.

## How To Test
- Send a **GET** request to **"/demo"** endpoint.
  - You will get 403 Forbidden
- Send a POST request to **"/auth"** endpoint with email and password in the request body.
  - *A few users are registered for testing usage in UserProvider class.*
      ```json
      {
      "email": "admin@mail.com",
      "password": "123456"
      }
      ```
      - It will return a token.
- Apply the token as bearer in the same **"/demo"** endpoint. Now it will return 200 OK.
