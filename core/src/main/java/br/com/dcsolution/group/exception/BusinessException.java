package br.com.dcsolution.group.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(final String message){
        super(message);
    }
}
