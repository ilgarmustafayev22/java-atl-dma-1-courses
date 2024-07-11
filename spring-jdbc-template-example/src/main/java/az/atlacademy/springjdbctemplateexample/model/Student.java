package az.atlacademy.springjdbctemplateexample.model;

import az.atlacademy.springjdbctemplateexample.model.dto.ErrorDto;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public Student(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

}
