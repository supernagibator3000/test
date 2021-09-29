package com.example.pr2.controllers;

import com.example.pr2.models.Author;
import com.example.pr2.services.AuthorService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Класс контроллер страницы авторов со свойством <b>authorService</b>
 */
@Component
@RequestMapping("/author")
public class AuthorController {

    /** Поле слоя бизнес-логики авторов */
    private final AuthorService authorService;

    /** Конструктор - создание контроллера с параметром
     * @param authorService класс бизнес-логики
     */
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Функция отображения списка всех авторов
     * @param model хеш-таблица ключ-значений страницы
     * @return HTML страница
     */
    @GetMapping()
    public String get(Model model) {
        model.addAttribute("authors", authorService.getAll());
        return "author";
    }

    /**
     * Функция создания объекта автора с свойствами
     * @param firstName имя автора
     * @param lastName фамилия автора
     * @param middleName отчество автора
     * @param birthDate дата рождения автора
     * @param model хеш-таблица ключ-значений страницы
     * @return HTML страница
     */
    @PostMapping("/create")
    public String create(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String middleName,
                         @RequestParam String birthDate,
                         Model model){
        authorService.add(new Author(firstName, lastName, middleName, birthDate));
        model.addAttribute("authors", authorService.getAll());
        return "redirect:/author";
    }

    /**
     * Функция удаления объекта автора по параметрам
     * @param firstName имя автора
     * @param lastName фамилия автора
     * @param middleName отчество автора
     * @param birthDate дата рождения автора
     * @return HTML страница
     */
    @PostMapping("/delete")
    public String delete(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String middleName,
                         @RequestParam String birthDate){
        authorService.delete(firstName, lastName, middleName, birthDate);
        return "redirect:/author";
    }
}
