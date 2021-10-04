package me.gabreuw.gof.facade.subsystems.crm;

public class CrmService {

    private CrmService() {}

    public static void saveClient(String name, String cep, String city, String state) {
        System.out.printf(
                "Cliente (%s, %s, %s, %s) salvo no sistema CRM.%n",
                name, cep, city, state
        );
    }

}
