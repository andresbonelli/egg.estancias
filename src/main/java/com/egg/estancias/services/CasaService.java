package com.egg.estancias.services;

import com.egg.estancias.entities.Casa;
import com.egg.estancias.persistence.CasaDAO;

import java.util.List;


public class CasaService {

    private final CasaDAO casaDAO;

    public CasaService() {
        this.casaDAO = new CasaDAO();
    }

    public List<Casa> listarCasas() throws Exception {
        return casaDAO.listarCasas();
    }

    public Casa buscarCasaPorId(int id) throws Exception {
        return casaDAO.buscarCasaPorId(id);
    }
}
