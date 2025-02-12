package com.egg.estancias.persistence;

import com.egg.estancias.entities.Cliente;

public class ClienteDAO extends DAO {

    public void registrarCliente(Cliente cliente) throws Exception {
        String sql = String.format("""
                INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email)
                VALUES ('%s', '%s', %d, '%s', '%s', '%s', '%s')
                """,
                cliente.getNombre(),
                cliente.getCalle(),
                cliente.getNumero(),
                cliente.getCodigoPostal(),
                cliente.getCiudad(),
                cliente.getPais(),
                cliente.getEmail()
        );
        insertarModificarEliminar(sql);
    }

    public Cliente buscarClientePorId(int idCliente) throws Exception {
        String sql = "SELECT * FROM clientes WHERE id_cliente = " + idCliente + ";";
        consultarDataBase(sql);
        Cliente cliente = null;
        while (resultSet.next()) {
            cliente = new Cliente(
                    resultSet.getInt("id_cliente"),
                    resultSet.getString("nombre"),
                    resultSet.getString("calle"),
                    resultSet.getInt("numero"),
                    resultSet.getString("codigo_postal"),
                    resultSet.getString("ciudad"),
                    resultSet.getString("pais"),
                    resultSet.getString("email")
            );
        }
        return cliente;
    }
}
