package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;

import java.util.List;

public interface MateriaDao {

    Materia save(Materia materia, int[] correlatividades) throws MateriaNotFoundException;

    Materia findById(int idMateria) throws MateriaNotFoundException;

    void deleteMateria(int materiaId);

    List<Materia> getAllMaterias();
}
