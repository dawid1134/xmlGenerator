package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.dao.dto.MockData;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

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

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName("13.93.87.189");
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }
}
