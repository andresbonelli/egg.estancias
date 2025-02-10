package com.egg.estancias.persistence;


import com.egg.estancias.entities.Casa;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class CasaDAO extends DAO {

    public List<Casa> listarCasas() throws Exception {
        String sql = "SELECT * FROM casas;";
        consultarDataBase(sql);
        List<Casa> casas = new ArrayList<>();
        while (resultSet.next()) {
            casas.add(new Casa(
                    resultSet.getInt("id_casa"),
                    resultSet.getString("calle"),
                    resultSet.getInt("numero"),
                    resultSet.getString("codigo_postal"),
                    resultSet.getString("ciudad"),
                    resultSet.getString("pais"),
                    resultSet.getDate("fecha_desde"),
                    resultSet.getDate("fecha_hasta"),
                    resultSet.getInt("tiempo_minimo"),
                    resultSet.getInt("tiempo_maximo"),
                    resultSet.getDouble("precio_habitacion"),
                    resultSet.getString("tipo_vivienda")
            ));
        }
        return casas;
    }

    public List<Casa> listarCasasDisponibles() {
        return null;
    }
    public Casa buscarCasaPorId(int id) throws Exception{
        String sql = "SELECT * FROM casas WHERE id_casa = " + id + ";";
        consultarDataBase(sql);
        while (resultSet.next()) {
            return new Casa(
                    resultSet.getInt("id_casa"),
                    resultSet.getString("calle"),
                    resultSet.getInt("numero"),
                    resultSet.getString("codigo_postal"),
                    resultSet.getString("ciudad"),
                    resultSet.getString("pais"),
                    resultSet.getDate("fecha_desde"),
                    resultSet.getDate("fecha_hasta"),
                    resultSet.getInt("tiempo_minimo"),
                    resultSet.getInt("tiempo_maximo"),
                    resultSet.getDouble("precio_habitacion"),
                    resultSet.getString("tipo_vivienda")
            );
        };
        return null;
    };

    public void guardarCasa(Casa casa) throws Exception{
        String sql = String.format("""
                INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda)
                VALUES ('%s', %d, '%s', '%s', '%s', '%s', '%s', %d, %d, %f, '%s')
                """,
                casa.getCalle(),
                casa.getNumero(),
                casa.getCodPostal(),
                casa.getCiudad(),
                casa.getPais(),
                casa.getFechaDesde(),
                casa.getFechaHasta(),
                casa.getTiempoMinimo(),
                casa.getTiempoMaximo(),
                casa.getPrecioHabitacion(),
                casa.getTipoVivienda()
        );
        insertarModificarEliminar(sql);
    };

    public void modificarCasa(Casa casa) throws Exception {
        String sql = String.format("""
                UPDATE casas
                SET calle = '%s', numero = %d, codigo_postal = '%s', ciudad = '%s', pais = '%s', fecha_desde = '%s', fecha_hasta = '%s', tiempo_minimo = %d, tiempo_maximo = %d, precio_habitacion = %f, tipo_vivienda = '%s'
                WHERE id_casa = %d
                """,
                casa.getCalle(),
                casa.getNumero(),
                casa.getCodPostal(),
                casa.getCiudad(),
                casa.getPais(),
                casa.getFechaDesde(),
                casa.getFechaHasta(),
                casa.getTiempoMinimo(),
                casa.getTiempoMaximo(),
                casa.getPrecioHabitacion(),
                casa.getTipoVivienda(),
                casa.getIdCasa()
        );
        insertarModificarEliminar(sql);
    };

    public void eliminarCasa(int idCasa) throws Exception {
        String sql = "DELETE FROM casas WHERE id_casa = " + idCasa + ";";
        insertarModificarEliminar(sql);
    };

    // Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
    public List<Casa> listarCasasDisponiblesReinoUnido() throws Exception {
        String sql = String.format("""
                SELECT *
                FROM casas
                WHERE pais = 'Reino Unido'
                AND id_casa NOT IN (
                    SELECT e.id_casa
                    FROM estancias e
                    WHERE ('2020-08-01' <= e.fecha_hasta AND '2020-08-31' >= e.fecha_desde)
                );
                """);

        consultarDataBase(sql);
        List<Casa> casas = new ArrayList<>();
        while (resultSet.next()) {
            casas.add(new Casa(
                    resultSet.getInt("id_casa"),
                    resultSet.getString("calle"),
                    resultSet.getInt("numero"),
                    resultSet.getString("codigo_postal"),
                    resultSet.getString("ciudad"),
                    resultSet.getString("pais"),
                    resultSet.getDate("fecha_desde"),
                    resultSet.getDate("fecha_hasta"),
                    resultSet.getInt("tiempo_minimo"),
                    resultSet.getInt("tiempo_maximo"),
                    resultSet.getDouble("precio_habitacion"),
                    resultSet.getString("tipo_vivienda")
            ));
        }
        return casas;
    }

    // Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico.

    public List<Casa> listarCasasDisponiblesPorFecha(String fecha, int dias) throws Exception {
        String sql = String.format("""
                SELECT *
                FROM casas
                WHERE id_casa NOT IN (
                    SELECT e.id_casa
                    FROM estancias e
                    WHERE (DATE_ADD('%s', INTERVAL '%d' DAY) <= e.fecha_hasta AND '%s' >= e.fecha_desde)
                )
                AND fecha_desde <= '%s'
                AND fecha_hasta >= DATE_ADD('%s', INTERVAL '%d' DAY)
                AND tiempo_maximo >= %d
                """, fecha, dias, fecha, fecha, fecha, dias, dias);

        consultarDataBase(sql);
        List<Casa> casas = new ArrayList<>();
        while (resultSet.next()) {
            casas.add(new Casa(
                    resultSet.getInt("id_casa"),
                    resultSet.getString("calle"),
                    resultSet.getInt("numero"),
                    resultSet.getString("codigo_postal"),
                    resultSet.getString("ciudad"),
                    resultSet.getString("pais"),
                    resultSet.getDate("fecha_desde"),
                    resultSet.getDate("fecha_hasta"),
                    resultSet.getInt("tiempo_minimo"),
                    resultSet.getInt("tiempo_maximo"),
                    resultSet.getDouble("precio_habitacion"),
                    resultSet.getString("tipo_vivienda")
            ));
        }
        return casas;
    }
}
