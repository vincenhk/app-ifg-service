package com.exam.ifg.service.resource;

import com.exam.ifg.service.common.Constant;
import com.exam.ifg.service.dto.GlobalSuccessResponseDto;
import com.exam.ifg.service.dto.request.TransactionRequestDto;
import com.exam.ifg.service.service.TransactionService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.text.ParseException;

@Path("/transaction-test")
@Consumes(MediaType.APPLICATION_JSON)  // Semua method menerima JSON
@Produces(MediaType.APPLICATION_JSON)  // Semua method mengembalikan JSON
public class TransactionResource {

    @Inject
    private TransactionService transactionService;

    @GET
    @Path("/big-bang")
    public Response transactionProcess(@Valid TransactionRequestDto requestDto) throws ParseException {
        return Response.status(Response.Status.OK)
                .entity(new GlobalSuccessResponseDto<>(Constant.SUCCESS_STATUS, transactionService.transactionProcess(requestDto)))
                .build();
    }
}
