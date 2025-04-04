package domain.ejercicio;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Materia {
    private String nombre;
    private List<Materia> correlatividades;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlatividades = new ArrayList<>();
    }
}
