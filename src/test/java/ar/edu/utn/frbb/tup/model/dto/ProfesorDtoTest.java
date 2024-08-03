package ar.edu.utn.frbb.tup.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfesorDtoTest {

    private static ProfesorDto profesorDto;

    @Test
    public void testProfesorSetAtributos() {
        profesorDto = new ProfesorDto();
        profesorDto.setNombre("Luciano");
        profesorDto.setApellido("Salotto");
        profesorDto.setTitulo("Programador");
        assertEquals(profesorDto.getNombre(), "Luciano");
        assertEquals(profesorDto.getApellido(), "Salotto");
        assertEquals(profesorDto.getTitulo(), "Programador");
    }

}