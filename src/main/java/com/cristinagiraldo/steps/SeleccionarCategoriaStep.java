package com.cristinagiraldo.steps;


import com.cristinagiraldo.utils.WebSite;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static net.serenitybdd.core.Serenity.getDriver;


public class SeleccionarCategoriaStep {
    @Page
    WebSite webSite;
    public void paginaPrincipalMundoFlor(){
        webSite.navegarA("https://www.floristeriamundoflor.com/");

    }
    private By getCategoria(String categoria) {
        return By.xpath(String.format("//li[@id='menu-item-2805']/a[text()='%s']", categoria));
    }

    @Step("que el usuario se encuentra en la pagina principal navega a la categoria {0}")
    public void selectCategoria(String categoria) {
        WebElementFacade elementoCategoria = webSite.$(getCategoria(categoria));

        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView(true);",
                elementoCategoria
        );
        elementoCategoria.waitUntilClickable().click();

    }

}
