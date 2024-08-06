package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.dto.AsignaturaDto;
import ar.edu.utn.frbb.tup.model.exception.AsignaturaInexistenteException;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;
import ar.edu.utn.frbb.tup.persistence.impl.AlumnoDaoMemoryImpl;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AlumnoServiceImpl implements AlumnoService {

    private static final AlumnoDao alumnoDao = new AlumnoDaoMemoryImpl();
    private static final AsignaturaService asignaturaService = new AsignaturaServiceImpl();


    @Override
    public Asignatura actualizarEstadoAsignatura(Long idAlumno, Long idAsignatura, AsignaturaDto asignaturaDto) throws EstadoIncorrectoException, AsignaturaNotFoundException, AsignaturaInexistenteException, CorrelatividadException, AlumnoNotFoundException {
        Alumno alumno = alumnoDao.findAlumno(idAlumno);
        Asignatura asignatura = asignaturaService.getAsignatura(idAsignatura);
        if (asignaturaDto.getEstado().equals(EstadoAsignatura.APROBADA)){
            alumno.aprobarAsignatura(asignatura, asignaturaDto.getNota());
        }
        else if (asignaturaDto.getEstado().equals(EstadoAsignatura.CURSADA)){
            alumno.cursarAsignatura(asignatura);
        }
        else {
            throw new CorrelatividadException("La condición de la materia solo puede ser cambiada a 'Cursada' o 'Aprobada'.");
        }
        asignaturaService.getAsignatura(asignatura.getId());
        alumno.actualizarAsignatura(asignatura);
        alumnoDao.saveAlumno(alumno);
        return asignatura;
    }

    @Override
    public Alumno crearAlumno(AlumnoDto alumno) {
        Alumno a = new Alumno();
        a.setNombre(alumno.getNombre());
        a.setApellido(alumno.getApellido());
        a.setDni(alumno.getDni());
        Random random = new Random();
        a.setId(random.nextLong());
        alumnoDao.saveAlumno(a);
        return a;
    }

    @Override
        public Alumno buscarAlumno(Long id) throws AlumnoNotFoundException {
        return alumnoDao.findAlumno(id);
    }

    @Override
    public Alumno eliminarAlumno(Long idAlumno) throws AlumnoNotFoundException {
        return alumnoDao.deleteAlumno(idAlumno);
    }
}