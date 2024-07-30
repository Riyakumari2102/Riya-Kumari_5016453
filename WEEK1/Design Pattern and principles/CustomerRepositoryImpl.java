// CustomerRepository.java (Repository Interface)

/**
 * An interface representing a customer repository with methods like
 * findCustomerById().
 */
public interface CustomerRepository {
    Customer findCustomerById(int id);
}

// CustomerRepositoryImpl.java (Concrete Repository)

/**
 * A class implementing CustomerRepository with a method findCustomerById().
 */
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // Simulate finding a customer by ID
        Customer customer = new Customer(id, "John Doe", "john.doe@example.com");
        return customer;
    }
}

// Customer.java (Customer Class)

/**
 * A class representing a customer with attributes like id, name, and email.
 */
public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

// CustomerService.java (Service Class)

/**
 * A class representing a customer service that depends on CustomerRepository.
 */
public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// DependencyInjectionExample.java (Main Class)

/**
 * A main class to demonstrate creating a CustomerService with
 * CustomerRepositoryImpl and using it to find a customer.
 */
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create a CustomerRepositoryImpl
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Create a CustomerService with CustomerRepositoryImpl
        CustomerService customerService = new CustomerService(customerRepository);

        // Find a customer by ID
        Customer customer = customerService.findCustomerById(123);

        // Display customer details
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: " + customer.getEmail());
    }
}