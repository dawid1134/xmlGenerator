package com.dwieczorek.studia.integracjasystemow.service;

import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.dwieczorek.studia.integracjasystemow.converter.ServerSupportedType;
import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;
import com.dwieczorek.studia.integracjasystemow.utils.XmlList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dawid on 01.01.2017.
 */
public abstract class ResponseGeneratorService {
    public static final String SESSION_TYPE = "TYPE";

    public void prepareResponse(HttpServletRequest request, HttpServletResponse response, XmlList<CustomerData> xmlList) {
        ServerSupportedType type = getServerTypeFromRequest(request);
        ApiParser<XmlList<CustomerData>> apiParser = createProperParser(type);
        generateResponse(request, response, apiParser, xmlList);
    }

    protected abstract void generateResponse(HttpServletRequest request, HttpServletResponse response,
                                             ApiParser<XmlList<CustomerData>> apiParser, XmlList<CustomerData> xmlList);

    protected abstract ApiParser<XmlList<CustomerData>> createProperParser(ServerSupportedType type);

    private ServerSupportedType getServerTypeFromRequest(HttpServletRequest request) {
        ServerSupportedType type = (ServerSupportedType) request.getSession().getAttribute(SESSION_TYPE);
        if (type == null)
            type = ServerSupportedType.XML;
        return type;
    }
}
