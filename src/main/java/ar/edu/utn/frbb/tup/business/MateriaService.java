package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;

import java.util.List;

public interface MateriaService {

    Materia crearMateria(MateriaDto materiaDto) throws ProfesorNotFoundException;

    List<Materia> getAllMaterias();

    Materia getMateriaById(Integer idMateria) throws MateriaNotFoundException;
}
