package com.egg.estancias.persistence;

import com.egg.estancias.entities.Cliente;
import com.egg.estancias.entities.Estancia;
import java.util.ArrayList;
import java.util.List;

public class EstanciaDAO extends DAO {

    private final ClienteDAO clienteDAO;

    public EstanciaDAO() {
        this.clienteDAO = new ClienteDAO();
    }

    public void registrarEstancia(Estancia estancia) throws Exception {
        Cliente existingCliente = clienteDAO.buscarClientePorId(estancia.getIdCliente());
        if(existingCliente == null) {
            throw new Exception("El cliente no existe");
        }
        if(!verificarDisponibilidadEstancia(estancia)) {
            throw new Exception("La casa no está disponible en las fechas seleccionadas");
        }
        String sql = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta)" +
                " VALUES(" +
                "'" + estancia.getIdCliente() + "'," +
                "'" + estancia.getIdCasa() + "'," +
                "'" + estancia.getNombreHuesped() + "'," +
                "'" + estancia.getFechaDesde() + "'," +
                "'" + estancia.getFechaHasta() + "'" +
                ")";

        insertarModificarEliminar(sql);
        System.out.println("Estancia registrada con éxito");
    }

    public List<Estancia> listarEstancias() throws Exception {

        String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias";
        consultarDataBase(sql);
        List<Estancia> estancias = new ArrayList<>();
        while (resultSet.next()) {
            Estancia estancia = new Estancia();
            estancia.setIdEstancia(resultSet.getInt("id_estancia"));
            estancia.setIdCliente(resultSet.getInt("id_cliente"));
            estancia.setIdCasa(resultSet.getInt("id_casa"));
            estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
            estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
            estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));
            estancias.add(estancia);
        }
        return estancias;
    }

    public Estancia buscarEstancia(int idEstancia) throws Exception {
        String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias WHERE id_estancia=" + idEstancia;
        consultarDataBase(sql);

        Estancia estancia = new Estancia();
        while (resultSet.next()) {
            estancia.setIdEstancia(resultSet.getInt("id_estancia"));
            estancia.setIdCliente(resultSet.getInt("id_cliente"));
            estancia.setIdCasa(resultSet.getInt("id_casa"));
            estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
            estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
            estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));
        }
        return estancia;
    }

    private boolean verificarDisponibilidadEstancia(Estancia e) throws Exception {
        String sql = String.format("""
                SELECT COUNT(*) FROM estancias
                WHERE id_casa = %d
                AND NOT (fecha_hasta < '%s' OR fecha_desde > '%s')
                """,
                e.getIdCasa(),
                e.getFechaDesde(),
                e.getFechaHasta());
        consultarDataBase(sql);
        if (resultSet.next()) {
            return resultSet.getInt(1) == 0; //True si no hay estancias, False si hay al menos 1
        }
        return true; // En caso de error, asumir disponibilidad
    }
}
