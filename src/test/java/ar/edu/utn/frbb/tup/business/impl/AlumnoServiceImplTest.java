package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.model.*;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.dto.AsignaturaDto;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class AlumnoServiceImplTest {

    @InjectMocks
    AlumnoServiceImpl alumnoService;

    @Mock
    AlumnoDao alumnoDao;

    @Mock
    AsignaturaService asignaturaService;


    @Test
    public void crearAlumnoTest(){
        AlumnoDto alumnoDto = new AlumnoDto();
        alumnoDto.setApellido("Cuschie");
        alumnoDto.setDni(41198725L);
        alumnoDto.setNombre("Francisco");

        Alumno alumno = alumnoService.crearAlumno(alumnoDto);

        assertEquals(alumnoDto.getNombre(), alumno.getNombre());
        assertEquals(alumnoDto.getApellido(), alumno.getApellido());
        assertEquals(alumnoDto.getDni(), alumno.getDni());

    }

    @Test
    public void buscarAlumnoTest() throws AlumnoNotFoundException {
        Alumno alumno = new Alumno("Francisco", "Cuschie", 41198725);
        alumno.setId(1L);
        when(alumnoDao.findAlumno(1L)).thenReturn(alumno);

        Alumno alumnoEncontrado = alumnoDao.findAlumno(1L);
        verify(alumnoDao, times(1)).findAlumno(1L);
    }

    @Test
    public void eliminarAlumnoTest() throws AlumnoNotFoundException {
        Alumno alumno = new Alumno("Francisco", "Cuschie", 41198725);
        alumno.setId(1L);
        when(alumnoDao.findAlumno(1L)).thenReturn(alumno);

        alumnoService.eliminarAlumno(1L);
        verify(alumnoDao, times(1)).deleteAlumno(1L);

    }
    @Test
    public void actualizarEstadoAsignaturaTest() throws AsignaturaNotFoundException, AlumnoNotFoundException, EstadoIncorrectoException, CorrelatividadException {
        AsignaturaDto asignaturaDto = new AsignaturaDto();
        asignaturaDto.setEstado(EstadoAsignatura.CURSADA);

        Asignatura asignaturaEncontrada = new Asignatura(new Materia("Labatorio", 2, 3, new Profesor()), 1L);
        when(asignaturaService.getAsignatura(1L)).thenReturn(asignaturaEncontrada);

        Alumno alumno = new Alumno("Francisco", "Cuschie", 41198725);
        alumno.setId(1L);
        alumno.agregarAsignatura(asignaturaEncontrada);
        when(alumnoDao.findAlumno(1L)).thenReturn(alumno);

        Asignatura asignaturaActualizada = alumnoService.actualizarEstadoAsignatura(1L, 1L, asignaturaDto);

        assertEquals(asignaturaActualizada.getEstado(), EstadoAsignatura.CURSADA);
        verify(alumnoDao, times(1)).saveAlumno(alumno);

    }



}
