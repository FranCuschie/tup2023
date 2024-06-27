package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.ProfesorDaoMemoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ProfesorServiceImpl implements ProfesorService {

    private static final ProfesorDao profesorDao = new ProfesorDaoMemoryImpl();

    // Preguntar que es el Autowired
    // @Autowired
    // private ProfesorDao dao;

    @Override
    public Profesor buscarProfesor(long id) {
        return null;
    }

    @Override
    public Profesor CrearProfesor(ProfesorDto profesorDto) {
        Profesor profesor = new Profesor();
        Random random = new Random();
        profesor.setId(random.nextLong());
        profesor.setNombre(profesor.getNombre());
        profesor.setApellido(profesor.getApellido());
        profesor.setTitulo(profesor.getTitulo());
        profesor.setDni(profesor.getId());
        profesorDao.saveProfesor(profesor);
        return profesor;
    }

    @Override
    public Profesor EliminarProfesor(long profesorId) {
        return null;
    }

}