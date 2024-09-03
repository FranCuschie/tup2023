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
        assertEquals(asignatura.getId(), 1);
        assertEquals(asignatura.getEstado(), EstadoAsignatura.APROBADA);
        assertEquals(asignatura.getNota().get(), 10);
        assertEquals(asignatura.getMateria(), materia);
    }

    @Test
    public void testAprobarAasignatura() throws EstadoIncorrectoException {
        asignatura = new Asignatura(materia, 1L);
        assertEquals(EstadoAsignatura.NO_CURSADA,asignatura.getEstado());
        asignatura.cursarAsignatura();
        asignatura.aprobarAsignatura(10);
        assertEquals(EstadoAsignatura.APROBADA,asignatura.getEstado());
        assertEquals(asignatura.getNota().get(), 10);
    }

    @Test
    public void testCursarAsignaturaYaCursada() throws EstadoIncorrectoException {
        asignatura = new Asignatura(materia, 1L);
        assertEquals(EstadoAsignatura.NO_CURSADA,asignatura.getEstado());
        asignatura.cursarAsignatura();
        assertThrows(EstadoIncorrectoException.class, () -> {
            asignatura.cursarAsignatura();
        });
        assertEquals(asignatura.getEstado(), EstadoAsignatura.CURSADA);
    }

    @Test
    public void testCursarAsignaturaYaAprobada() throws EstadoIncorrectoException{
        asignatura = new Asignatura(materia, 1L);
        assertEquals(EstadoAsignatura.NO_CURSADA,asignatura.getEstado());
        asignatura.cursarAsignatura();
        asignatura.aprobarAsignatura(10);
        assertThrows(EstadoIncorrectoException.class, () -> {
            asignatura.cursarAsignatura();
        });
        assertEquals(asignatura.getEstado(), EstadoAsignatura.APROBADA);
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
        assertEquals(asignatura.getEstado(), EstadoAsignatura.APROBADA);
    }

}