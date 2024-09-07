package ar.edu.utn.frbb.tup.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoDtoTest {

    private static AlumnoDto alumnoDto;

    @Test
    public void testAlumnoDtoSetAtributos() {
        alumnoDto = new AlumnoDto();
        alumnoDto.setDni(41198725);
        alumnoDto.setNombre("Francisco");
        alumnoDto.setApellido("Cuschie");
        assertEquals(alumnoDto.getNombre(), "Francisco");
        assertEquals(alumnoDto.getApellido(), "Cuschie");
        assertEquals(alumnoDto.getDni(), 41198725);
    }

}