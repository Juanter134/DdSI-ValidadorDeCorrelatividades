package domain.ejercicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("Verificar si el método aprobada de la clase incripción funciona correctamente")
    public void funcionaAprobadas(){
        Alumno alumno = new Alumno("Pepe","Don",1111112);

        Materia am1 = new Materia("Análisis matemático 1");
        Materia alg = new Materia("Álgebra");
        Materia fis = new Materia("Física");
        Materia am2 = new Materia("Análisis matemático 2");
        Materia anum = new Materia("Análisis numérico");
        Materia prob = new Materia("Probabilidad y estadística");

        am2.getCorrelatividades().addAll(List.of(am1,alg));
        anum.getCorrelatividades().addAll(List.of(am2,fis));
        prob.getCorrelatividades().add(am1);

        alumno.getMateriasAprobadas().addAll(List.of(am1,alg));

        Inscripcion ins1 = new Inscripcion();
        Inscripcion ins2 = new Inscripcion();
        Inscripcion ins3 = new Inscripcion();
        Inscripcion ins4 = new Inscripcion();
        Inscripcion ins5 = new Inscripcion();

        ins1.setAlumno(alumno);
        ins2.setAlumno(alumno);
        ins3.setAlumno(alumno);
        ins4.setAlumno(alumno);
        ins5.setAlumno(alumno);

        ins1.getMateriasInscriptas().add(fis);                      // materia sin correlativas
        ins2.getMateriasInscriptas().add(am2);                      // materia con correlativas aprobadas
        ins3.getMateriasInscriptas().addAll(List.of(fis,prob,am2)); // materia sin correlativas y dos materias con correlativas aprobadas
        ins4.getMateriasInscriptas().add(anum);                     // materia con correlativas no aprobadas
        ins5.getMateriasInscriptas().addAll(List.of(fis,anum));     // materia sin correlativas y materia con correlativas no aprobada

        Assertions.assertTrue(ins1.aprobada());
        Assertions.assertTrue(ins2.aprobada());
        Assertions.assertTrue(ins3.aprobada());
        Assertions.assertFalse(ins4.aprobada());
        Assertions.assertFalse(ins5.aprobada());
    }

}