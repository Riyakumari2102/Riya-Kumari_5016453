// BookControllerTest.java
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetBook() throws Exception {
        Book book = new Book(1L, "Book 1", "Author 1", 10.99);
        when(bookService.getBook(1L)).thenReturn(book);

        MvcResult result = mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andReturn();

        BookDTO bookDTO = mapper.readValue(result.getModelAndView().getModel(), BookDTO.class);
        assertEquals(book.getTitle(), bookDTO.getTitle());
    }
}