package com.dwieczorek.studia.integracjasystemow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dawid on 01.01.2017.
 */
@Controller
public class XmlSettingsController {

    @RequestMapping(value = "/xmlConfiguration", method = RequestMethod.GET)
    public String xmlConfiguration() {
        return "xmlSettings";
    }
}
