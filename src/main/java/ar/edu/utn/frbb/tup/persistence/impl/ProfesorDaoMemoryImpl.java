package ar.edu.utn.frbb.tup.persistence.impl;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class ProfesorDaoMemoryImpl implements ProfesorDao {

    private static final Map<Long, Profesor> repositorioProfesores = new HashMap<>();

    @Override
    public Profesor saveProfesor(Profesor profesor) {
        Random random = new Random();
        profesor.setId(random.nextLong(999));
        return repositorioProfesores.put(profesor.getId(), profesor);
    }

    @Override
    public Profesor findProfesor(Long idProfesor) throws ProfesorNotFoundException {
        Profesor profesorExistente = repositorioProfesores.get(idProfesor);
        if (profesorExistente != null) {
            return profesorExistente;
        }
        else {
            throw new ProfesorNotFoundException("No se pudo encontrar un profesor con ese id");
        }
    }


    @Override
    public Profesor deleteProfesor(Long idProfesor) throws ProfesorNotFoundException {
        Profesor profesorExistente = repositorioProfesores.get(idProfesor);
        if (profesorExistente != null) {
            return profesorExistente;
        }
        else {
            throw new ProfesorNotFoundException("No se pudo encontrar un profesor con ese id");
        }
    }

    @Override
    public List<Materia> getMateriasDictadas(Long id) throws ProfesorNotFoundException {
        Profesor profesor = repositorioProfesores.get(id);
        if (profesor != null){
            List<Materia> listaMaterias = profesor.getMateriasDictadas();
            return listaMaterias;
        }
        else {
            throw new ProfesorNotFoundException("No se pudo encontrar un profesor con ese id");
        }
    }


}
