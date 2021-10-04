package me.gabreuw.gof.facade.subsystems.cep;

public class CepAPI {

    private static final CepAPI INSTANCE = new CepAPI();

    private CepAPI() {}

    public static CepAPI getInstance() {
        return INSTANCE;
    }

    public String retrieveCity(String cep) {
        return "São Paulo";
    }

    public String retrieveState(String cep) {
        return "São Paulo";
    }

}
