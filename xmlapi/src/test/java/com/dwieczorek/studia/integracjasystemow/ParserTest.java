package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.converter.ServerSupportedType;
import com.dwieczorek.studia.integracjasystemow.dao.MockDataDao;
import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;
import com.dwieczorek.studia.integracjasystemow.service.FileGeneratorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wiecz on 03.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ParserTest {
    @InjectMocks
    private XmlController xmlController;

    @Spy
    private FileGeneratorService fileGeneratorService;

    @Spy
    private MockDataDao mockDataDao;

    @Spy
    private MockHttpServletRequest servletRequest;

    @Spy
    private MockHttpServletResponse servletResponse;

    @Before
    public void initializeRequest(){
        servletRequest.setServletPath("mockedfile");
    }

    @Test
    public void hasProperMetadataTestXml() throws SQLException {
        //Arrange
        CustomerData customerData = Mockito.mock(CustomerData.class);
        List<CustomerData> customerDatas = new ArrayList<>();
        customerDatas.add(customerData);
        servletRequest.getSession().setAttribute(FileGeneratorService.SESSION_TYPE, ServerSupportedType.XML);
        Mockito.doReturn(customerDatas).when(mockDataDao).getAllData();

        //Act
        xmlController.getAll(servletRequest,servletResponse);
        String contentType = servletResponse.getContentType();

        //Assert
        Assert.assertEquals("text/xml", contentType);
    }

    @Test
    public void hasProperMetadataTestJson() throws SQLException {
        //Arrange
        CustomerData customerData = Mockito.mock(CustomerData.class);
        List<CustomerData> customerDatas = new ArrayList<>();
        customerDatas.add(customerData);
        servletRequest.getSession().setAttribute(FileGeneratorService.SESSION_TYPE, ServerSupportedType.JSON);
        Mockito.doReturn(customerDatas).when(mockDataDao).getAllData();

        //Act
        xmlController.getAll(servletRequest,servletResponse);
        String contentType = servletResponse.getContentType();

        //Assert
        Assert.assertEquals("text/json", contentType);
    }

    @Test
    public void hasProperMetadataTestYaml() throws SQLException {
        //Arrange
        CustomerData customerData = Mockito.mock(CustomerData.class);
        List<CustomerData> customerDatas = new ArrayList<>();
        customerDatas.add(customerData);
        servletRequest.getSession().setAttribute(FileGeneratorService.SESSION_TYPE, ServerSupportedType.YAML);
        Mockito.doReturn(customerDatas).when(mockDataDao).getAllData();

        //Act
        xmlController.getAll(servletRequest,servletResponse);
        String contentType = servletResponse.getContentType();

        //Assert
        Assert.assertEquals("text/yaml", contentType);
    }

    @Test
    public void hasProperMetadataTestOgdl() throws SQLException {
        //Arrange
        CustomerData customerData = Mockito.mock(CustomerData.class);
        List<CustomerData> customerDatas = new ArrayList<>();
        customerDatas.add(customerData);
        servletRequest.getSession().setAttribute(FileGeneratorService.SESSION_TYPE, ServerSupportedType.OGDL);
        Mockito.doReturn(customerDatas).when(mockDataDao).getAllData();

        //Act
        xmlController.getAll(servletRequest,servletResponse);
        String contentType = servletResponse.getContentType();

        //Assert
        Assert.assertEquals("text/ogdl", contentType);
    }
}
