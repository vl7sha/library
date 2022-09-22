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

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "cover")
    private String cover;
    
    @OneToMany(mappedBy = "book")
    private List<UsageHistory> usages;

    @OneToMany(mappedBy = "book")
    private List<BookPosition> positions;

    @ManyToMany(mappedBy = "books")
    private List<Genre> genres;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    public Book() {
    }

    public Book(String name, int pagesCount, Date publishDate,
            String publisherName, String cover) {
        this.name = name;
        this.pagesCount = pagesCount;
        this.publishDate = publishDate;
        this.publisherName = publisherName;
        this.cover = cover;
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

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<UsageHistory> getUsages() {
        return usages;
    }

    public void setUsages(List<UsageHistory> usages) {
        this.usages = usages;
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
                ", publisherName='" + publisherName + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book))
            return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
