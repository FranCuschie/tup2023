package ar.edu.utn.frbb.tup.persistence.impl;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AlumnoDaoMemoryImplTest {

    @InjectMocks
    private AlumnoDaoMemoryImpl alumnoDaoMemory;

    Materia materia;
    Asignatura asignatura;
    List<Asignatura> asignaturas;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        materia = new Materia();
        asignatura = new Asignatura(materia, 1L);
        asignaturas = Arrays.asList(asignatura);
    }

    @Test
    public void testSaveAlumno() throws AlumnoNotFoundException {
        Alumno alumno = new Alumno("Francisco", "Cuschie", 41198725);
        alumnoDaoMemory.saveAlumno(alumno);

        Alumno alumnoGuardado = alumnoDaoMemory.findAlumno(alumno.getId());
        assertEquals(alumnoGuardado, alumno);
    }

    @Test
    public void testFindAlumnoThrowsError() throws AlumnoNotFoundException {
        Alumno alumno = new Alumno("Francisco", "Cuschie", 41198725);
        assertThrows(AlumnoNotFoundException.class, () -> {
            alumnoDaoMemory.findAlumno(alumno.getId());
        });
    }

    @Test
    public void testDeleteAlumno() throws AlumnoNotFoundException {
        Alumno alumno = new Alumno("Francisco", "Cuschie", 41198725);
        alumnoDaoMemory.saveAlumno(alumno);
        assertEquals(alumno, alumnoDaoMemory.findAlumno(alumno.getId()));
        alumnoDaoMemory.deleteAlumno(alumno.getId());

        assertThrows(AlumnoNotFoundException.class, () -> {
            alumnoDaoMemory.findAlumno(alumno.getId());
        });
    }
}