package common.builders;

import common.model.Book;
import common.model.Person;
import common.model.enums.CoverType;
import common.model.enums.GenreType;

public final class BookBuilder {
    private String name;
    private Person author;
    private Integer size;
    private CoverType cover;
    private GenreType genre;

    public static Book createDetectiveWithHardCover() {
        return new BookBuilder().genre(GenreType.DETECTIVE).cover(CoverType.HARD).build();
    }

    public BookBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BookBuilder author(Person author) {
        this.author = author;
        return this;
    }

    public BookBuilder size(Integer size) {
        this.size = size;
        return this;
    }

    public BookBuilder cover(CoverType cover) {
        this.cover = cover;
        return this;
    }

    public BookBuilder genre(GenreType genre) {
        this.genre = genre;
        return this;
    }

    public Book build() {
        return new Book(name, author, size, cover, genre);
    }

}
