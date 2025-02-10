package com.egg.estancias.services;

import com.egg.estancias.entities.Familia;
import com.egg.estancias.persistence.FamiliaDAO;

import java.util.List;

public class FamiliaService {

    private final FamiliaDAO familiaDAO;
    public FamiliaService() {
        this.familiaDAO = new FamiliaDAO();
    }

    public List<Familia> listarFamiliasConHijosMenoresA10() throws Exception {
        return familiaDAO.buscarFamiliasConHijosMenoresA10();
    }

    public List<Familia> listarFamiliasConHotmail() throws Exception {
        return familiaDAO.buscarFamiliasConHotmail();
    }
}
