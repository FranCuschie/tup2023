package ar.edu.utn.frbb.tup.persistence.impl;

import ar.edu.utn.frbb.tup.controller.handler.UtnResponseEntityExceptionHandler;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
public class ProfesorDaoMemoryImplTest {

    @InjectMocks
    ProfesorDaoMemoryImpl profesorDaoMemory;

    MockMvc mockMvc;
    Materia materia, materia2, materia3;

    Profesor profesorCargado;

    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(profesorDaoMemory)
                .setControllerAdvice(UtnResponseEntityExceptionHandler.class)
                .build();

        materia = new Materia();
        materia.setNombre("Programación II");
        materia2 = new Materia();
        materia2.setNombre("Laboratorio II");
        materia3 = new Materia();
        materia3.setNombre("Laboratorio III");
    }

    @Test
    public void testProfesorSave() throws ProfesorNotFoundException {
        profesorCargado = new Profesor(222222,"Luciano", "Salotto", "Progamador");
        profesorDaoMemory.saveProfesor(profesorCargado);
        Profesor profesorEncontrado = profesorDaoMemory.findProfesor(profesorCargado.getId());
        assertEquals(profesorCargado, profesorEncontrado);
    }

    @Test
    public void testProfesorFindProfesor() throws ProfesorNotFoundException{
        profesorCargado = new Profesor(2222222,"Luciano", "Salotto", "Progamador");
        profesorDaoMemory.saveProfesor(profesorCargado);
        Profesor profesorEncontrado = profesorDaoMemory.findProfesor(profesorCargado.getId());
        assertEquals(profesorCargado, profesorEncontrado);
    }

    @Test
    public void testProfesorGetMateriasDictadas() throws ProfesorNotFoundException{
        profesorCargado = new Profesor();
        profesorCargado.setNombre("Luciano");
        profesorCargado.setApellido("Salotto");
        profesorCargado.setMateriasDictadas(materia);
        profesorCargado.setMateriasDictadas(materia2);
        profesorCargado.setMateriasDictadas(materia3);
        profesorDaoMemory.saveProfesor(profesorCargado);
        assertEquals(materia3, profesorDaoMemory.getMateriasDictadas(profesorCargado.getId()).get(0));
        assertEquals(materia2, profesorDaoMemory.getMateriasDictadas(profesorCargado.getId()).get(1));
        assertEquals(materia, profesorDaoMemory.getMateriasDictadas(profesorCargado.getId()).get(2));
    }

    @Test
    public void testProfesorDeleteProfesor() throws ProfesorNotFoundException {
        profesorCargado = new Profesor(222222,"Luciano", "Salotto", "Progamador");
        profesorDaoMemory.saveProfesor(profesorCargado);
        assertEquals(profesorCargado, profesorDaoMemory.findProfesor(profesorCargado.getId()));
        profesorDaoMemory.deleteProfesor(profesorCargado.getId());
        ProfesorNotFoundException exception = assertThrows(ProfesorNotFoundException.class, () -> {
            profesorDaoMemory.findProfesor(profesorCargado.getId());
        });
        assertEquals("No se pudo encontrar un profesor con el ID: " + profesorCargado.getId() + ".", exception.getMessage());
    }

}