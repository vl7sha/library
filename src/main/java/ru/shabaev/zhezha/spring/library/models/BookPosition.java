package ru.shabaev.zhezha.spring.library.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Book_Position")
public class BookPosition {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @Column(name = "shelf_number")
    private int shelfNumber;

    @Column(name = "rack_number")
    private int rackNumber;

    public BookPosition() {
    }

    public BookPosition(int shelfNumber, int rackNumber) {
        this.shelfNumber = shelfNumber;
        this.rackNumber = rackNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public int getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(int rackNumber) {
        this.rackNumber = rackNumber;
    }

    @Override
    public String toString() {
        return "BookPosition{" +
                "id=" + id +
                ", shelfNumber=" + shelfNumber +
                ", rackNumber=" + rackNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookPosition)) return false;
        BookPosition that = (BookPosition) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
