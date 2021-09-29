package com.example.pr2.services;

import com.example.pr2.models.Book;
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
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void getAll() {
        List<Book> books = new ArrayList<Book>();
        assertEquals(books, bookService.getAll());
    }

    @Test
    void add() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Shrek");
        books.add(book);
        bookService.add(new Book("Shrek"));
        assertEquals(books, bookService.getAll());
    }

    @Test
    void delete() {
        List<Book> books = new ArrayList<Book>();
        bookService.add(new Book("Shrek"));
        bookService.delete("Shrek");
        assertEquals(books, bookService.getAll());
    }

}
