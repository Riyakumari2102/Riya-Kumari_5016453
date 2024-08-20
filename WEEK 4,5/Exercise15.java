// pom.xml (if using Maven)
<dependencies>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-boot-starter</artifactId>
    </dependency>
</dependencies>

// BookController.java (updated)
@RestController
@RequestMapping("/books")
@Api(tags = "Books")
public class BookController {
    @GetMapping("/{id}")
    @ApiOperation("Get a book by ID")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
        // Return a book by ID
    }
}

// SwaggerConfig.java
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}