package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class ProfesorServiceImpl implements ProfesorService {


    @Autowired
    private ProfesorDao profesorDao;

    @Autowired
    private MateriaDao materiaDao;

    @Override
    public Profesor crearProfesor(ProfesorDto profe) {
        Profesor profesor = new Profesor();
        profesor.setNombre(profe.getNombre());
        profesor.setApellido(profe.getApellido());
        profesor.setTitulo(profe.getTitulo());
        profesor.setDni(profe.getDni());
        profesorDao.saveProfesor(profesor);
        return profesor;
    }

    @Override
    public Profesor modificarProfesor(Long idProfesor) throws ProfesorNotFoundException {
        Profesor profe = new Profesor();
        Profesor profesor = profesorDao.findProfesor(idProfesor);
        profe.setNombre(profesor.getNombre());
        profe.setApellido(profesor.getApellido());
        profe.setTitulo(profesor.getTitulo());
        profe.setDni(profesor.getDni());
        profesorDao.update(idProfesor, profe);
        return profe;
    }

    @Override
    public Map<Long, Profesor> eliminarProfesor(Long idProfesor) throws ProfesorNotFoundException {
        return profesorDao.deleteProfesor(idProfesor);
    }

    @Override
    public Profesor buscarProfesorById(Long idProfesor) throws ProfesorNotFoundException {
        return profesorDao.findProfesor(idProfesor);
    }

    @Override
    public List<Materia> materiasDictadas(Long idProfesor) throws  ProfesorNotFoundException {
        List listaOrdenada;
        listaOrdenada = profesorDao.getMateriasDictadas(idProfesor);
        Collections.sort(listaOrdenada);
        return listaOrdenada;
    }

    @Override
    public void actualizarProfesor(Profesor profesor) throws ProfesorNotFoundException {
        profesorDao.update(profesor.getId(), profesor);
    }


}