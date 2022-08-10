package ru.shabaev.zhezha.spring.library.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Publisher")
public class Publisher {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone_number")
    private int phoneNumber;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public Publisher() {
    }

    public Publisher(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
