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
public class Casa {
    private int idCasa;
    private String calle;
    private int numero;
    private String codPostal;
    private String ciudad;
    private String pais;
    private Date fechaDesde; //disponibilidad
    private Date fechaHasta;
    private int tiempoMinimo;
    private int tiempoMaximo;
    private double precioHabitacion;
    private String tipoVivienda;
}
