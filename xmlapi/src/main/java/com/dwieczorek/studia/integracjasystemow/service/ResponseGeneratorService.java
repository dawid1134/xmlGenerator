package com.dwieczorek.studia.integracjasystemow.service;

import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.dwieczorek.studia.integracjasystemow.converter.ServerSupportedType;
import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;
import com.dwieczorek.studia.integracjasystemow.utils.XmlList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by dawid on 01.01.2017.
 */
public abstract class ResponseGeneratorService {
    public static final String SESSION_TYPE = "TYPE";

    public void prepareResponse(HttpServletRequest request, HttpServletResponse response, List<CustomerData> xmlList) {
        ServerSupportedType type = getServerTypeFromRequest(request);
        ApiParser<List<CustomerData>> apiParser = createProperParser(type);
        generateResponse(request, response, apiParser, xmlList);
    }

    protected abstract void generateResponse(HttpServletRequest request, HttpServletResponse response,
                                             ApiParser<List<CustomerData>> apiParser, List<CustomerData> xmlList);

    protected abstract ApiParser<List<CustomerData>> createProperParser(ServerSupportedType type);

    private ServerSupportedType getServerTypeFromRequest(HttpServletRequest request) {
        ServerSupportedType type = (ServerSupportedType) request.getSession().getAttribute(SESSION_TYPE);
        if (type == null)
            type = ServerSupportedType.XML;
        return type;
    }
}
