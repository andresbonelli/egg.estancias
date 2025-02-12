package com.egg.estancias;

import com.egg.estancias.entities.Estancia;

import com.egg.estancias.persistence.EstanciaDAO;
import com.egg.estancias.services.EstanciaService;
import com.egg.estancias.services.MenuService;

public class Main {
    public static void main(String[] args) throws Exception {


        MenuService menuService = new MenuService();
        menuService.iniciarMenu();
       /* Estancia estancia  = new Estancia();
        estancia.setIdCliente(40);
        estancia.setIdCasa(1);
        estancia.setNombreHuesped("Juan");
        estancia.setFechaDesde(java.sql.Date.valueOf("2020-08-02"));
        estancia.setFechaHasta(java.sql.Date.valueOf("2020-08-10"));

        estanciaService.registrarEstancia(estancia);*/
        }

}