package com.egg.estancias;

import com.egg.estancias.services.CasaService;

public class Main {
    public static void main(String[] args) throws Exception {
        CasaService casaService = new CasaService();

        casaService.listarCasas().forEach(System.out::println);

        }
}