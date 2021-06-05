package br.com.juliana.casadocodigo.request;

import br.com.juliana.casadocodigo.exception.NotFoundException;
import br.com.juliana.casadocodigo.model.Country;
import br.com.juliana.casadocodigo.model.Customer;
import br.com.juliana.casadocodigo.model.State;
import br.com.juliana.casadocodigo.repository.CountryRepository;
import br.com.juliana.casadocodigo.repository.StateRepository;
import br.com.juliana.casadocodigo.validation.RequiredIfCountryHasState;
import br.com.juliana.casadocodigo.validation.annotation.CpfOrCnpj;
import br.com.juliana.casadocodigo.validation.annotation.Exists;
import br.com.juliana.casadocodigo.validation.annotation.RequiredIf;
import br.com.juliana.casadocodigo.validation.annotation.Unique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredIf(field = "stateId", condition = RequiredIfCountryHasState.class)
public class NewCustomerRequest {
    @Email
    @Unique(field = "email", modelClass = Customer.class)
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    @CpfOrCnpj
    @Unique(field = "document", modelClass = Customer.class)
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String complement;

    @NotBlank
    private String city;

    @NotNull
    @Exists(field = "id", modelClass = Country.class)
    private Integer countryId;

    @Exists(field = "id", modelClass = State.class)
    private Long stateId;

    @NotBlank
    private String phone;

    @NotBlank
    private String cep;

    public NewCustomerRequest(@Email String email, @NotBlank String name, @NotBlank String lastName, @NotBlank @CPF(groups = CpfGroup.class) @CNPJ(groups = CnpjGroup.class) String document, @NotBlank String address, @NotBlank String complement, @NotBlank String city, @NotNull Integer countryId, Long stateId, @NotBlank String phone, @NotBlank String cep) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phone = phone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public Customer toModel(CountryRepository countryRepository, StateRepository stateRepository) {
        var country = countryRepository.findById(countryId).orElseThrow(() -> new NotFoundException(countryId));
        State state = null;
        if (stateId != null) {
            state = stateRepository.findById(stateId).orElseThrow(() -> new NotFoundException(stateId));
        }
        return new Customer(email, name, lastName, document, address, complement, city, country, state, phone, cep);
    }
}
