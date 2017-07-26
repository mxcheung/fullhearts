├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── maxcheung
│       │           └── auth
│       │               ├── model
│       │               │   ├── Role.java
│       │               │   └── User.java
│       │               ├── repository
│       │               │   ├── RoleRepository.java
│       │               │   └── UserRepository.java
│       │               ├── service
│       │               │   ├── SecurityServiceImpl.java
│       │               │   ├── SecurityService.java
│       │               │   ├── UserDetailsServiceImpl.java
│       │               │   ├── UserServiceImpl.java
│       │               │   └── UserService.java
│       │               ├── validator
│       │               │   └── UserValidator.java
│       │               ├── web
│       │               │   └── UserController.java
│       │               ├── WebApplication.java
│       │               └── WebSecurityConfig.java
│       ├── resources
│       │   ├── application.properties
│       │   └── validation.properties
│       └── webapp
│           ├── resources
│           │   ├── css
│           │   │   ├── bootstrap.min.css
│           │   │   └── common.css
│           │   └── js
│           │       └── bootstrap.min.js
│           ├── login.jsp
│           ├── registration.jsp
│           └── welcome.jsp
└── pom.xml