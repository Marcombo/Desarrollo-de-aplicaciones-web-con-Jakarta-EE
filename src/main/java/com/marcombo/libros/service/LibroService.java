package com.marcombo.libros.service;

import com.marcombo.libros.entity.Libro;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class LibroService {
    
    @PersistenceContext(unitName = "libreriaPU")
    private EntityManager entityManager;
    
    @Transactional
    public Libro create(Libro libro) {
        entityManager.persist(libro);
        return libro;
    }
    
    @Transactional
    public void update(Libro libro) {
        entityManager.merge(libro);
    }
    
    @Transactional
    public void delete(Long id) {
        findById(id).ifPresent(libro -> entityManager.remove(libro));
    }
    
    public Optional<Libro> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Libro.class, id));
    }
    
    public List<Libro> findAll() {
        String consulta = "SELECT l FROM Libro l";
        return entityManager.createQuery(consulta).getResultList();
    }
}
