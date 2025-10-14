package ru.romanov.springcourse.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person reader;

    @NotEmpty(message = "Tittle cannot be empty")
    @Column(name = "tittle")
    private String tittle;

    @Pattern(regexp="^[A-Z][a-z]*\\s[A-Z][a-z]*$", message = "Enter correct author name and surname")
    @NotEmpty(message = "Author cannot be empty")
    @Column(name = "author")
    private String author;

    @Max(value = 2025, message = "Year of production can not be bigger than 2025")
    @Column(name = "year_of_production")
    private Integer yearOfProduction;

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Person getReader() {
        return reader;
    }

    public void setReader(Person reader) {
        this.reader = reader;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}
