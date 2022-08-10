package ru.shabaev.zhezha.spring.library.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "pages_count")
    private int pagesCount;

    @Column(name = "publish_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "book_cover_id", referencedColumnName = "id")
    private BookCover bookCover;

    @OneToMany(mappedBy = "book")
    private List<UsageHistory> usages;

    @OneToMany(mappedBy = "book")
    private List<BookPosition> positions;

    public Book() {
    }

    public Book(String name, int pagesCount, Date publishDate) {
        this.name = name;
        this.pagesCount = pagesCount;
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public BookCover getBookCover() {
        return bookCover;
    }

    public void setBookCover(BookCover bookCover) {
        this.bookCover = bookCover;
    }

    public List<UsageHistory> getUsages() {
        return usages;
    }

    public void setUsages(List<UsageHistory> usages) {
        this.usages = usages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<BookPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<BookPosition> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pagesCount=" + pagesCount +
                ", publishDate=" + publishDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
