package com.dwieczorek.studia.integracjasystemow.form;

import java.io.Serializable;

/**
 * Created by dawid on 04.01.2017.
 */
public class CssSettings implements Serializable {
    private String backgroundColor;

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
