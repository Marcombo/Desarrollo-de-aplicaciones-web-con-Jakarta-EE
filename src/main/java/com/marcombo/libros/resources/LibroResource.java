package com.marcombo.libros.resources;

import com.marcombo.libros.dto.LibroDTO;
import com.marcombo.libros.entity.Libro;
import com.marcombo.libros.mappers.LibroMapper;
import com.marcombo.libros.service.LibroService;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("libros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LibroResource {

    @Inject
    private LibroService libroService;

    @Inject
    private LibroMapper libroMapper;

    @GET
    public Response findAll() {
        List<Libro> libros = libroService.findAll();
        List<LibroDTO> librosDTO = libroMapper.toListDTO(libros);
        return Response.ok(librosDTO).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        Optional<Libro> libro = libroService.findById(id);
        LibroDTO libroDTO = libroMapper.toDTO(libro.get());
        return Response.ok(libroDTO).build();
    }

    @POST
    public Response create(LibroDTO libroDTO) {
        Libro libro = libroMapper.toEntity(libroDTO);
        libroService.create(libro);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, LibroDTO libroDTO) {

        Optional<Libro> libro = libroService.findById(id);

        if (libro.isPresent()) {

            libro.get().setTitulo(libroDTO.getTitulo());
            libro.get().setDescripcion(libroDTO.getDescripcion());
            libro.get().setEditorial(libroDTO.getEditorial());
            libro.get().setIsbn(libroDTO.getISBN());
            libro.get().setAutor(libroDTO.getAutor());
            libro.get().setPrecio(libroDTO.getPrecio());

            libroService.update(libro.get());

            return Response.ok().build();

        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        libroService.delete(id);
        return Response.ok().build();
    }

}
