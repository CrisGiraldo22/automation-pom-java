package com.cristinagiraldo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class AgrgarProductoCarritoPage extends PageObject {
    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElementFacade BTN_ADD_TO_CART;
    public By getCategoriaSelector(String categoria) {
        return By.xpath(String.format("//li[@id='menu-item-2805']/a[text()='%s']", categoria));
    }
    public By getProductoSelector(String producto) {
        return By.xpath(String.format("//a[@title='%s']", producto));
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
    public void clickAddToCartButton() {
        WebElementFacade botonCarrito = getBTN_ADD_TO_CART().waitUntilVisible();

        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                botonCarrito
        );
        botonCarrito.waitUntilClickable().click();
    }
}