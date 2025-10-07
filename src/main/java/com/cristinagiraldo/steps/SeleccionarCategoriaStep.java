package com.cristinagiraldo.steps;


import com.cristinagiraldo.pages.AgrgarProductoCarritoPage;
import com.cristinagiraldo.utils.WebSite;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;


public class SeleccionarCategoriaStep {

    @Page
    public AgrgarProductoCarritoPage agrgarProductoCarritoPage;
    @Page
    WebSite webSite;

    public void paginaPrincipalMundoFlor() {
        webSite.navegarA("https://www.floristeriamundoflor.com/");
    }

    private void scrollPage() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 400)");
    }

    @Step("que el usuario se encuentra en la pagina principal navega a la categoria {0}")
    public void selectCategoria(String categoria) {
        WebElementFacade elementoCategoria = agrgarProductoCarritoPage.categoria(categoria);
        if (!elementoCategoria.isVisible()) {
            scrollPage();
        }
        elementoCategoria.waitUntilClickable().click();
    }

    @Step("Cuando el usuario selecciona el producto {0} y lo agrega al carrito")
    public void  selectCodigoProducto(String producto) {
        WebElementFacade elementoProducto = agrgarProductoCarritoPage.producto(producto);
        if (!elementoProducto.isVisible()) {
            scrollPage();
        }

        elementoProducto.waitUntilClickable().click();
        agrgarProductoCarritoPage.clickAddToCartButton();
    }
}





