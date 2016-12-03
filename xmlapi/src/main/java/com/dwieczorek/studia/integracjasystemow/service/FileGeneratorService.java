package com.dwieczorek.studia.integracjasystemow.service;

import com.dwieczorek.studia.integracjasystemow.converter.ServerSupportedType;
import com.dwieczorek.studia.integracjasystemow.converter.parser.OgdlApiParser;
import com.dwieczorek.studia.integracjasystemow.converter.parser.XmlApiParser;
import com.dwieczorek.studia.integracjasystemow.converter.parser.YamlApiParser;
import com.dwieczorek.studia.integracjasystemow.dao.dto.MockData;
import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.dwieczorek.studia.integracjasystemow.converter.parser.JsonApiParser;
import com.dwieczorek.studia.integracjasystemow.utils.XmlList;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wiecz on 03.12.2016.
 */
@Service
public class FileGeneratorService {
    private static final Integer DEFAULT_BUFFER_SIZE = 1024;
    public static final String SESSION_TYPE = "TYPE";

    public void prepareResponse(HttpServletRequest request, HttpServletResponse response, XmlList<MockData> xmlList) {
        ServerSupportedType type = (ServerSupportedType)request.getSession().getAttribute(SESSION_TYPE);
        if (type == null)
            type = ServerSupportedType.XML;
        ApiParser<XmlList<MockData>> apiParser = createProperParser(type);
        generateResponseWithFile(request, response, apiParser, xmlList);
    }

    private void generateResponseWithFile(HttpServletRequest request, HttpServletResponse response,
                                          ApiParser<XmlList<MockData>> apiParser, XmlList<MockData> xmlList) {
        response.reset();
        response.setBufferSize(DEFAULT_BUFFER_SIZE);
        setProperMetadata(request, response, apiParser);
        String parse = apiParser.parse(xmlList);
        try {
            response.getOutputStream().write(parse.getBytes());
        } catch (IOException e) {
            // Do something
        }
    }

    private ApiParser<XmlList<MockData>> createProperParser(ServerSupportedType type) {
        ApiParser<XmlList<MockData>> apiParser;
        switch (type){
            case JSON:
                apiParser = new JsonApiParser<>();
                break;
            case XML:
                apiParser = new XmlApiParser<>();
                break;
            case YAML:
                apiParser = new YamlApiParser<>();
                break;
            case OGDL:
                apiParser = new OgdlApiParser<>();
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return apiParser;
    }

    private void setProperMetadata(HttpServletRequest request, HttpServletResponse response,
                                   ApiParser<XmlList<MockData>> apiParser) {
        response.setContentType(apiParser.getContentType());
        response.addHeader("Content-Disposition", "attachment; filename="+ request.getServletPath()
                .substring(1,request.getServletPath().length())
                + apiParser.getFormat());
    }

}
