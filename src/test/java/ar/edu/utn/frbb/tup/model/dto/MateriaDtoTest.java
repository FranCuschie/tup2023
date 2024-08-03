package ar.edu.utn.frbb.tup.model.dto;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MateriaDtoTest {

    private static MateriaDto materiaDto;

    @Test
    public void testMateriaSetearAtributos() {
        materiaDto = new MateriaDto();
        materiaDto.setNombre("Laboratorio III");
        materiaDto.setAnio(1);
        materiaDto.setCuatrimestre(1);
        materiaDto.setProfesorId(12L);
        materiaDto.setCorrelatividades(null);
        assertEquals(materiaDto.getNombre(), "Laboratorio III");
        assertEquals(materiaDto.getAnio(), 1);
        assertEquals(materiaDto.getCuatrimestre(), 1);
        assertEquals(materiaDto.getProfesorId(), 1);
        assertEquals(materiaDto.getCorrelatividades(), null);
    }

}