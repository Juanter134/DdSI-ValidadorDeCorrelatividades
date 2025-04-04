package domain.ejercicio;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Inscripcion {
    private List<Materia> materiasInscriptas;
    private Alumno alumno;

    public Inscripcion(){
        this.materiasInscriptas = new ArrayList<>();
    }

    public boolean aprobada(){
        List<Materia> todasLasCorrelatividades = materiasInscriptas.stream().flatMap(m -> m.getCorrelatividades().stream()).distinct().collect(Collectors.toList());
        return alumno.tieneAprobadas(todasLasCorrelatividades);
    }

}
