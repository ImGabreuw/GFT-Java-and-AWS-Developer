package me.gabreuw.restful.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SoldierResponse implements Serializable {

    private Long id;

    private String cpf;

    private String name;

    private String tribe;

    private String weapon;

    private String status;

}
