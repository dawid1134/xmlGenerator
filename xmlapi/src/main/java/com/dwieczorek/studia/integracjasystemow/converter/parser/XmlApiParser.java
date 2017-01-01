package com.dwieczorek.studia.integracjasystemow.converter.parser;

import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Created by wiecz on 03.12.2016.
 */
public class XmlApiParser<T> implements ApiParser<T> {
    @Override
    public String parse(T objectToParse) {
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            StringBuilder stringBuffer = new StringBuilder();
            prepareXmlHeader(stringBuffer);
            stringBuffer.append(objectMapper.writeValueAsString(objectToParse));
            return stringBuffer.toString();
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private void prepareXmlHeader(StringBuilder stringBuffer) {
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("<?xml-stylesheet type=\"text/css\" href=\"style.css\"?>");
        stringBuffer.append(System.getProperty("line.separator"));
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
