package me.gabreuw.gof.facade;

import me.gabreuw.gof.facade.subsystems.cep.CepAPI;
import me.gabreuw.gof.facade.subsystems.crm.CrmService;

public class Facade {

    public void convertClient(String name, String cep) {
        CepAPI instance = CepAPI.getInstance();

        CrmService.saveClient(
                name,
                cep,
                instance.retrieveCity(cep),
                instance.retrieveState(cep)
        );
    }

}
