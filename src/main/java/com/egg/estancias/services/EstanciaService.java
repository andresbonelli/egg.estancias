package com.egg.estancias.services;

import com.egg.estancias.entities.Estancia;
import com.egg.estancias.persistence.EstanciaDAO;

public class EstanciaService {

    private final EstanciaDAO estanciaDAO;

    public EstanciaService() {
        this.estanciaDAO = new EstanciaDAO();
    }

    public void registrarEstancia(Estancia estancia) throws Exception {
        estanciaDAO.registrarEstancia(estancia);
    }
}
