package ar.edu.utn.frbb.tup.controller;
import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/")
    public Alumno crearAlumno(@RequestBody AlumnoDto alumnoDto) {
        return alumnoService.crearAlumno(alumnoDto);
    }

    @PutMapping("/alumno/{idAlumno}")
    public Alumno modificarAlumno(@PathVariable("idAlumno") Long idAlumno) throws AlumnoNotFoundException {
        return alumnoService.buscarAlumno(idAlumno);
    }

    @DeleteMapping("/carrera/{idAlumno}")
    public Alumno eliminarAlumno(@RequestParam Long idAlumno) throws AlumnoNotFoundException {
        return alumnoService.eliminarAlumno(idAlumno);
    }

}