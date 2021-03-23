
package com.marcombo.libros.resources;

import com.marcombo.libros.service.LibroService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

    @GET
    public Response getAll() {
        return Response.ok(libroService.findAll()).build();
    }

}
