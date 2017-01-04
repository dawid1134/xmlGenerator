package com.dwieczorek.studia.integracjasystemow;

import com.dwieczorek.studia.integracjasystemow.form.CssSettings;
import com.dwieczorek.studia.integracjasystemow.service.CssStyledGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by dawid on 01.01.2017.
 */
@Controller
public class XmlSettingsController {
    public static final String CSS_SETTINGS = "cssSettings";
    @Autowired
    public CssStyledGeneratorService cssStyledGeneratorService;

    @RequestMapping(value = "/xmlConfiguration", method = RequestMethod.GET)
    public String xmlConfiguration() {
        return "xmlSettings";
    }

    @RequestMapping(value = "/xmlConfiguration", method = RequestMethod.POST)
    public String showXml(HttpServletRequest servletRequest, @ModelAttribute CssSettings cssSettings) {
        HttpSession session = servletRequest.getSession();
        session.setAttribute("cssSettings", cssSettings);
        return "redirect:styled.xml";
    }

    @RequestMapping(value = "/styled.xml", method = RequestMethod.GET)
    @ResponseBody
    public Object getResultAsXml(HttpServletRequest request) {
        return cssStyledGeneratorService.getResult(request);
    }

    @RequestMapping(value = "/style.css", method = RequestMethod.GET)
    @ResponseBody
    public String xmlStyle(HttpSession session) {
        CssSettings cssSettings = (CssSettings) session.getAttribute(CSS_SETTINGS);
        return cssStyledGeneratorService.prepareCss(cssSettings);
    }
}
