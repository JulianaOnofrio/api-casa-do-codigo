package br.com.juliana.casadocodigo.dto;

import br.com.juliana.casadocodigo.model.Book;

public class BookDTO {
    private Long id;

    private String title;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
