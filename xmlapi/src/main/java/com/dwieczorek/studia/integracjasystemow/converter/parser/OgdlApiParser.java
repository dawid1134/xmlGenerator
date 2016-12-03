package com.dwieczorek.studia.integracjasystemow.converter.parser;

import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;
import com.dwieczorek.studia.integracjasystemow.utils.XmlList;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * Created by wiecz on 03.12.2016.
 */
public class OgdlApiParser<T> implements ApiParser<T>{

    @Override
    public String parse(T objectToParse) {
        if(objectToParse instanceof XmlList){
            XmlList<CustomerData> objectToParse1 = (XmlList<CustomerData>) objectToParse;
            return parseCollection(objectToParse1.getItems());
        }
        else {
            return "";
        }
    }

    @Override
    public String getContentType() {
        return "text/ogdl";
    }

    @Override
    public String getFormat() {
        return ".ogdl";
    }

    private String parseCollection(Collection collection) {
        StringBuilder builder = new StringBuilder();
        for (Object o : collection) {
            builder.append(objectToOgdl(o));
            builder.append("\n");
        }
        return builder.toString();
    }

    private String objectToOgdl(Object object) {
        StringBuilder builder = new StringBuilder();
        builder.append(object.getClass().getSimpleName() + "\n");
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            PropertyDescriptor[] descriptors = Introspector.getBeanInfo(object.getClass()).getPropertyDescriptors();
            writeFields(object, builder, fields, descriptors);
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private void writeFields(Object o, StringBuilder builder, Field[] fields, PropertyDescriptor[] pds) throws IllegalAccessException, InvocationTargetException {
        for (Field field : fields) {
            for (PropertyDescriptor pd : pds) {
                if (pd.getReadMethod() != null && pd.getName().equals(field.getName())) {
                    builder.append("\t");
                    if(field.getType().getSimpleName().equals("String")){
                        builder.append(field.getName() + " \"" + pd.getReadMethod().invoke(o)+"\"");
                    }
                    else{
                        builder.append(field.getName() + " " + pd.getReadMethod().invoke(o));
                    }
                    builder.append("\n");
                }
            }
        }
    }
}
