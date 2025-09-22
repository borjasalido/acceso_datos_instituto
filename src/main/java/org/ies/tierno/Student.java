package org.ies.tierno;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String nif;
    private String name;
    private String surname;

}
