package br.com.juliana.casadocodigo.validation;

import javax.persistence.EntityManager;

public class RequiredIfCountryHasState implements RequiredIfCondition<NewCustomerRequest> {

    @Override
    public Boolean isRequired(EntityManager manager, NewCustomerRequest request) {
        var resultList =  manager
                .createQuery("from State s where s.country.id = " + request.getCountryId())
                .getResultList();
        return !resultList.isEmpty();
    }
}