package ar.edu.utn.frbb.tup.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarreraTest {
    private static Carrera carrera;
    private static Profesor profesor;
    private static Materia materia, materia2;

    @BeforeAll
    public static void setUp(){
        profesor = new Profesor(2222222,"Luciano", "Salotto", "Programador");
        materia = new Materia("Laboratorio II", 1, 1, profesor);
        materia2 = new Materia("Laboratorio III", 1, 2, profesor);
    }

    @Test
    public void testCarreraSetearAtributos() {
        carrera = new Carrera("Programacion", 2);
        carrera.agregarMateria(materia);
        carrera.agregarMateria(materia2);
        assertEquals(carrera.getNombre(), "Programacion");
        assertEquals(carrera.getCantidadAnios(), 2);
        assertEquals(carrera.getMateriasList().get(0), materia);
        assertEquals(carrera.getMateriasList().get(1), materia2);
    }

}