package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ProfesorServiceImplTest {

    @InjectMocks
    ProfesorServiceImpl profesorService;

    @Mock
    ProfesorDao profesorDao;

    @Mock
    MateriaDao materiaDao;


    @Test
    public void testCrearProfesor() {
        ProfesorDto profesorDto = new ProfesorDto();
        profesorDto.setDni(222222L);
        profesorDto.setNombre("Luciano");
        profesorDto.setApellido("Salotto");
        profesorDto.setTitulo("Programador");

        Profesor profesor = new Profesor(222222L, "Luciano", "Salotto", "Programador");
        when(profesorDao.saveProfesor(any(Profesor.class))).thenReturn(profesor);

        Profesor profesorCreado = profesorService.crearProfesor(profesorDto);

        assertEquals("Luciano", profesorCreado.getNombre());
        assertEquals("Salotto", profesorCreado.getApellido());
    }

    @Test
    public void testBuscarProfesor() throws ProfesorNotFoundException {
        Profesor profesor = new Profesor(222222L,"Salotto", "Luciano", "Progamador");
        when(profesorDao.findProfesor(1L)).thenReturn(profesor);

        Profesor profesorEncontrado = profesorDao.findProfesor(1L);
        verify(profesorDao, times(1)).findProfesor(1L);
    }

    @Test
    public void testBuscarMateriasDictadas() throws ProfesorNotFoundException {
        List<Materia> materias = new ArrayList<>();
        materias.add(new Materia("Lab", 1, 1, new Profesor()));
        when(profesorDao.getMateriasDictadas(1L)).thenReturn(materias);

        List<Materia> materiasEncontradas = profesorDao.getMateriasDictadas(1L);
        assertEquals(materias.get(0), materiasEncontradas.get(0));
    }

    @Test
    public void testDeleteProfesor() throws ProfesorNotFoundException{
        List<Materia> materiasDictadas = new ArrayList<>();
        materiasDictadas.add(new Materia("Programacion", 1, 1, new Profesor()));
        when(profesorDao.getMateriasDictadas(1L)).thenReturn(materiasDictadas);
        profesorService.eliminarProfesor(1L);
        verify(profesorDao, times(1)).deleteProfesor(1L);
    }
}