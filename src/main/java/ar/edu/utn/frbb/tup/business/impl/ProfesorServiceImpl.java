package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.ProfesorDaoMemoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@Component
public class ProfesorServiceImpl implements ProfesorService {

    private static final ProfesorDao profesorDao = new ProfesorDaoMemoryImpl();

    @Autowired
    private ProfesorDao dao;

    @Override
    public Profesor crearProfesor(ProfesorDto profe) {
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
    public Profesor modificarProfesor(Long idProfesor, Profesor profesor) {
        Profesor profe = profesorDao.findProfesor(idProfesor, profesor);
        profe.setNombre(profesor.getNombre());
        profe.setApellido(profesor.getApellido());
        profe.setTitulo(profesor.getTitulo());
        profe.setDni(profesor.getDni());
        profesorDao.saveProfesor(profe);
        return null;
    }

    @Override
    public Profesor eliminarProfesor(Long idProfesor) {
        return profesorDao.deleteProfesor(idProfesor);
    }

    @Override
    public ArrayList materiasDictadasOrdenadas(Profesor profesor, ArrayList materias) {
        materias = (ArrayList) profesor.getMateriasDictadas();
        Collections.sort(materias);
        return materias;
    }

}