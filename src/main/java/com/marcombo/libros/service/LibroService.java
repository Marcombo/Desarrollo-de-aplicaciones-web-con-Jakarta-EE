
package com.marcombo.libros.service;

import com.marcombo.libros.entity.Libro;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class LibroService {

    @PersistenceContext(unitName = "libreriaPU")
    private EntityManager entityManager;

    public Libro findById(Long id) {
        return new Libro();
    }

    public List<Libro> findAll() {
        String consulta = "SELECT l FROM Libro l";
        return entityManager.createQuery(consulta).getResultList();
    }
}
