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
public class CssStyledGeneratorService extends ResponseGeneratorService {

    @Override
    protected void generateResponse(HttpServletRequest request, HttpServletResponse response, ApiParser<XmlList<CustomerData>> apiParser, XmlList<CustomerData> xmlList) {

    }

    @Override
    protected ApiParser<XmlList<CustomerData>> createProperParser(ServerSupportedType type) {
        return null;
    }
}
