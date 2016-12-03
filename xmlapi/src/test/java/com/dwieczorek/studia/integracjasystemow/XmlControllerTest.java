package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.dao.MockDataDao;
import com.dwieczorek.studia.integracjasystemow.service.FileGeneratorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class XmlControllerTest {
    @InjectMocks
    private XmlController xmlController;

    @Mock
    private MockDataDao mockDataDao;

    @Mock
    private FileGeneratorService fileGeneratorService;

    @Test
    public void ContextLoadedTest(){
        String index = xmlController.index();
        Assert.assertEquals("index", index);
    }
}
