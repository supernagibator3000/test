package com.example.pr2.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Класс книги со свойствами <b>name</b> и <b>creationDate</b>
*/
@Data
@Component
@NoArgsConstructor
public class Book {

    /** Поле название */
    private String name;

    /** Поле дата добавления */
    private Date creationDate;

    /** Конструктор - создание нового объекта с определенными значениями
     * @param name название
     */
    public Book(String name) {
        this.name = name;
        this.creationDate = new Date();
    }
}
