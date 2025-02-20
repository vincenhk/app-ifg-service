package com.exam.ifg.service.dto;

import com.exam.ifg.service.common.Constant;
import lombok.Data;

@Data
public class GlobalSuccessResponseDto<T>{
    private String status;
    private int code;
    private String message;
    private T data;

    public GlobalSuccessResponseDto(String status, int code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public GlobalSuccessResponseDto(String status, String message) {
        this.status = status;
        this.code = Constant.OK;
        this.message = message;
    }

    public GlobalSuccessResponseDto(String status, T data) {
        this.status = status;
        this.code = Constant.OK;
        this.data = data;
    }
}
