package br.com.sistema.logistica.poc.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parametros {

    private Parametros(){

    }

    private static final String[] ESTADOS = { "Acre",
           "Alagoas",
           "Amapá",
           "Amazonas",
           "Bahia",
           "Ceará",
           "Distrito Federal",
           "Espírito Santo",
           "Goiás",
           "Maranhão",
           "Mato Grosso",
           "Mato Grosso do Sul",
           "Minas Gerais",
           "Pará",
           "Paraíba",
           "Paraná",
           "Pernambuco",
           "Piauí",
           "Rio de Janeiro",
           "Rio Grande do Norte",
           "Rio Grande do Sul",
           "Rondônia",
           "Roraima",
           "Santa Catarina",
           "São Paulo",
           "Sergipe",
           "Tocantins"
    };

    public static List<String> LISTA_ESTADOS(){
        return Collections.unmodifiableList(Arrays.asList(ESTADOS));
    }


}
