# University Event Management System

This is a API project for insert, read, update, and delete Students and Events using **H2 Database** and `CrudRepository`.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot "Spring Boot") ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white "Java") ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white "Postman") ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white "Google Chrome")

## Frameworks and Languages

## ![Java v17](https://img.shields.io/badge/Java-v17-green "Java 17") ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-v3.0.6-brightgreen "Spring Boot v3.0.6")

## Browser / Tools

![Google Chrome](https://img.shields.io/badge/Google%20Chrome-v112.0.5615.138-yellow "Google Chrome") ![Postman](https://img.shields.io/badge/Postman-v10.13.0-orange "Postman")

## Model

- ### Student Properties
  - ```java
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    ```
  - ```java
    @Pattern(regexp = "^[A-Z][a-z]*$")
    private String firstName;
    ```
  - ```java
    private String lastName;
    ```
  - ```java
    @Min(value = 18)
    @Max(value = 25)
    private Integer age;
    ```
  - ```java
    @Enumerated(value = EnumType.STRING)
    private Departments department;
    ```
- ### Event Properties
  - ```java
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventId;
    ```
  - ```java
    private String eventName;
    ```
  - ```java
    private String locationOfEvent;
    ```
  - ```java
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}")
    private String date;
    ```
  - ```java
    @Pattern(regexp = "[0-9]{2}:[0-9]{2}")
    private String startTime;
    ```
  - ```java
    @Pattern(regexp = "[0-9]{2}:[0-9]{2}")
    private String endTime;
    ```
- ### Departments Enum
  ```java
  public enum Departments {
    ME,
    ECE,
    CIVIL,
    CSE
  }
  ```

---

## Dataflow

- ### End Points / Controllers
  - Student
    - `@PostMapping(value = "/")`
    - `@PutMapping(value = "/department/{department}/id/{id}")`
    - `@DeleteMapping(value = "/id/{id}")`
    - `@GetMapping(value = "/")`
    - `@GetMapping(value = "/id/{id}")`
  - Event
    - `@PostMapping(value = "/")`
    - `@PutMapping(value = "/")`
    - `@DeleteMapping(value = "/id/{id}")`
    - `@GetMapping(value = "/date/{date}")`
- ### Services
  - Student
    ```java
    public String addStudentToDb(Student student)
    ```
    ```java
    @Transactional
    public String updateDepartmentById(Departments department, Integer id)
    ```
    ```java
    public String deleteStudentById(Integer id)
    ```
    ```java
    public List<Student> getAllStudents()
    ```
    ```java
    public Student getStudentById(Integer id)
    ```
  - Event
    ```java
    public String addEventToDb(Event event)
    ```
    ```java
    public String updateEvent(Event event)
    ```
    ```java
    public String deleteEventById(Integer id)
    ```
    ```java
    public List<Event> getAllEventsByDate(String date)
    ```
- ### Repository

  - Student

    ```java
    @Repository
    public interface IStudentRepository extends CrudRepository<Student, Integer> {

      @Modifying
      @Query(value = "update students set department = :department where student_id = :id", nativeQuery = true)
      public void updateDepartmentById(String department, Integer id);
    }
    ```

  - Event

    ```java
    @Repository
    public interface IEventRepository extends CrudRepository<Event, Integer> {
      public List<Event> findByDate(String date);
    }
    ```

- ### Database
  In this project for datasource I've used **H2 Database**'s in memory type with `SpringDataJPA`.

---

## Datastructures

- `List<>`/`Inumrable<>`

---

## Summary

This API is a `Spring Boot` project that is about managing Events. We can create, read, update, and delete Students and Event. In this project request is sent from the client on HTTP in JSON format or from path variable with server side validations and stored in object then response is sent back from the server by JSON format to the client.
