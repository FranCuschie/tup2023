package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/")
    public Profesor crearProfesor(@RequestBody ProfesorDto profesorDto) {
        return profesorService.crearProfesor(profesorDto);
    }

    @PutMapping("/profesor/{idProfesor}")
    public Profesor modificarProfesor(@PathVariable("idProfesor") Long id) {
        return profesorService.modificarProfesor(id);
    }

    @DeleteMapping("/carrera/{idProfesor}")
    public Profesor eliminarProfesor(@RequestParam Long id) {
        return profesorService.eliminarProfesor(id);
    }

    @GetMapping("/profesor/{idProfesor}/materias")
    public Profesor MateriasDictadas(@PathVariable Long idProfesor) {
        return MateriasDictadas(idProfesor);
    }

}
