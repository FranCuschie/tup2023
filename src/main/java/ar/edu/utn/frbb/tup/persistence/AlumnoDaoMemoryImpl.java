package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AlumnoDaoMemoryImpl implements AlumnoDao {

    private static Map<Long, Alumno> repositorioAlumnos = new HashMap<>();

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        Random random = new Random();
        alumno.setId(random.nextLong());
        return repositorioAlumnos.put(alumno.getId(), alumno);
    }

    @Override
    public Alumno findAlumno(Long idAlumno) {
        Alumno alumnoExistente = repositorioAlumnos.get(idAlumno);
        if (alumnoExistente != null) {
            return alumnoExistente;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe alumno con ese id."
            );
        }
    }

    @Override
    public Alumno loadAlumno(Long dni) {
        return null;
    }

    @Override
    public Alumno deleteAlumno(Long idAlumno) {
        for (Alumno a: repositorioAlumnos.values()) {
            if (a.getApellido().equals(idAlumno)){
                return repositorioAlumnos.remove(idAlumno);
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existen alumnos con esos datos."
        );
    }

}