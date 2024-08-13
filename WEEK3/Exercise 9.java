// application.properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.datasource.secondary.url=jdbc:h2:mem:testdb2
spring.datasource.secondary.username=sa
spring.datasource.secondary.password=password
spring.jpa.secondary.database-platform=org.hibernate.dialect.H2Dialect

// DataSourceConfig.java
@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb")
                .username("sa")
                .password("password")
                .build();
    }
    
    @Bean
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb2")
                .username("sa")
                .password("password")
                .build();
    }
}

// EmployeeRepository.java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;
    
    @PersistenceContext(unitName = "secondary")
    private EntityManager secondaryEntityManager;
}