package com.egg.estancias.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Familia {
    private int id;
    private String nombre;
    private int edadMinima;
    private int edadMaxima;
    private int numHijos;
    private String email;
    private int idCasaFamilia;
}
