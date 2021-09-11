package me.gabreuw.springwebmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jedi {

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

}
