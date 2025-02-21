package com.exam.ifg.service.exception;

import com.exam.ifg.service.dto.GlobalErrorResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        return  Response.status(Response.Status.BAD_REQUEST)
                .entity(new GlobalErrorResponse("Json body is not valid", e.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
