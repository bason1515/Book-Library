package com.bookLibrary.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JacksonMapperService implements MapperService{
    
    @Autowired
    private ObjectMapper objectMapper;

    public JacksonMapperService(ObjectMapper objectMapper) {
        super();
        this.objectMapper = objectMapper;
    }
    
    @Override
    public String toJson(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    @Override
    public <T> T fromJson(String json, Class<T> clas) throws JsonParseException, JsonMappingException, IOException {
        return objectMapper.readValue(json, clas);
    }

}
