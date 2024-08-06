package ar.edu.utn.frbb.tup.persistence.impl;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class ProfesorDaoMemoryImpl implements ProfesorDao {

    private static Map<Long, Profesor> repositorioProfesores = new HashMap<>();

    @Override
    public Profesor saveProfesor(Profesor profesor) {
        Random random = new Random();
        profesor.setId(random.nextLong());
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

    @Override
    public List<Materia> getMateriasDictadas(Long id) throws ProfesorNotFoundException {
        Profesor profesor = repositorioProfesores.get(id);
        if (profesor == null){
            throw new ProfesorNotFoundException("No se pudo encontrar un profesor con ese id");
        }
        List<Materia> listaMaterias = profesor.getMateriasDictadas();
        return listaMaterias;
    }


}
