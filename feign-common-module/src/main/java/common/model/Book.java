package common.model;

import common.model.enums.CoverType;
import common.model.enums.GenreType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    String name;

    Person author;

    Integer size;

    CoverType cover;

    GenreType genre;
}
