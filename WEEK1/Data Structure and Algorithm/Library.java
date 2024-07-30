import java.util.Arrays;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book; // Found! Return the book
            }
        }
        return null; // Not found
    }

    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle())); // Sort by title

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareTo(title);
            if (comparison == 0) {
                return books[mid]; // Found! Return the book
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book(2, "1984", "George Orwell"),
                new Book(3, "To Kill a Mockingbird", "Harper Lee")
        };

        Library library = new Library(books);

        System.out.println("Linear Search Result: " + library.linearSearchByTitle("1984"));
        System.out.println("Binary Search Result: " + library.binarySearchByTitle("1984"));
    }
}

// Linear Search:
// Best-case: O(1) (if the book is the first one)
// Average-case: O(n)
// Worst-case: O(n) (if the book is the last or not found)

// Binary Search:
// Best-case: O(1) (if the book is the middle element)
// Average-case: O(log n)
// Worst-case: O(log n)

// When to use which algorithm:
// Linear Search: Suitable for small datasets or when the data is not sorted.  
// Binary Search: Ideal for large, sorted datasets where efficiency is crucial.