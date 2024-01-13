# Registration-Management-System-MVC-Application

An MVC Application that provides a fully functioning login-signup authentication admins to delete, update existing users and also register new users.

Pre-requisites
```
Java =>	JDK 17
Spring Boot => V.3.2.1
Thymeleaf
Oracle SQL	
```

# Project Structure
```
.
├── src
│   ├── main
        └── java
           └── com
               └── luv2code
                   └── springboot
                       └── thymeleafdemo
                                │── aspect
                                     └── DemoLoggingAspect.java                      
                                │──controller
                                       └── DemoController.java
                                       ├──EmployeeController.java  
                                ├──dao
                                       └── EmployeeRepository.java
                                       ├── MembersRepository.java
                                       ├── MembersRepositoryImpl.java     
                                │──entity
                                       └── Employee.java
                                       ├── Members.java
                                       ├── Roles.java    
                                │──security
                                       └── DemoSecurityConfig.java
                                │──service
                                       └── ThymeleafdemoApplication.java


                              
    ├── resources
        ├── static
            └── index.html
        ├── templates
            └── employees
                   └── access-denied.html
                   ├── fancy-login.html
                   ├── helloworld.html
                   ├── plain-login.html    
                   ├── systems.html
        ├── application.properties

        ├── test

        ├── target
        ├── desktop.ini
        ├── Help.md
        ├── mnv
        ├── mnvw.cmd
        ├── pom.xml
        ├── Readme.md
```

