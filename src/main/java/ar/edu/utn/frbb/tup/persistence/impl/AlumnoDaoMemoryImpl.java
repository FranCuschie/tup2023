package ar.edu.utn.frbb.tup.persistence.impl;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AlumnoDaoMemoryImpl implements AlumnoDao {

    private static final Map<Long, Alumno> repositorioAlumnos = new HashMap<>();

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        Random random = new Random();
        alumno.setId(random.nextLong());
        return repositorioAlumnos.put(alumno.getId(), alumno);
    }

    @Override
    public Alumno findAlumno(Long idAlumno) throws AlumnoNotFoundException {
        Alumno alumnoExistente = repositorioAlumnos.get(idAlumno);
        if (alumnoExistente != null) {
            return alumnoExistente;
        }
        else {
            throw new AlumnoNotFoundException("No existen alumnos con esos datos.");

        }
    }

    @Override
    public Alumno deleteAlumno(Long idAlumno) throws AlumnoNotFoundException{
        Alumno alumnoExistente = repositorioAlumnos.get(idAlumno);
        if (alumnoExistente != null) {
            return alumnoExistente;
        }
        else {
            throw new AlumnoNotFoundException("No existen alumnos con esos datos.");
        }
    }
}