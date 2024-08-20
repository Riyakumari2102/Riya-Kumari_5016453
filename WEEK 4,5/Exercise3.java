// BookController.java (updated)
@RestController
@RequestMapping("/books")
public class BookController {
    // ...

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        // Return a book by ID
    }

    @GetMapping
    public List<Book> getBooksByTitleOrAuthor(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        // Return a list of books filtered by title or author
    }
}