package ar.edu.utn.frbb.tup.controller;
import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.dto.AsignaturaDto;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;
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

    @PutMapping("/{idAlumno}")
    public Alumno modificarAlumno(@PathVariable("idAlumno") Long idAlumno) throws AlumnoNotFoundException {
        return alumnoService.buscarAlumno(idAlumno);
    }

    @DeleteMapping("/{idAlumno}")
    public Alumno eliminarAlumno(@PathVariable Long idAlumno) throws AlumnoNotFoundException {
        return alumnoService.eliminarAlumno(idAlumno);
    }

    @PutMapping("/{idAlumno}/asignaturas/{idAsignatura}")
    public Asignatura actualizarEstado(@PathVariable("idAlumno") Long idAlumno, @PathVariable("idAsignatura") Long idAsignatura, @RequestBody AsignaturaDto asignaturaDto) throws AlumnoNotFoundException, AsignaturaNotFoundException,
            EstadoIncorrectoException, CorrelatividadException {
        return alumnoService.actualizarEstadoAsignatura(idAlumno, idAsignatura, asignaturaDto);
    }

}