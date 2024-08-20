// BookController.java (updated)
@RestController
@RequestMapping("/books")
public class BookController {
    // ...

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable Long id) {
        // Return a book by ID
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        // Create a new book
        return ResponseEntity.ok(book).header("Location", "/books/" + book.getId());
    }
}