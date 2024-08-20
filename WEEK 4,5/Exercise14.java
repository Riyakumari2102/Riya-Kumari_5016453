// BookControllerIntegrationTest.java
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetBook() {
        ResponseEntity<BookDTO> response = restTemplate.getForEntity("/books/1", BookDTO.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book 1", response.getBody().getTitle());
    }
}