// BookController.java (updated)
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id, @RequestHeader("Accept") String accept) {
        Book book = bookService.getBook(id);
        if (accept.contains("application/json")) {
            return ResponseEntity.ok(book);
        } else if (accept.contains("application/xml")) {
            return ResponseEntity.ok(book, MediaType.APPLICATION_XML);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

// application.properties
spring:
  web:
    content-negotiation: media-type