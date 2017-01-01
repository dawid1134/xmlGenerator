package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.annotation.RateLimit;
import com.dwieczorek.studia.integracjasystemow.converter.ServerSupportedType;
import com.dwieczorek.studia.integracjasystemow.dao.MockDataDao;
import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;
import com.dwieczorek.studia.integracjasystemow.service.CssStyledGeneratorService;
import com.dwieczorek.studia.integracjasystemow.service.FileGeneratorService;
import com.dwieczorek.studia.integracjasystemow.service.ResponseGeneratorService;
import com.dwieczorek.studia.integracjasystemow.utils.XmlList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dawid on 29.10.2016.
 */
@Controller
public class XmlController {
    @Autowired
    private MockDataDao mockDataDao;

    @Autowired
    private ApplicationContext context;

    private ResponseGeneratorService responseGeneratorService;

    @PostConstruct
    public void postConstruct() {
        responseGeneratorService = context.getBean(CssStyledGeneratorService.class);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllData", method = RequestMethod.GET)
    @ResponseBody
    public void getAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.getAllData();
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllIdFirstLastNames", method = RequestMethod.GET)
    @ResponseBody
    public void getAllIdFirstLastNames(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.selectAllIdFirstLastName();
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllFirstLastNames", method = RequestMethod.GET)
    @ResponseBody
    public void getAllFirstLastNames(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.selectFirstLastNames();
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllFilteredByPhone", method = RequestMethod.GET)
    @ResponseBody
    public void selectAllFilteredByPhone(@RequestParam String phoneNumber, HttpServletRequest request,
                                         HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.selectAllFilteredByPhone(phoneNumber);
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllFilteredByFirstName", method = RequestMethod.GET)
    @ResponseBody
    public void selectAllFilteredByFirstName(@RequestParam String firstName, HttpServletRequest request,
                                             HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.selectAllFilteredByFirstName(firstName);
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllDataLimited", method = RequestMethod.GET)
    @ResponseBody
    public void selectAllDataLimited(@RequestParam Integer limit,
                                     @RequestParam Integer offset, HttpServletRequest request,
                                     HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.selectAllDataLimited(limit, offset);
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllFilteredByLastName", method = RequestMethod.GET)
    @ResponseBody
    public void selectAllFilteredByLastName(@RequestParam String lastName, HttpServletRequest request,
                                            HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.selectAllFilteredByLastName(lastName);
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllFilteredByFirstAndLastName", method = RequestMethod.GET)
    @ResponseBody
    public void selectAllFilteredByFirstAndLastName(@RequestParam String firstName,
                                                    @RequestParam String lastName,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.selectAllFilteredByFirstAndLastName(firstName, lastName);
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllFilteredByPhoneLimited", method = RequestMethod.GET)
    @ResponseBody
    public void selectAllFilteredByPhoneLimited(@RequestParam String phone,
                                                @RequestParam Integer limit,
                                                @RequestParam Integer offset,
                                                HttpServletRequest request,
                                                HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.selectAllFilteredByPhoneLimited(phone, limit, offset);
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    @RequestMapping(path = "/selectAllIdFirstLastNameLimited", method = RequestMethod.GET)
    @ResponseBody
    public void selectAllIdFirstLastNameLimited(@RequestParam Integer limit,
                                                @RequestParam Integer offset,
                                                HttpServletRequest request,
                                                HttpServletResponse response) throws SQLException {
        List<CustomerData> sampleData = mockDataDao.selectAllIdFirstLastNameLimited(limit, offset);
        XmlList<CustomerData> xmlList = new XmlList<>(sampleData);
        responseGeneratorService.prepareResponse(request, response, xmlList);
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/index", method = RequestMethod.POST)
    public String getFile() {
        return "index";
    }

    @RequestMapping(path = "/setType", method = RequestMethod.GET)
    public void setType(@RequestParam String type, HttpSession session){
        ServerSupportedType serverSupportedType = ServerSupportedType.valueOf(type);
        session.setAttribute(FileGeneratorService.SESSION_TYPE, serverSupportedType);
        fillGeneratorService(serverSupportedType);
    }

    private void fillGeneratorService(ServerSupportedType serverSupportedType) {
        if (serverSupportedType == ServerSupportedType.XML) {
            responseGeneratorService = context.getBean(CssStyledGeneratorService.class);
        } else {
            responseGeneratorService = context.getBean(FileGeneratorService.class);
        }
    }
}
