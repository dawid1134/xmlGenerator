package com.dwieczorek.studia.integracjasystemow.service;

import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.dwieczorek.studia.integracjasystemow.converter.ServerSupportedType;
import com.dwieczorek.studia.integracjasystemow.converter.parser.XmlApiParser;
import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;
import com.dwieczorek.studia.integracjasystemow.form.CssSettings;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by dawid on 01.01.2017.
 */
@Service
public class CssStyledGeneratorService extends ResponseGeneratorService {
    private static final String XMLLIST = "XML_LIST";

    public HttpEntity<byte[]> getResult(HttpServletRequest request) {
        String attribute = (String) request.getSession().getAttribute(XMLLIST);
        return prepareXmlFile(attribute);
    }

    private HttpEntity<byte[]> prepareXmlFile(String attribute) {
        byte[] documentBody = attribute.getBytes(Charset.forName("utf-8"));
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "xml"));
        header.setContentLength(documentBody.length);
        return new HttpEntity<>(documentBody, header);
    }

    @Override
    protected void generateResponse(HttpServletRequest request, HttpServletResponse response,
                                    ApiParser<List<CustomerData>> apiParser, List<CustomerData> xmlList) {
        String result = apiParser.parse(xmlList);
        response.setContentType("text/plain");
        request.getSession().setAttribute(XMLLIST, result);
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader("Location", "xmlConfiguration");
    }

    @Override
    protected ApiParser<List<CustomerData>> createProperParser(ServerSupportedType type) {
        if (type == ServerSupportedType.XML) {
            return new XmlApiParser<>();
        }
        throw new UnsupportedOperationException("CSS Styled generator service support only XML format.");
    }

    public String prepareCss(CssSettings cssSettings) {
        return "ArrayList {\n" +
                "    background-color: #ffffff;\n" +
                "    width: 90%;\n" +
                "    display: table;\n" +
                "    margin: auto;" +
                "}\n" +
                "item {\n" +
                "    display: table-row;\n" +
                "    margin-left: 0;\n" +
                "    border: blue;\n" +
                "    padding: 10px;\n" +
                "    background: " + cssSettings.getBackgroundColor() + ";\n" +
                "    color: " + cssSettings.getColor() + ";\n" +
                "    text-align: " + cssSettings.getTextAlign() + "\n;" +
                "}\n" +
                "\n" +
                "id, firstName, lastName, email, gender, ipAddress, appName, bitcoinAddress, city, country, domain, hexColor, phone, time, title{\n" +
                "    display: table-cell;\n" +
                "    border: 1px;\n" +
                "    border-style: " + cssSettings.getBorderStyle() + ";\n" +
                "    border-width: " + cssSettings.getBorderWidth() + "px;\n" +
                "    border-color: " + cssSettings.getBorderColor() + ";\n" +
                "    font-size: " + cssSettings.getFontSize() + "px;\n" +
                "    font-weight: " + cssSettings.getFontWeight() + ";\n" +
                "}\n" +
                "\n" +
                "item:hover {\n" +
                "    color: " + cssSettings.getHoverColor() + ";\n" +
                "    background:" + cssSettings.getBackgroundHoverColor() + ";\n" +
                "}";
    }
}
