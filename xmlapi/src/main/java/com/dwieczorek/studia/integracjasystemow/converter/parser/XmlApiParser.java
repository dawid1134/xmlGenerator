package com.dwieczorek.studia.integracjasystemow.converter.parser;

import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Optional;

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
            stringBuffer.append("<items>");
            stringBuffer.append(objectMapper.writeValueAsString(objectToParse));
            insertXmlItemsHeaders(objectToParse, stringBuffer);
            stringBuffer.append("</items>");
            return stringBuffer.toString();
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private void insertXmlItemsHeaders(T objectToParse, StringBuilder stringBuilder) {
        String arrayListTag = "<ArrayList>";
        int indexOf = stringBuilder.indexOf(arrayListTag);
        if (indexOf > 0) {
            StringBuilder headerStringBuilder = new StringBuilder();
            prepareXmlItemHeaders(headerStringBuilder, objectToParse);
            stringBuilder.insert(indexOf + arrayListTag.length(), headerStringBuilder);
        }
    }

    private void prepareXmlHeader(StringBuilder stringBuffer) {
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("<?xml-stylesheet type=\"text/css\" href=\"style.css\"?>");
        stringBuffer.append(System.getProperty("line.separator"));
    }

    private void prepareXmlItemHeaders(StringBuilder stringBuilder, Object object) {
        stringBuilder.append("<headers>");
        appendFieldsHeaders(stringBuilder, object);
        stringBuilder.append("</headers>");
    }

    private void appendFieldsHeaders(StringBuilder stringBuilder, Object object) {
        Object properObject = getProperClass(object);
        Class<?> clazz = properObject.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            appendFieldHeader(stringBuilder, properObject, field);
        }
    }

    private Object getProperClass(Object object) {
        Object clazz;
        if (object instanceof Collection) {
            Collection object1 = (Collection) object;
            Optional first = object1.stream().findFirst();
            clazz = first.get();
        } else {
            clazz = object;
        }
        return clazz;
    }

    private void appendFieldHeader(StringBuilder stringBuilder, Object object, Field field) {
        try {
            field.setAccessible(true);
            if (field.get(object) != null) {
                stringBuilder.append("<header>");
                stringBuilder.append(field.getName());
                stringBuilder.append("</header>");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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
