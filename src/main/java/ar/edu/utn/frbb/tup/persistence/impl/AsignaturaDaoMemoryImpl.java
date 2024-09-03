package ar.edu.utn.frbb.tup.persistence.impl;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.AsignaturaDao;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AsignaturaDaoMemoryImpl implements AsignaturaDao {

    private static final Map<Long, Asignatura> repositorioAsignaturas = new HashMap<>();

    @Override
    public Asignatura saveAsignatura(Materia materia) {
        // Genero un random en formato Long
        Random random = new Random();
        Asignatura asignatura = new Asignatura(materia, random.nextLong(999));
        return repositorioAsignaturas.put(asignatura.getId(), asignatura);
    }

    @Override
    public Asignatura getAsignaturaById(long id) throws AsignaturaNotFoundException {
        Asignatura asignaturaExistente = repositorioAsignaturas.get(id);
        if (asignaturaExistente != null) {
            return asignaturaExistente;
        }
        else {
            throw new AsignaturaNotFoundException("No existe Asignatura con ese id.");
        }
    }

    @Override
    public void actualizarAsignatura(Asignatura asignatura) throws AsignaturaNotFoundException {
        Asignatura asignatura2 = getAsignaturaById(asignatura.getId());
        repositorioAsignaturas.put(asignatura2.getId(), asignatura2);
    }

    @Override
    public List<Asignatura> getListAsignaturas() {
        return null;
    }
}
