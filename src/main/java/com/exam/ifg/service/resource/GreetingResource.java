package com.exam.ifg.service.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/greeting")
@Consumes(MediaType.APPLICATION_JSON)  // Semua method menerima JSON
@Produces(MediaType.APPLICATION_JSON)  // Semua method mengembalikan JSON
public class GreetingResource {

    @GET
//    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
