package com.egg.estancias.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comentario {
    private int idComentario;
    private int idCasa;
    private String comentario;
}
