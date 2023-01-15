# Spring Security Demo
This is a demo for JWT based authentication for Spring Boot applications  
 - This is a quite basic implementation and does not follow best practices for sure. It just works.

## How To Run
- Requires Java 17 and Maven. No special configuration needed.

## How To Test
- Send a **GET** request to **"/demo"** endpoint.
  - You will get 401 Unauthorized
- Send a POST request to **"/auth/login"** endpoint with email and password in the request body.
  - *A user is registered for testing usage in Application class.*
      ```json
      {
        "username": "user",
        "password": "123"
      }
      ```
      - It will return a token.
- Apply the token as bearer in the same **"/demo"** endpoint. Now it will return 200 OK.
