package br.com.dcsolution.group.presenter.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class GroupRequest implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    @NotNull
    private String name;

}
