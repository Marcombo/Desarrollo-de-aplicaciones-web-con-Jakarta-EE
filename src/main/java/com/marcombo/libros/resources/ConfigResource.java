package com.marcombo.libros.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.Config;

@Path("/config")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class ConfigResource {

    @Inject
    Config config;

    @GET
    public Response getConfig() {
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("config", Json.createObjectBuilder()
                .add("appName", config.getValue("application.name", String.class))
                .add("username", config.getValue("username", String.class))
                .add("password", config.getValue("password", String.class)));
        return Response.ok(job.build()).build();
    }
}
