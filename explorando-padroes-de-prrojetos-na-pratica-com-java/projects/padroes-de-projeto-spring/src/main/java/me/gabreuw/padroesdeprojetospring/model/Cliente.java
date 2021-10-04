package me.gabreuw.padroesdeprojetospring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    @Id
    private Long id;

    private String nome;

    @ManyToOne
    private Endereco endereco;

}
