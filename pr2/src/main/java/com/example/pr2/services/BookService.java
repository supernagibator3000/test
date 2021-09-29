package com.example.pr2.services;

import com.example.pr2.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс бизнес-логики книг со свойством <b>books</b>
 */
@Service
public class BookService {

    /** Поле массив книг */
    List<Book> books = new ArrayList();

    /**
     * Функция получения списка всех книг
     * @return массив авторов
     */
    public List<Book> getAll(){
        return books;
    }

    /**
     * Функция добавления объекта книги в массив
     * @param book объект книга
     */
    public void add(Book book){
        books.add(book);
    }

    /**
     * Функция удаления объекта книги по параметрам
     * @param name название
     */
    public void delete(String name){
        books.removeIf(book -> (book.getName().equals(name)));
    }
}
