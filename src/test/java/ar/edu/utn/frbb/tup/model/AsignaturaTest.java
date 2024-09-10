package ar.edu.utn.frbb.tup.model;

import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsignaturaTest{

    private static Asignatura asignatura;

    private static Materia materia;
    private static Profesor profesor;

    @BeforeAll
    public static void setUp(){
        profesor = new Profesor(222222, "Luciano", "Salotto", "Programador");
        materia = new Materia("Laboratorio 3", 2, 1, profesor);
    }

    @Test
    public void testNewAsignatura() {
        Asignatura asignatura = new Asignatura(materia, 1L);
        assertEquals(EstadoAsignatura.NO_CURSADA, asignatura.getEstado());
        assertFalse(asignatura.getNota().isPresent());
        assertEquals("Laboratorio 3", asignatura.getNombreAsignatura());
    }

    @Test
    public void testAsignaturaSetAtributos() {
        asignatura = new Asignatura();
        asignatura.setId((long) 1);
        asignatura.setEstado(EstadoAsignatura.APROBADA);
        asignatura.setNota(10);
        asignatura.setMateria(materia);
        assertEquals(1, asignatura.getId());
        assertEquals(EstadoAsignatura.APROBADA, asignatura.getEstado());
        assertEquals(10, asignatura.getNota().get());
        assertEquals(materia, asignatura.getMateria());
    }

    @Test
    public void testAprobarAasignatura() throws EstadoIncorrectoException {
        asignatura = new Asignatura(materia, 1L);
        assertEquals(EstadoAsignatura.NO_CURSADA, asignatura.getEstado());
        asignatura.cursarAsignatura();
        asignatura.aprobarAsignatura(10);
        assertEquals(EstadoAsignatura.APROBADA, asignatura.getEstado());
        assertEquals(10, asignatura.getNota().get());
    }

    @Test
    public void testCursarAsignaturaYaCursada() throws EstadoIncorrectoException {
        asignatura = new Asignatura(materia, 1L);
        assertEquals(EstadoAsignatura.NO_CURSADA,asignatura.getEstado());
        asignatura.cursarAsignatura();
        assertThrows(EstadoIncorrectoException.class, () -> {
            asignatura.cursarAsignatura();
        });
        assertEquals(EstadoAsignatura.CURSADA, asignatura.getEstado());
    }

    @Test
    public void testCursarAsignaturaYaAprobada() throws EstadoIncorrectoException{
        asignatura = new Asignatura(materia, 1L);
        assertEquals(EstadoAsignatura.NO_CURSADA, asignatura.getEstado());
        asignatura.cursarAsignatura();
        asignatura.aprobarAsignatura(10);
        assertThrows(EstadoIncorrectoException.class, () -> {
            asignatura.cursarAsignatura();
        });
        assertEquals(EstadoAsignatura.APROBADA, asignatura.getEstado());
    }

    @Test
    public void testAprobarAsignaturaYaAprobada() throws EstadoIncorrectoException {
        asignatura = new Asignatura(materia, 1L);
        assertEquals(EstadoAsignatura.NO_CURSADA,asignatura.getEstado());
        asignatura.cursarAsignatura();
        asignatura.aprobarAsignatura(10);
        assertThrows(EstadoIncorrectoException.class, () -> {
            asignatura.aprobarAsignatura(10);
        });
        assertEquals(EstadoAsignatura.APROBADA, asignatura.getEstado());
    }

}