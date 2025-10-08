package com.cristinagiraldo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

public class CarritoDeComprasPage extends PageObject {
    /*@FindBy(xpath = "//a[@class='dropdown-toggle mini-cart']")
    WebElementFacade BTN_CART_SHOPPING;

    @FindBy(xpath="(//*[@class='buttons'])[1]")
    WebElementFacade BTN_SEE_SHOPPING_CART;

    @FindBy(xpath= "//h3[@id='order_review_heading']")
    WebElementFacade TXT_PEDIDO;

    public WebElementFacade getBTN_CART_SHOPPING() {
        return BTN_CART_SHOPPING;
    }

    public WebElementFacade getBTN_SEE_SHOPPING_CART() {
        return BTN_SEE_SHOPPING_CART;}*/


    @FindBy(xpath = "//h3[@id='order_review_heading']")
    WebElementFacade TXT_PEDIDO;

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a")
    WebElementFacade BTN_FINALIZAR_COMPRA;

    public WebElementFacade getTXT_PEDIDO() {
        return TXT_PEDIDO;
    }

    public WebElementFacade getBTN_FINALIZAR_COMPRA() {
        return BTN_FINALIZAR_COMPRA;
    }
    public void clickFinalizarCompra() {
        WebElementFacade botonFinalizar = getBTN_FINALIZAR_COMPRA().waitUntilVisible();

        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                botonFinalizar
        );
        botonFinalizar.waitUntilClickable().click();
    }
}
