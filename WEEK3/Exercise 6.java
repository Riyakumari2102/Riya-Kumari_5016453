// EmployeeController.java
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public Page<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }

    @GetMapping("/sorted")
    public List<Employee> getEmployeesSortedByName() {
        return employeeRepository.findAll(Sort.by("name"));
    }
}

// EmployeeRepository.java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll(Sort sort);

    Page<Employee> findAll(Pageable pageable);
}