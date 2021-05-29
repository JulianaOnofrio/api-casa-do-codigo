package br.com.juliana.casadocodigo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", unique = true)
    private String title;

    @Lob
    @Column(name = "resumo", length = 500)
    private String resume;

    @Lob
    @Column(name = "sumario", nullable = true)
    private String summary;

    @Column(name = "preco", precision = 2)
    private BigDecimal price;

    @Column(name = "numeroPaginas")
    private Integer pageCount;

    @Column(unique = true)
    private String isbn;

    @Column(name = "dataPublicacao")
    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "autor_id")
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(String title, String resume, String summary, BigDecimal price, Integer pageCount, String isbn, LocalDate publishDate, Category category, Author author) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Category getCategoria() {
        return category;
    }

    public Author getAutor() {
        return author;
    }
}