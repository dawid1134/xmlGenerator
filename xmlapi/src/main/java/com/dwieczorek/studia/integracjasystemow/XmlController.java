package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.dao.MockDataDao;
import com.dwieczorek.studia.integracjasystemow.dao.dto.MockData;
import com.dwieczorek.studia.integracjasystemow.utils.XmlList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dawid on 29.10.2016.
 */
@Controller
public class XmlController {
    @Autowired
    private MockDataDao mockDataDao;

    @RequestMapping(path = "/selectAllData.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> getAll() throws SQLException {
        List<MockData> sampleData = mockDataDao.getAllData();
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/selectAllIdFirstLastNames.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> getAllIdFirstLastNames() throws SQLException {
        List<MockData> sampleData = mockDataDao.selectAllIdFirstLastName();
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/selectAllFirstLastNames.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> getAllFirstLastNames() throws SQLException {
        List<MockData> sampleData = mockDataDao.selectFirstLastNames();
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/selectAllFilteredByPhone.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> selectAllFilteredByPhone(@RequestParam String phoneNumber) throws SQLException {
        List<MockData> sampleData = mockDataDao.selectAllFilteredByPhone(phoneNumber);
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/selectAllFilteredByFirstName.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> selectAllFilteredByFirstName(@RequestParam String firstName) throws SQLException {
        List<MockData> sampleData = mockDataDao.selectAllFilteredByFirstName(firstName);
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/selectAllDataLimited.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> selectAllDataLimited(@RequestParam Integer limit,
                                           @RequestParam Integer offset) throws SQLException {
        List<MockData> sampleData = mockDataDao.selectAllDataLimited(limit, offset);
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/selectAllFilteredByLastName.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> selectAllFilteredByLastName(@RequestParam String lastName) throws SQLException {
        List<MockData> sampleData = mockDataDao.selectAllFilteredByLastName(lastName);
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/selectAllFilteredByFirstAndLastName.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> selectAllFilteredByFirstAndLastName(@RequestParam String firstName,
                                                          @RequestParam String lastName) throws SQLException {
        List<MockData> sampleData = mockDataDao.selectAllFilteredByFirstAndLastName(firstName, lastName);
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/selectAllFilteredByPhoneLimited.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> selectAllFilteredByPhoneLimited(@RequestParam String phone,
                                                      @RequestParam Integer limit,
                                                      @RequestParam Integer offset) throws SQLException {
        List<MockData> sampleData = mockDataDao.selectAllFilteredByPhoneLimited(phone, limit, offset);
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/selectAllIdFirstLastNameLimited.xml", method = RequestMethod.GET)
    public
    @ResponseBody
    XmlList<MockData> selectAllIdFirstLastNameLimited(@RequestParam Integer limit,
                                                      @RequestParam Integer offset) throws SQLException {
        List<MockData> sampleData = mockDataDao.selectAllIdFirstLastNameLimited(limit, offset);
        XmlList<MockData> xmlList = new XmlList<>(sampleData);
        return xmlList;
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index() throws JAXBException {
        return "index";
    }

    @RequestMapping(path = "/index", method = RequestMethod.POST)
    public String getFile(ModelMap modelMap) throws JAXBException {
        return "index";
    }

    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
    public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {

    }

}
