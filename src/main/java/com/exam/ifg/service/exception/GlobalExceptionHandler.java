package com.exam.ifg.service.exception;

import com.exam.ifg.service.dto.GlobalErrorResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.log4j.Log4j;

import java.util.logging.Logger;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {

        if (exception instanceof IllegalArgumentException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new GlobalErrorResponse("Bad Request", exception.getMessage()))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } else if (exception instanceof NullPointerException) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new GlobalErrorResponse("Internal Server Error", "Null pointer exception occurred"))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        return  Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new GlobalErrorResponse("Internal Server Error", exception.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
