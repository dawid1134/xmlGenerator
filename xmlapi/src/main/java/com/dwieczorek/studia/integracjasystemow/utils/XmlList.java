package com.dwieczorek.studia.integracjasystemow.utils;

import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dawid on 29.10.2016.
 */
@XmlRootElement
@XmlSeeAlso(CustomerData.class)
public class XmlList<T> {
    private List<T> listOfEntityObjects;

    public XmlList() {
        listOfEntityObjects = new ArrayList<T>();
    }

    public XmlList(List<T> listOfEntityObjects) {
        this.listOfEntityObjects = listOfEntityObjects;
    }

    @XmlAnyElement
    public List<T> getItems() {
        return listOfEntityObjects;
    }
}
