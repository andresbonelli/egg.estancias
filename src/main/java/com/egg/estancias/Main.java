package com.egg.estancias;

import com.egg.estancias.services.CasaService;
import com.egg.estancias.services.FamiliaService;
import com.egg.estancias.services.MenuService;

public class Main {
    public static void main(String[] args) throws Exception {


        MenuService menuService = new MenuService();
        menuService.iniciarMenu();

        }
}