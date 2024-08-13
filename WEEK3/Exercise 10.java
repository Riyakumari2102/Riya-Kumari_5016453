// Employee.java
@Entity
@Table(name = "employees")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    // Getters and setters
}

// Department.java
@Entity
@Table(name = "departments")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    
    // Getters and setters
}

// application.properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.show-sql=true
spring.jpa.hibernate.format-sql=true

// EmployeeRepository.java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Modifying
    @Query("UPDATE Employee e SET e.name = :name WHERE e.id = :id")
    int updateEmployeeName(@Param("id") Long id, @Param("name") String name);
    
    @Transactional
    @BatchSize(size = 10)
    void saveAll(List<Employee> employees);
}

// EmployeeService.java
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public void batchSaveEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }
}

// HibernateConfig.java
@Configuration
public class HibernateConfig {
    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        return vendorAdapter;
    }
}