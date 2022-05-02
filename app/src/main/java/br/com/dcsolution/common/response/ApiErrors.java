package br.com.dcsolution.common.response;

import lombok.Getter;

import java.util.List;

public class ApiErrors {

    @Getter
    private final List<ApiError> errors;

    public ApiErrors(List<ApiError> errors) {
        this.errors = errors;
    }


}