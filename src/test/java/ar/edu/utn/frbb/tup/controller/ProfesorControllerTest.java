package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.controller.handler.UtnResponseEntityExceptionHandler;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
public class ProfesorControllerTest {

    @InjectMocks
    ProfesorController profesorController;

    @Mock
    ProfesorService profesorService;

    MockMvc mockMvc;

    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(profesorController)
                .setControllerAdvice(UtnResponseEntityExceptionHandler.class)
                .build();
    }

    @Test
    public void testCrearProfesor() throws Exception {
        Mockito.when(profesorService.crearProfesor(any(ProfesorDto.class))).thenReturn(new Profesor());
        ProfesorDto profesorDto = new ProfesorDto();
        profesorDto.setNombre("Luciano");
        profesorDto.setApellido("Salotto");
        profesorDto.setTitulo("Programador");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/profesor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(profesorDto))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(new Profesor(), mapper.readValue(result.getResponse().getContentAsString(), Profesor.class));
    }

    @Test
    public void testBuscarProfesor() throws Exception {
        Profesor profesor = new Profesor();
        profesor.setId(1);

        Mockito.when(profesorService.buscarProfesorById(any(Long.class))).thenReturn(profesor);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/profesor/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(profesor)))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(profesor, mapper.readValue(result.getResponse().getContentAsString(), Profesor.class));
    }

    @Test
    public void testBuscarMateriasDictadas() throws Exception {
        Profesor profesor = new Profesor();
        profesor.setId(1);
        List<Materia> materias = new ArrayList<>();
        materias.add(new Materia("Laboratorio", 1, 1, profesor));
        materias.add(new Materia("Progamacion", 1, 1, profesor));
        materias.add(new Materia("Elementos de la investigacion operativa", 1, 1, profesor));

        Mockito.when(profesorService.materiasDictadas(any(Long.class))).thenReturn(materias);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/profesor/1/materias")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(materias)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testEliminarProfesorById() throws Exception {
        Mockito.when(profesorService.eliminarProfesor(any(Long.class)));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/profesor/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();
    }

}