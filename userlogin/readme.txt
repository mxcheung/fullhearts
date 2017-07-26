├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── maxcheung
│       │           └── account
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
│       │               └── web
│       │                   └── UserController.java
│       ├── resources
│       │   ├── application.properties
│       │   ├── db.sql
│       │   ├── logback.xml
│       │   └── validation.properties
│       └── webapp
│           ├── resources
│           │   ├── css
│           │   │   ├── bootstrap.min.css
│           │   │   └── common.css
│           │   └── js
│           │       └── bootstrap.min.js
│           └── WEB-INF
│               ├── views
│               │   ├── login.jsp
│               │   ├── registration.jsp
│               │   └── welcome.jsp
│               ├── appconfig-data.xml
│               ├── appconfig-mvc.xml
│               ├── appconfig-root.xml
│               ├── appconfig-security.xml
│               └── web.xml
└── pom.xml