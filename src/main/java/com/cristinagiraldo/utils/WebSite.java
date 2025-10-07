package com.cristinagiraldo.utils;


import net.serenitybdd.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class WebSite extends PageObject{

    @Step("navegar al sitio web")
    public void navegarA(String url){
        this.setDefaultBaseUrl(url);
        this.open();
    }
}
