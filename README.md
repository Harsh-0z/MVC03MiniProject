# 🎬 MVC03 Mini Project – Spring MVC + JSP + Oracle

A simple, clean, interview-friendly MVC project demonstrating full CRUD operations using **Spring MVC**, **JSP**, **Spring Data JPA**, and **Oracle DB**.  
This project follows industry best practices, including **PRG pattern**, **centralized error handling**, and **JSP form binding** using Spring Form tags.

---

## 📌 Project Features

### ✔ **Actor Management Module**
- Add new Actor
- View all Actors in tabular format
- Edit Actor details
- Update Actor using Spring Form
- Delete Actor
- Success/Failure message displayed using Redirect Attributes
- Images (edit, delete, add, home) displayed from `/images` directory
- JSP pages located inside `/WEB-INF/pages`

### ✔ **Strong Spring MVC Concepts Used**
- `@Controller`, `@GetMapping`, `@PostMapping`
- `@ModelAttribute` (form binding)
- `@RequestParam` (edit/delete)
- **Redirect after POST** → PRG Pattern
- Using `BeanUtils.copyProperties()` for updating entity
- Proper view resolution via prefix/suffix
- Passing data via Model / RedirectAttributes

### ✔ **Error Handling**
Custom JSP pages for errors:
- `error.jsp` → shows detailed error (timestamp, message, path)
- `4xx.jsp` → client errors
- `5xx.jsp` → server errors

Spring Boot automatically fills:
${timestamp}, ${status}, ${error}, ${message}, ${path}



---

## 📂 **Project Structure**

MVC03MiniProject
│
├── src/main/java/com/main/demo/mvc03miniproject
│ ├── controller
│ │ └── ActorOperationsController.java
│ ├── dto
│ │ └── ActorDTO.java
│ ├── entity
│ │ └── ActorEntity.java
│ ├── repository
│ │ └── ActorRepository.java
│ ├── service
│ │ ├── IActorMgmtService.java
│ │ └── ActorMgmtServiceImpl.java
│ └── exception
│ └── ActorNotFoundException.java
│
├── src/main/webapp
│ ├── images/
│ │ ├── add.png
│ │ ├── edit.png
│ │ ├── delete.png
│ │ ├── report.png
│ │ └── home.png
│ └── WEB-INF/pages/
│ ├── welcome.jsp
│ ├── show_report.jsp
│ ├── register_actor_form.jsp
│ ├── edit_actor_form.jsp
│ └── error.jsp / 4xx.jsp / 5xx.jsp
│
└── application.properties


---

## 🛠 **Technologies Used**

| Technology | Description |
|-----------|-------------|
| Spring MVC | Web framework (Controllers + JSP) |
| JSP + JSTL | View layer |
| Spring Data JPA | ORM |
| Oracle Database | Backend database |
| Hibernate | JPA implementation |
| Tomcat | Deployment (WAR) |
| IntelliJ IDEA Ultimate | Development |
| Gradle | Build tool |

---

## ⚙️ **How to Run the Project**

### **1. Configure Oracle DB**
Create table:

```sql
CREATE TABLE actor_entity (
  aid NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  aname VARCHAR2(30),
  addrs VARCHAR2(30),
  category VARCHAR2(30),
  remuneration FLOAT,
  active_sw CHAR(1),
  created_by VARCHAR2(20),
  created_on TIMESTAMP,
  updated_by VARCHAR2(20),
  updated_on TIMESTAMP,
  update_count NUMBER
);

2. Update application.properties

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=C##HARSH
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update
spring.mvc.view.prefix=/WEB-INF/pages/
spring.mvc.view.suffix=.jsp
server.servlet.context-path=/MiniProjApp

3. Build & Run (WAR Deployment)
gradle clean build


💡 Interview Notes (Display confidently)

This project demonstrates:

Full CRUD using Spring MVC

Proper PRG pattern usage

MVC architecture separation

Clean JSP-Spring Form integration

Centralized error pages

Repository → Service → Controller flow

DTO–Entity conversion

Exception handling (custom exception)

WAR packaging + JSP deployment

Perfect for showing your understanding of Spring MVC flow and backend concepts.


🚀 How to Run in Browser
Operation	URL
Home	/MiniProjApp/
Report Page	/MiniProjApp/report
Add Actor	/MiniProjApp/add
Edit Actor	/MiniProjApp/edit?no={id}
Delete Actor	/MiniProjApp/delete?no={id}


👨‍💻 Author

Harsh 
Spring MVC Developer
GitHub: https://github.com/Harsh-0z
LinkedIn: https://www.linkedin.com/in/harsh-0z/