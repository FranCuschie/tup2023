package ar.edu.utn.frbb.tup.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfesorDtoTest {

    private static ProfesorDto profesorDto;

    @Test
    public void testProfesorSetAtributos() {
        profesorDto = new ProfesorDto();
        profesorDto.setDni(2222222L);
        profesorDto.setNombre("Luciano");
        profesorDto.setApellido("Salotto");
        profesorDto.setTitulo("Programador");
        assertEquals(2222222L, profesorDto.getDni());
        assertEquals("Luciano", profesorDto.getNombre());
        assertEquals("Salotto", profesorDto.getApellido());
        assertEquals("Programador", profesorDto.getTitulo());
    }

}