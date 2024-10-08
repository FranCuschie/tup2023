package ar.edu.utn.frbb.tup.model;

import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlumnoTest {

    private static Alumno alumno;
    private static Materia m1;
    private static Materia m2;
    private static Materia m3;
    private static Materia m4;
    private static Profesor profesor1;
    private static Asignatura a1;
    private static Asignatura a2;
    private static Asignatura a3;
    private static Asignatura a4;


    @BeforeAll
    public static void setUp() {

        profesor1 = new Profesor(2222222L,"Luciano", "Salotto", "Programador");
        m1 = new Materia("Laboratorio 1", 1, 1, profesor1);
        m2 = new Materia("Laboratorio 2", 1, 2, profesor1);
        m3 = new Materia("Laboratorio 3", 2, 1, profesor1);
        m4 = new Materia("Laboratorio 4", 2, 2, profesor1);
        m2.agregarCorrelatividad(m1);
        m3.agregarCorrelatividad(m1);
        m3.agregarCorrelatividad(m2);
        m4.agregarCorrelatividad(m1);
        m4.agregarCorrelatividad(m2);
        m4.agregarCorrelatividad(m3);
        a1 = new Asignatura(m1, 1L);
        a2 = new Asignatura(m2, 2L);
        a3 = new Asignatura(m3, 3L);
    }

    @Test
    public void testNewAlumno() {
        alumno = new Alumno("Francisco", "Cuschie", 41198725);
        assertEquals("Francisco", alumno.getNombre());
        assertEquals("Cuschie", alumno.getApellido());
        assertEquals(41198725, alumno.getDni());
    }

    @Test
    public void testAlumnoSetAtributos() {
        alumno = new Alumno();
        alumno.setId(1);
        alumno.setDni(41198725);
        alumno.setNombre("Francisco");
        alumno.setApellido("Cuschie");
        alumno.setAsignaturas(new ArrayList<>());
        assertEquals(1, alumno.getId());
        assertEquals(41198725, alumno.getDni());
        assertEquals("Francisco", alumno.getNombre());
        assertEquals("Cuschie", alumno.getApellido());
        assertEquals(new ArrayList<>(), alumno.getAsignaturas());
    }

    @Test
    public void testAlumnoAgregarAsignatura() {
        alumno = new Alumno("Francisco", "Cuschie", 4198725);
        alumno.agregarAsignatura(a1);
        assertEquals(1, alumno.obtenerListaAsignaturas().size());
        assertEquals(a1, alumno.obtenerListaAsignaturas().get(0));
    }

    @Test
    public void testAlumnoCursarSinCorrelativasAprobadas() throws EstadoIncorrectoException, CorrelatividadException {
        alumno = new Alumno("Francisco", "Cuschie", 41198725);
        a1 = new Asignatura(m1, 1L);
        a2 = new Asignatura(m2, 2L);
        alumno.agregarAsignatura(a1);
        alumno.agregarAsignatura(a2);
        alumno.cursarAsignatura(a1);
        assertThrows(CorrelatividadException.class, () -> {
            alumno.cursarAsignatura(a2);
        });
    }

    @Test
    public void testAlumnoAprobarAsignaturaSinCursarla() {
        alumno = new Alumno("Francisco", "Cuschie", 41198725);
        a1 = new Asignatura(m1, 1L);
        alumno.agregarAsignatura(a1);
        assertThrows(EstadoIncorrectoException.class, () -> {
            alumno.aprobarAsignatura(a1, 10);
        });
    }

    @Test
    public void testAlumnoAprobarSinCorrelativasCursadas() {
        alumno = new Alumno("Francisco", "Cuschie", 41198725);
        a1 = new Asignatura(m1, 1L);
        a2 = new Asignatura(m2, 2L);
        alumno.agregarAsignatura(a1);
        alumno.agregarAsignatura(a2);
        assertThrows(CorrelatividadException.class, () -> {
            alumno.aprobarAsignatura(a2, 10);
        });
    }

    @Test
    public void testAlumnoCursarAsignatura() throws EstadoIncorrectoException, CorrelatividadException{
        alumno = new Alumno("Francisco", "Cuschie", 41198725);
        a1 = new Asignatura(m1, 1L);
        a2 = new Asignatura(m2, 2L);
        alumno.agregarAsignatura(a1);
        alumno.agregarAsignatura(a2);
        alumno.cursarAsignatura(a1);
        alumno.aprobarAsignatura(a1,10);
        alumno.cursarAsignatura(a2);
        assertEquals(EstadoAsignatura.APROBADA, a1.getEstado());
        assertEquals(10, a1.getNota().get());
        assertEquals(EstadoAsignatura.CURSADA, a2.getEstado());
    }

}