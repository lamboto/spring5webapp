package guru.springframework.spring5webapp.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    @ManyToMany
    @JoinTable(
        name = "author_book",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authos;

    public Book() {
    }

    public Book(String isbn, Set<Author> authos) {
        this.isbn = isbn;
        this.authos = authos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthos() {
        return authos;
    }

    public void setAuthos(Set<Author> authos) {
        this.authos = authos;
    }
}
