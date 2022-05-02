package br.com.dcsolution.common.exception.handler;

import br.com.dcsolution.common.response.ApiError;
import br.com.dcsolution.common.response.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class BadRequestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(final MethodArgumentNotValidException ex) {

        List<ApiError> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ApiError(error.getField(), error.getDefaultMessage()));
        }

        return new ApiErrors(errors);
    }
}
