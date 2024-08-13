// EmployeeProjection.java
public interface EmployeeProjection {
    Long getId();

    String getName();

    String getEmail();

    DepartmentProjection getDepartment();
}

// DepartmentProjection.java
public interface DepartmentProjection {
    Long getId();

    String getName();
}

// EmployeeRepository.java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeProjection> findAllProjectedBy();
}

// EmployeeController.java
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/projections")
    public List<EmployeeProjection> getEmployeesProjected() {
        return employeeRepository.findAllProjectedBy();
    }
}

// Class-based projection
public class EmployeeSummary {
    private Long id;
    private String name;
    private String email;
    private DepartmentSummary department;

    public EmployeeSummary(Long id, String name, String email, DepartmentSummary department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    // Getters and setters
}

public class DepartmentSummary {
    private Long id;
    private String name;

    public DepartmentSummary(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
}

// EmployeeRepository.java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Value("#{target.id} + ' - ' + #{target.name}")
    List<EmployeeSummary> findAllProjectedBy();
}