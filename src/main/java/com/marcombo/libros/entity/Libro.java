package com.marcombo.libros.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Libros")
@Getter
@Setter
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LibroID")
    private Long libroId;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Isbn")
    private String isbn;

    @Column(name = "Editorial")
    private String editorial;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "Precio")
    private BigDecimal precio;

}
