package com.egg.estancias.persistence;


import com.egg.estancias.entities.Familia;

import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO{

    public List<Familia> buscarFamiliasConHijosMenoresA10() throws Exception {
        String sql = "SELECT * FROM familias WHERE num_hijos >= 3 AND edad_maxima < 10";
        consultarDataBase(sql);
        List<Familia> familias = new ArrayList<>();
        while (resultSet.next()) {
            familias.add(new Familia(
                    resultSet.getInt("id_familia"),
                    resultSet.getString("nombre"),
                    resultSet.getInt("edad_minima"),
                    resultSet.getInt("edad_maxima"),
                    resultSet.getInt("num_hijos"),
                    resultSet.getString("email"),
                    resultSet.getInt("id_casa_familia")
            ));
        }
        return familias;
    }

    public List<Familia> buscarFamiliasConHotmail() throws Exception {
        String sql = "SELECT * FROM familias WHERE email LIKE '%@hotmail%'";
        consultarDataBase(sql);
        List<Familia> familias = new ArrayList<>();
        while (resultSet.next()) {
            familias.add(new Familia(
                    resultSet.getInt("id_familia"),
                    resultSet.getString("nombre"),
                    resultSet.getInt("edad_minima"),
                    resultSet.getInt("edad_maxima"),
                    resultSet.getInt("num_hijos"),
                    resultSet.getString("email"),
                    resultSet.getInt("id_casa_familia")
            ));
        }
        return familias;
    }
}
