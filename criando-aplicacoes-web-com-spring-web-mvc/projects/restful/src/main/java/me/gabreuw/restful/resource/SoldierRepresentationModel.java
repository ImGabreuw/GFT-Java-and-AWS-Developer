package me.gabreuw.restful.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.gabreuw.restful.domain.Soldier;
import me.gabreuw.restful.dto.SoldierListResponse;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@RequiredArgsConstructor
public class SoldierRepresentationModel {

    private final ObjectMapper objectMapper;

    public SoldierListResponse createLink(Soldier soldier) {
        SoldierListResponse response = objectMapper.convertValue(
                soldier,
                SoldierListResponse.class
        );

        response.add(
                linkTo(
                        methodOn(SoldierResource.class).findById(soldier.getId())
                ).withSelfRel()
        );

        return response;
    }

}
