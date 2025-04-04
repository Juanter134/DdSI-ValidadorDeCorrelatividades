package domain.ejercicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    @Test
    @DisplayName("Verificar si el método tieneAprobadas de la clase Alumno funciona correctamente")
    public void funcionaTieneAprobadas(){
        Alumno alumno = new Alumno("Pepe","Don",1111112);

        Materia am1 = new Materia("Análisis matemático 1");
        Materia alg = new Materia("Álgebra");
        Materia am2 = new Materia("Análisis matemático 2");

        alumno.getMateriasAprobadas().addAll(List.of(am1,alg));

        Assertions.assertTrue(alumno.tieneAprobadas(List.of(am1)));             // materia aprobada
        Assertions.assertTrue(alumno.tieneAprobadas(List.of(am1,alg)));         // materias aprobadas
        Assertions.assertFalse(alumno.tieneAprobadas(List.of(am2)));            // materia no aprobada
        Assertions.assertFalse(alumno.tieneAprobadas(List.of(am1,alg,am2)));    // materias aprobadas y materia no aprobada
    }
}