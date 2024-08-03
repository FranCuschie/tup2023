package ar.edu.utn.frbb.tup.model.dto;

import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsignaturaDtoTest {
    private static AsignaturaDto asignaturaDto;
    @Test
    public void testAsignaturaDtoSetAtributos() {
        asignaturaDto = new AsignaturaDto();
        asignaturaDto.setEstado(EstadoAsignatura.APROBADA);
        asignaturaDto.setNota(10);
        assertEquals(asignaturaDto.getNota(), 10);
        assertEquals(asignaturaDto.getEstado(), EstadoAsignatura.APROBADA);
    }
}