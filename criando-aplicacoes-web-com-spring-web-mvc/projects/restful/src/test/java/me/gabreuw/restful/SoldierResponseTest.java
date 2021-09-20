package me.gabreuw.restful;

import me.gabreuw.restful.domain.enums.Tribe;
import me.gabreuw.restful.dto.SoldierResponse;

public class SoldierResponseTest {

    public static SoldierResponse create() {
        return new SoldierResponse(
                1L,
                "987654321",
                "Ricardo",
                Tribe.HUMAN.getName(),
                "Espada",
                "Morto"
        );
    }

}
