package br.com.juliana.casadocodigo.request;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.com.juliana.casadocodigo.model.Author;
import br.com.juliana.casadocodigo.validation.annotation.Unique;

public class NewAuthorRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Unique(modelClass = Author.class, field = "email")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;

    public NewAuthorRequest(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Author toModel() {
        return new Author(name, email, description);
    }
}
