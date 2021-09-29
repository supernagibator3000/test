package com.example.pr2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Класс автора со свойствами <b>firstName</b>, <b>lastName</b>, <b>middleName</b> и <b>birthDate</b>
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    /** Поле имя */
    private String firstName;

    /** Поле фамилия */
    private String lastName;

    /** Поле отчество */
    private String middleName;

    /** Поле дата рождения */
    private String birthDate;

}
