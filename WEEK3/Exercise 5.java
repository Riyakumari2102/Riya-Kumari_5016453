// EmployeeRepository.java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> findByNameLike(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findByDepartmentNameLike(@Param("departmentName") String departmentName);
}

// DepartmentRepository.java
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
    List<Department> findByNameLike(@Param("name") String name);
}