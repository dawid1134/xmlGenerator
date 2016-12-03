package com.dwieczorek.studia.integracjasystemow.converter.parser;

import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Created by wiecz on 03.12.2016.
 */
public class XmlApiParser<T> implements ApiParser<T> {
    @Override
    public String parse(T objectToParse) {
        ObjectMapper objectMapper = new XmlMapper();
        try {
            return objectMapper.writeValueAsString(objectToParse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String getContentType() {
        return "text/xml";
    }

    @Override
    public String getFormat() {
        return ".xml";
    }
}
