package com.exam.ifg.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MapperUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T jsonToObject(String json, Class<T> objectClass) throws JsonProcessingException {
        return objectMapper.readValue(json, objectClass);
    }

    public static <T> String objectToJson(T object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
