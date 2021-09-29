package com.example.pr2.services;

import com.example.pr2.models.Author;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    void getAll() {
        List<Author> authors = new ArrayList<Author>();
        assertEquals(authors, authorService.getAll());
    }

    @Test
    void add() {
        List<Author> authors = new ArrayList<Author>();
        Author author = new Author("Shrek", "Qwe", "Asd", "21.12.2077");
        authors.add(author);
        authorService.add(new Author("Shrek", "Qwe", "Asd", "21.12.2077"));
        assertEquals(authors, authorService.getAll());
    }

    @Test
    void delete() {
        List<Author> authors = new ArrayList<Author>();
        authorService.add(new Author("Shrek", "Qwe", "Asd", "21.12.2077"));
        authorService.delete("Shrek", "Qwe", "Asd", "21.12.2077");
        assertEquals(authors, authorService.getAll());
    }

}