package ru.shabaev.zhezha.spring.library.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Library_Card")
public class LibraryCard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "living_address")
    private String livingAddress;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date expirationDate;

    @OneToMany(mappedBy = "libraryCard")
    private List<UsageHistory> usages;

    public LibraryCard() {
    }

    public LibraryCard(String name, String surname, String livingAddress, Date expirationDate) {
        this.name = name;
        this.surname = surname;
        this.livingAddress = livingAddress;
        this.expirationDate = expirationDate;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLivingAddress() {
        return livingAddress;
    }

    public void setLivingAddress(String livingAddress) {
        this.livingAddress = livingAddress;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public List<UsageHistory> getUsages() {
        return usages;
    }

    public void setUsages(List<UsageHistory> usages) {
        this.usages = usages;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", livingAddress='" + livingAddress + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryCard)) return false;
        LibraryCard that = (LibraryCard) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
