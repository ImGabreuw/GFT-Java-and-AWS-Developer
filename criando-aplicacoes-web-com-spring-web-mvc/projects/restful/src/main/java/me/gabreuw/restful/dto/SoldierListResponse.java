package me.gabreuw.restful.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class SoldierListResponse extends RepresentationModel<SoldierListResponse> implements Serializable {

    private Long id;

    private String name;

    private String tribe;

}

