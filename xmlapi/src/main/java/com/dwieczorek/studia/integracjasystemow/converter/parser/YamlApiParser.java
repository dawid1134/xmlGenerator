package com.dwieczorek.studia.integracjasystemow.converter.parser;

import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

/**
 * Created by wiecz on 03.12.2016.
 */
public class YamlApiParser<T> implements ApiParser<T> {

    @Override
    public String parse(T objectToParse) {
        ObjectMapper objectMapper = new YAMLMapper();
        try {
            return objectMapper.writeValueAsString(objectToParse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ".yml";
        }
    }

    @Override
    public String getContentType() {
        return "text/yaml";
    }

    @Override
    public String getFormat() {
        return ".yml";
    }
}
