/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcombo.libros.service;

import com.marcombo.libros.entity.Libro;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fcastillo
 */
@ApplicationScoped
public class LibroService {

    @PersistenceContext(unitName = "demoPU")
    private EntityManager em;

    public Libro findById(Long id) {
        return new Libro();
    }
}
