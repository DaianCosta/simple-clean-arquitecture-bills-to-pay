package br.com.dcsolution.group.entity;

import br.com.dcsolution.group.exception.BusinessException;

import java.io.Serializable;

public class Group implements Serializable {

    private final Integer id;
    private final String name;

    public Group(final Integer id, final String name) {
        validate(name);
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name){
        if(name == null || name.isEmpty()){
            throw new BusinessException("Nome é obrigatório.");
        }
    }
}
