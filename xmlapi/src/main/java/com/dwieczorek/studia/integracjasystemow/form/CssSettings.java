package com.dwieczorek.studia.integracjasystemow.form;

import java.io.Serializable;

/**
 * Created by dawid on 04.01.2017.
 */
public class CssSettings implements Serializable {
    private String backgroundColor;
    private String borderColor;
    private String fontSize;
    private String color;
    private String hoverColor;
    private String backgroundHoverColor;
    private String borderStyle;
    private String borderSize;
    private String textAlign;
    private String fontWeight;

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHoverColor() {
        return hoverColor;
    }

    public void setHoverColor(String hoverColor) {
        this.hoverColor = hoverColor;
    }

    public String getBackgroundHoverColor() {
        return backgroundHoverColor;
    }

    public void setBackgroundHoverColor(String backgroundHoverColor) {
        this.backgroundHoverColor = backgroundHoverColor;
    }

    public String getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(String borderStyle) {
        this.borderStyle = borderStyle;
    }

    public String getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(String borderSize) {
        this.borderSize = borderSize;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    public String getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }
}
