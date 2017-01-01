package com.dwieczorek.studia.integracjasystemow.service;

import com.dwieczorek.studia.integracjasystemow.converter.ApiParser;
import com.dwieczorek.studia.integracjasystemow.converter.ServerSupportedType;
import com.dwieczorek.studia.integracjasystemow.converter.parser.XmlApiParser;
import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;
import com.dwieczorek.studia.integracjasystemow.utils.XmlList;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dawid on 01.01.2017.
 */
@Service
public class CssStyledGeneratorService extends ResponseGeneratorService {

    @Override
    protected void generateResponse(HttpServletRequest request, HttpServletResponse response,
                                    ApiParser<XmlList<CustomerData>> apiParser, XmlList<CustomerData> xmlList) {

    }

    @Override
    protected ApiParser<XmlList<CustomerData>> createProperParser(ServerSupportedType type) {
        if (type == ServerSupportedType.XML) {
            return new XmlApiParser<>();
        }
        throw new UnsupportedOperationException("CSS Styled generator service support only XML format.");
    }
}
