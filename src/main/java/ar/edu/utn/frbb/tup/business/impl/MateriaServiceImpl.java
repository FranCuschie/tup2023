package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaDao dao;

    @Autowired
    private ProfesorService profesorService;

    @Override
    public Materia crearMateria(MateriaDto materia) throws IllegalArgumentException, ProfesorNotFoundException, MateriaNotFoundException {
        Materia m = new Materia();
        m.setNombre(materia.getNombre());
        m.setAnio(materia.getAnio());
        m.setCuatrimestre(materia.getCuatrimestre());
        m.setProfesor(profesorService.buscarProfesorById(materia.getProfesorId()));
        dao.save(m, materia.getCorrelatividades());
        profesorService.actualizarProfesor(profesorService.buscarProfesorById(materia.getProfesorId()));
        return m;
    }

    @Override
    public Materia getMateriaById(Integer idMateria) throws MateriaNotFoundException {
        return dao.findById(idMateria);
    }

    @Override
    public List<Materia> getAllMaterias() {
        return null;
    }

}