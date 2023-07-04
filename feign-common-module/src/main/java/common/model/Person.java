package common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    String firstName;
    String middleName;
    String lastName;
    int age;
}
