// pom.xml (if using Maven)
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>

// BookstoreAPIApplication.java
@SpringBootApplication
public class BookstoreAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookstoreAPIApplication.class, args);
    }
}