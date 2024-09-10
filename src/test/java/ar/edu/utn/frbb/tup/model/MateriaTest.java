package ar.edu.utn.frbb.tup.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MateriaTest {
    private static Materia materia;
    private static Profesor profesor;
    @BeforeAll
    public static void setUp(){
        profesor = new Profesor();
        profesor.setDni(2222222L);
        profesor.setNombre("Luciano");
        profesor.setApellido("Salotto");
        profesor.setTitulo("Programador");
    }

    @Test
    public void testMateriaSetearAtributos() {
        materia = new Materia();
        materia.setMateriaId(2);
        materia.setNombre("Laboratorio III");
        materia.setAnio(2);
        materia.setCuatrimestre(1);
        materia.setProfesor(profesor);
        materia.setCorrelatividades(new ArrayList<>());
        profesor.getMateriasDictadas().add(materia);
        assertEquals(2, materia.getMateriaId());
        assertEquals("Laboratorio III", materia.getNombre());
        assertEquals(2, materia.getAnio());
        assertEquals(1, materia.getCuatrimestre());
        assertEquals(profesor, materia.getProfesor());
        assertEquals(new ArrayList<>(), materia.getCorrelatividades());
        assertEquals(materia, materia.getProfesor().getMateriasDictadas().get(0));
    }

}