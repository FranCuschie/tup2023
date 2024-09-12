package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.AsignaturaDao;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaDao asignaturaDao;

    @Autowired
    private MateriaService materiaService;

    @Override
    public Asignatura getAsignatura(Long id) throws AsignaturaNotFoundException {
        return asignaturaDao.getAsignaturaById(id) ;
    }

    @Override
    public void actualizarAsignatura(Asignatura a) throws AsignaturaNotFoundException {

    }

    @Override
    public List<Asignatura> obtenerAsignaturas() {
        List<Materia> materias = materiaService.getAllMaterias();
        asignaturaDao.saveAsignaturas(materias);
        return asignaturaDao.getListAsignaturas();
    }

}
