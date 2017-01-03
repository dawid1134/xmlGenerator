package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.service.CssStyledGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dawid on 01.01.2017.
 */
@Controller
public class XmlSettingsController {
    @Autowired
    public CssStyledGeneratorService cssStyledGeneratorService;

    @RequestMapping(value = "/xmlConfiguration", method = RequestMethod.GET)
    public String xmlConfiguration() {
        return "xmlSettings";
    }

    @RequestMapping(value = "/xmlConfiguration", method = RequestMethod.POST)
    public String showXml() {
        return "redirect:styled.xml";
    }

    @RequestMapping(value = "/styled.xml", method = RequestMethod.GET)
    @ResponseBody
    public Object getResultAsXml(HttpServletRequest request, HttpServletResponse response) {

        return cssStyledGeneratorService.getResult(request, response);
    }

    @RequestMapping(value = "/style.css", method = RequestMethod.GET)
    @ResponseBody
    public String xmlStyle() {
        return cssStyledGeneratorService.prepareCss();
    }
}
