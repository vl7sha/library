package ru.shabaev.zhezha.spring.library.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Book_Cover")
public class BookCover {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "bookCover")
    private List<Book> books;

    public BookCover() {
    }

    public BookCover(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookCover{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookCover)) return false;
        BookCover bookCover = (BookCover) o;
        return id == bookCover.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
