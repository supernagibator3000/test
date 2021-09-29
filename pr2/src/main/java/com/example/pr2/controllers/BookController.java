package com.example.pr2.controllers;

import com.example.pr2.models.Book;
import com.example.pr2.services.BookService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Класс контроллер страницы книг со свойством <b>books</b>
 */
@Component
@RequestMapping("/book")
public class BookController {

    /** Поле слоя бизнес-логики книг */
    private BookService bookService;

    /**
     * Функция отображения списка всех книг
     * @param model хеш-таблица ключ-значений страницы
     * @return HTML страница
     */
    @GetMapping()
    public String get(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book";
    }

    /**
     * Функция создания объекта книги с свойством
     * @param name название книги
     * @param model хеш-таблица ключ-значений страницы
     * @return HTML страница
     */
    @PostMapping("/create")
    public String create(@RequestParam String name, Model model){
        bookService.add(new Book(name));
        model.addAttribute("books", bookService.getAll());
        return "redirect:/book";
    }

    /**
     * Функция удаления объекта книги по параметрам
     * @param name низвание книги
     * @return HTML страница
     */
    @PostMapping("/delete")
    public String delete(@RequestParam String name){
        bookService.delete(name);
        return "redirect:/book";
    }
}
