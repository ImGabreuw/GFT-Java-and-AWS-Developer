package me.gabreuw.restful.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Soldier {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String cpf;

    private String name;

    private String tribe;

    private String weapon;

    private String status;

}
