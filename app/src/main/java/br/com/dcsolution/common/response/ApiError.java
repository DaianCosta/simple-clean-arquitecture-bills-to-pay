package br.com.dcsolution.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class ApiError {
    private String key;
    private String value;
}