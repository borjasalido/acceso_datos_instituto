package org.ies.tierno;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Student implements Serializable {
    private String nif;
    private String name;
    private String surname;
    private int age;

}
