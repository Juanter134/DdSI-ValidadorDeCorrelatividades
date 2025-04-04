package domain.ejercicio;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Alumno {
    private String nombre;
    private String apellido;
    private Integer legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, Integer legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public boolean tieneAprobadas(List<Materia> materias){
        return this.materiasAprobadas.containsAll(materias);
    }
}
