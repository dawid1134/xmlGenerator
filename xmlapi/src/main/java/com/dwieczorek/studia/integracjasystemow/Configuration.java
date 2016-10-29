package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.dao.dto.MockData;
import org.springframework.context.annotation.Bean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by dawid on 29.10.2016.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Marshaller createMarshaller() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(MockData.class);
        return jc.createMarshaller();
    }
}
