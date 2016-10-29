package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.dao.MockDataDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlApiApplicationTests {

    @Autowired
    MockDataDao mockDataDao;

    @Test
    public void contextLoads() {

    }

}
