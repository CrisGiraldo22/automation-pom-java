package com.cristinagiraldo.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

public class CarritoDeComprasPage extends PageObject {
    @FindBy(xpath = "//h3[@id='order_review_heading']")
    WebElementFacade TXT_PEDIDO;

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a")
    WebElementFacade BTN_FINALIZAR_COMPRA;

    @FindBy(xpath = "//input[@class='btn btn-default']")
    WebElementFacade BTN_ACTUALIZAR_COMPRA;

    @FindBy(xpath = "//table[@class='shop_table shop_table_responsive']")
    WebElementFacade TBL_TOTAL_Y_SUBTOTAL;


    @FindBy(xpath = "//button[@class='button alt']")
    WebElementFacade BTN_REALIZAR_PEDIDO;

    public WebElementFacade getTXT_PEDIDO() {
        return TXT_PEDIDO;
    }

    public WebElementFacade getBTN_FINALIZAR_COMPRA() {
        return BTN_FINALIZAR_COMPRA;
    }
    public WebElementFacade getBTN_ACTUALIZAR_COMPRA() {
        return BTN_ACTUALIZAR_COMPRA;
    }
    public WebElementFacade getTBL_TOTAL_Y_SUBTOTAL() {
        return TBL_TOTAL_Y_SUBTOTAL;
    }

    public WebElementFacade getBTN_REALIZAR_PEDIDO() {
        return BTN_REALIZAR_PEDIDO;
    }

    public void clickFinalizarCompra() {
        WebElementFacade botonFinalizar = getBTN_FINALIZAR_COMPRA().waitUntilVisible();

        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                botonFinalizar
        );
        botonFinalizar.waitUntilClickable().click();
    }
    public void clickRealizarPedido() {
        WebElementFacade botonPedido = getBTN_REALIZAR_PEDIDO().waitUntilVisible();
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                botonPedido
        );

        botonPedido.waitUntilClickable().click();
    }
}
