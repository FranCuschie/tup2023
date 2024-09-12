package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.controller.handler.UtnResponseEntityExceptionHandler;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.dto.AsignaturaDto;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
public class AlumnoControllerTest {

    @InjectMocks
    AlumnoController alumnoController;

    @Mock
    AlumnoService alumnoService;

    MockMvc mockMvc;

    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(alumnoController)
                .setControllerAdvice(UtnResponseEntityExceptionHandler.class)
                .build();
    }

    @Test
    public void crearAlumnoTest() throws Exception {
        Mockito.when(alumnoService.crearAlumno(any(AlumnoDto.class))).thenReturn(new Alumno());
        AlumnoDto alumnoDto = new AlumnoDto();
        alumnoDto.setDni(41198725L);
        alumnoDto.setNombre("Francisco");
        alumnoDto.setApellido("Cuschie");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/alumno")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(alumnoDto))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(new Alumno(), mapper.readValue(result.getResponse().getContentAsString(), Alumno.class));
    }

    @Test
    public void buscarAlumnoTest() throws Exception {
        Alumno alumno = new Alumno();
        alumno.setId(1L);

        Mockito.when(alumnoService.buscarAlumno(any(Long.class))).thenReturn(alumno);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/alumno/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(alumno)))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(alumno, mapper.readValue(result.getResponse().getContentAsString(), Alumno.class));
    }

    @Test
    public void eliminarAlumnoTest() throws Exception {
        Map<Long, Alumno> alumnosEliminados = new HashMap<>();
        Alumno alumno = new Alumno();
        alumno.setId(1L);
        alumno.setNombre("Francisco");
        alumno.setApellido("Cuschie");
        alumno.setDni(41198725L);
        alumnosEliminados.put(1L, alumno);

        Mockito.when(alumnoService.eliminarAlumno(any(Long.class))).thenReturn(alumnosEliminados);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/alumno/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(alumnosEliminados)))
                .andReturn();

        assertEquals(mapper.writeValueAsString(alumnosEliminados), result.getResponse().getContentAsString());

    }

    @Test
    public void actualizarEstadoTest() throws EstadoIncorrectoException, Exception {
        Mockito.when(alumnoService.actualizarEstadoAsignatura(any(Long.class), any(Long.class),
                any(AsignaturaDto.class))).thenThrow(new AsignaturaNotFoundException("No se encuentra ninguna asignatura con el ID: 1"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/alumno/1/asignaturas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"errorMessage\": \"No se encuentra ninguna asignatura con el ID: 1\"}"))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}
