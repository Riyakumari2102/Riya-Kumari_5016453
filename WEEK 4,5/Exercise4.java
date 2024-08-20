// Customer.java
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
}

// CustomerController.java
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        // Create a new customer
    }

    @PostMapping("/register")
    public Customer registerCustomer(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        // Process form data for customer registration
    }
}