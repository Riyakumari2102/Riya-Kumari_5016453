// Book.java
@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;
}

// BookController.java
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public List<Book> getAllBooks() {
        // Return a list of books
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        // Create a new book
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        // Return a book by ID
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        // Update a book
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        // Delete a book
    }
}