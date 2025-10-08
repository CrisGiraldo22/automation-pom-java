package com.cristinagiraldo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MensajeAlertaPage extends PageObject {
    @FindBy(xpath = "//div[@role='alert']")
    WebElementFacade MENSAJE_DE_ALERTA;

    public WebElementFacade getMENSAJE_DE_ALERTA() {
        return MENSAJE_DE_ALERTA;
    }
}
