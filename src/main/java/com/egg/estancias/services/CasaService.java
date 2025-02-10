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

    public void guardarCasa(Casa casa) throws Exception {
        validarCasa(casa);
        casaDAO.guardarCasa(casa);
    }

    public void modificarCasa(Casa casa) throws Exception {
        validarCasa(casa);
        casaDAO.modificarCasa(casa);
    }

    public void eliminarCasa(int idCasa) throws Exception {
        casaDAO.eliminarCasa(idCasa);
    }

    public List<Casa> listarCasasDisponiblesReinoUnido() throws Exception {
        return casaDAO.listarCasasDisponiblesReinoUnido();
    }

    public List<Casa> listarCasasDisponiblesPorFecha(String fecha, int dias) throws Exception {
        return casaDAO.listarCasasDisponiblesPorFecha(fecha, dias);
    }

    private void validarCasa(Casa casa) throws Exception {
        if (casa.getCalle().trim().isEmpty()) {
            throw new IllegalArgumentException("La calle no puede estar vacía");
        }
        if (casa.getNumero() < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo");
        }
        if (casa.getCodPostal().trim().isEmpty()) {
            throw new IllegalArgumentException("El código postal no puede estar vacío");
        }
        if (casa.getCiudad().trim().isEmpty()) {
            throw new IllegalArgumentException("La ciudad no puede estar vacía");
        }
        if (casa.getPais().trim().isEmpty()) {
            throw new IllegalArgumentException("El país no puede estar vacío");
        }
        if (casa.getFechaDesde() == null) {
            throw new IllegalArgumentException("La fecha desde no puede estar vacía");
        }
        if (casa.getFechaHasta() == null) {
            throw new IllegalArgumentException("La fecha hasta no puede estar vacía");
        }
        if (casa.getTiempoMinimo() < 0) {
            throw new IllegalArgumentException("El tiempo mínimo no puede ser negativo");
        }
        if (casa.getTiempoMaximo() < 0) {
            throw new IllegalArgumentException("El tiempo máximo no puede ser negativo");
        }
        if (casa.getPrecioHabitacion() < 0) {
            throw new IllegalArgumentException("El precio de la habitación no puede ser negativo");
        }
        if (casa.getTipoVivienda().trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de vivienda no puede estar vacío");
        }
    }
}
