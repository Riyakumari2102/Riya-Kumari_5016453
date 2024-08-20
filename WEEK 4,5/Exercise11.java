// pom.xml (if using Maven)
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
</dependencies>

// application.properties
management:
  endpoints:
    web:
      exposure:
        include: health, info, metrics

// BookstoreAPIApplication.java
@SpringBootApplication
public class BookstoreAPIApplication {
    @Bean
    public SecurityConfigurerAdapter securityConfigurerAdapter() {
        return new SecurityConfigurerAdapter();
    }
}