package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Profesor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProfesorDaoMemoryImpl implements ProfesorDao {

    private static Map<Long, Profesor> repositorioProfesores = new HashMap<>();

    @Override
    public Profesor saveProfesor(Profesor profesor) {
        return repositorioProfesores.put(profesor.getId(), profesor);
    }

    @Override
    public Profesor findProfesor(Long idProfesor) {
        Profesor profesorExistente = repositorioProfesores.get(idProfesor);
        if (profesorExistente != null) {
            return profesorExistente;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe profesor con ese id."
            );
        }
    }


    @Override
    public Profesor deleteProfesor(Long idProfesor) {
        for (Profesor p: repositorioProfesores.values()) {
            if (p.getApellido().equals(idProfesor)){
                return repositorioProfesores.remove(idProfesor);
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe profesor con esos datos."
        );
    }


}
