package me.gabreuw.stockquotesapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Quote {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String symbol;

    private Double openValue;

    private Double closeValue;

    private Date timestamp;

}
