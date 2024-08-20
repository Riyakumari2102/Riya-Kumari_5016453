// BookDTO.java
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;

    // Getters and setters
}

// CustomerDTO.java
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String password;

    // Getters and setters
}

// BookMapper.java (using MapStruct)
@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO bookDTO);
}

// CustomerMapper.java (using MapStruct)
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}