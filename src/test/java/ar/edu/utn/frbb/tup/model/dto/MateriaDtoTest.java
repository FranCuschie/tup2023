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
        assertEquals("Laboratorio III", materiaDto.getNombre());
        assertEquals(1, materiaDto.getAnio());
        assertEquals(1, materiaDto.getCuatrimestre());
        assertEquals(12L, materiaDto.getProfesorId());
        assertEquals(null, materiaDto.getCorrelatividades());
    }

}