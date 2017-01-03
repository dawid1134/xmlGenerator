package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by dawid on 29.10.2016.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    private Environment environment;
    @Bean
    public Marshaller createMarshaller() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(CustomerData.class);
        return jc.createMarshaller();
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        String jedisIp = environment.getProperty("jedis.ipaddress");
        jedisConFactory.setHostName(jedisIp);
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }
}
