package com.bookLibrary.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface MapperService {

    public String toJson(Object object) throws IOException;

    public <T> T fromJson(String json, Class<T> clas) throws JsonParseException, JsonMappingException, IOException;
}
