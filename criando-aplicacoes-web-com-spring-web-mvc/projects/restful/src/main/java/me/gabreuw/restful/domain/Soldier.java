package me.gabreuw.restful.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Soldier {

    private String cpf;

    private String name;

    private String tribe;

    private String weapon;

}
