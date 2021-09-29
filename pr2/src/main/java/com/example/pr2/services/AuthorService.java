package com.example.pr2.services;

import com.example.pr2.models.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс бизнес-логики авторов со свойством <b>authors</b>
 */
@Service
public class AuthorService {

    /** Поле массив книг */
    List<Author> authors = new ArrayList();

    /**
     * Функция получения списка всех авторов
     * @return массив авторов
     */
    public List<Author> getAll(){
        return authors;
    }

    /**
     * Функция добавления объекта автора в массив
     * @param author объект автор
     */
    public void add(Author author){
        authors.add(author);
    }

    /**
     * Функция удаления объекта автора по параметрам
     * @param firstName имя автора
     * @param lastName фамилия автора
     * @param middleName отчество автора
     * @param birthDate дата рождения автора
     */
    public void delete(String firstName, String lastName, String middleName, String birthDate){
        authors.removeIf(author -> (author.getFirstName().equals(firstName)
                && author.getLastName().equals(lastName)
                && author.getMiddleName().equals(middleName)
                && author.getBirthDate().equals(birthDate)));
    }
}
