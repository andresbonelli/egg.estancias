package com.egg.estancias.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estancia {
    private Integer idEstancia;
    private int idCliente;
    private int idCasa;
    private String nombreHuesped;
    private Date fechaDesde;
    private Date fechaHasta;
}
