package com.cristinagiraldo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class AgrgarProductoCarritoPage extends PageObject {
    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElementFacade BTN_ADD_TO_CART;

    @FindBy(xpath = "//input[@class='plus']")
    WebElementFacade BTN_PlUS_VALUE;
    @FindBy(xpath = "//input[@class='input-text qty text']")
    WebElementFacade TXT_QUANTITY_FIELD;
    public By getCategoriaSelector(String categoria) {
        return By.xpath(String.format("//li[@id='menu-item-2805']/a[text()='%s']", categoria));
    }
    public By getProductoSelector(String producto) {
        return By.xpath(String.format("//a[@title='%s']", producto));
    }
    public By getNombreProductoSelector(String nombreProducto){
        return By.xpath(String.format("//td[@class='product-name']//a",nombreProducto));
    }


    public WebElementFacade categoria(String categoria) {
        return find(getCategoriaSelector(categoria));
    }
    public WebElementFacade producto(String producto) {
        return find(getProductoSelector(producto));
    }
    public WebElementFacade getBTN_ADD_TO_CART() {
        return BTN_ADD_TO_CART;
    }
    public WebElementFacade getBTN_PlUS_VALUE() {
        return BTN_PlUS_VALUE;
    }
    public WebElementFacade getTXT_QUANTITY_FIELD() {
        return TXT_QUANTITY_FIELD;
    }

    public void clickPlusButton(String cantidad) {
        int veces = Integer.parseInt(cantidad);
        WebElementFacade plusButton = getBTN_PlUS_VALUE().waitUntilClickable();
        int clicksAdd = veces - 1;
        for (int i = 0; i < clicksAdd; i++) {
            plusButton.click();
        }
    }


    public void clickAddToCartButton() {
        WebElementFacade botonCarrito = getBTN_ADD_TO_CART().waitUntilVisible();

        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                botonCarrito
        );
        botonCarrito.waitUntilClickable().click();
    }

}