package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Profesor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ProfesorDaoMemoryImpl implements ProfesorDao {

    private static Map<Long, Profesor> repositorioProfesores = new HashMap<>();

    @Override
    public Profesor saveProfesor(Profesor profesor) {
        Random random = new Random();
        profesor.setId(random.nextLong());
        return repositorioProfesores.put(profesor.getDni(), profesor);
    }

    @Override
    public Profesor findProfesor(String profesorApellido) {
        for (Profesor profesor: repositorioProfesores.values())
        {
            if (profesor.getApellido().equals(profesorApellido)){
                return profesor;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe profesor con ese apellido."
        );
    }


    @Override
    public Profesor loadProfesor(Long dni) {
        return null;
    }

    @Override
    public Profesor deleteProfesor(String profesorApellido) {
        for (Profesor a: repositorioProfesores.values()) {
            if (a.getApellido().equals(profesorApellido)){
                repositorioProfesores.remove(a);
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se pudo eliminar, no existen Profesores con ese apellido."
        );
    }


}
