package ar.edu.utn.frbb.tup.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfesorTest {

    private static Profesor profesor;
    private static Materia materia;

    @BeforeAll
    public static void setUp(){
        materia = new Materia();
    }

    @Test
    public void testProfesorSetearAtributos() {
        profesor = new Profesor();
        profesor.setId(1);
        profesor.setNombre("Luciano");
        profesor.setApellido("Salotto");
        profesor.setTitulo("Programador");
        profesor.setDni(222222L);
        profesor.setMateriasDictadas(materia);
        assertEquals(profesor.getDni(), 222222L);
        assertEquals(profesor.getId(), 1);
        assertEquals(profesor.getNombre(), "Luciano");
        assertEquals(profesor.getApellido(), "Salotto");
        assertEquals(profesor.getTitulo(), "Programador");
        assertEquals(profesor.getMateriasDictadas().get(0), materia);
    }

}