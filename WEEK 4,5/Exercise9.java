// BookResource.java
public class BookResource extends ResourceSupport {
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;

    public BookResource(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
        this.isbn = book.getIsbn();

        add(linkTo(methodOn(BookController.class).getBook(id)).withSelfRel());
        add(linkTo(methodOn(BookController.class).updateBook(id, new BookDTO())).withRel("update"));
        add(linkTo(methodOn(BookController.class).deleteBook(id)).withRel("delete"));
    }
}

// BookController.java (updated)
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping("/{id}")
    public ResponseEntity<BookResource> getBook(@PathVariable Long id) {
        Book book = bookService.getBook(id);
        BookResource resource = new BookResource(book);
        return ResponseEntity.ok(resource);
    }
}