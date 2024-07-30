class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    // Constructor and getters/setters
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            size--;
        } else {
            System.out.println("Employee not found");
        }
    }
}

// Analysis:
// Analyze the time complexity of each operation (add, search, traverse,
// delete).
// Discuss the limitations of arrays and when to use them.

// Add: O(1) if there's space, otherwise O(n) if resizing is required.
// Search: O(n) in the worst case.
// Traverse: O(n)
// Delete: O(n) due to shifting elements.

// Limitations of arrays:
// Fixed size, leading to potential overflow if the number of elements exceeds
// capacity.
// Inefficient for insertions and deletions as it requires shifting elements.
// Not suitable for dynamic data structures where the size keeps changing.

// When to use arrays:
// When the data size is known in advance and unlikely to change significantly.
// When random access is the primary operation.
// For simple data structures where performance is critical and the limitations
// are acceptable.
// While arrays are simple to use, their limitations become apparent when
// dealing with dynamic data structures or frequent insertions and deletions. In
// such cases, other data structures like linked lists, ArrayLists, or HashMaps
// might be more suitable.
