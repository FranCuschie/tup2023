package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.ProfesorDaoMemoryImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@Component
public class ProfesorServiceImpl implements ProfesorService {

    private static final ProfesorDao profesorDao = new ProfesorDaoMemoryImpl();

    // Preguntar que es el Autowired
    // @Autowired
    // private ProfesorDao dao;

    @Override
    public Profesor buscarProfesor(String profesorApellido) {
        return profesorDao.findProfesor(profesorApellido);
    }

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
    public ArrayList materiasDictadasOrdenadas(Profesor profesor, ArrayList materias) {
        materias = (ArrayList) profesor.getMateriasDictadas();
        Collections.sort(materias);
        return materias;
    }

}