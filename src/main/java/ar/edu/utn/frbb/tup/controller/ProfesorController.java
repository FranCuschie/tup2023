package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public Profesor crearProfesor(@RequestBody ProfesorDto profesorDto) {
        return profesorService.crearProfesor(profesorDto);
    }

    @PutMapping("/{idProfesor}")
    public Profesor modificarProfesor(@PathVariable("idProfesor") Long id) throws ProfesorNotFoundException {
        return profesorService.modificarProfesor(id);
    }

    @DeleteMapping("/carrera/{idProfesor}")
    public Map<Long, Profesor> eliminarProfesor(@PathVariable("idProfesor") Long id) throws ProfesorNotFoundException {
        return profesorService.eliminarProfesor(id);
    }

    @GetMapping("/{idProfesor}/materias")
    public List<Materia> MateriasDictadas(@PathVariable ("idProfesor") Long idProfesor) throws ProfesorNotFoundException {
        return profesorService.materiasDictadas(idProfesor);
    }

}
