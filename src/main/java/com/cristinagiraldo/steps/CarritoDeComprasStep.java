package com.cristinagiraldo.steps;

import com.cristinagiraldo.pages.CarritoDeComprasPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.JavascriptExecutor;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CarritoDeComprasStep {
    @Page
    public CarritoDeComprasPage carritoDeComprasPage;

    private void scrollPage() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 400)");
    }

    @Step("Clic en el botón finalizar Compra")
    public void clicBotonFinalizarCompra(){
        carritoDeComprasPage.clickFinalizarCompra();
    }

    @Step("Verificar pedido con el texto esperado: {0}")
    public void VerificarPedido(String textoEsperado){
        String textoActual = carritoDeComprasPage.getTXT_PEDIDO().waitUntilVisible().getText();

        assertThat(textoActual)
                .as("Verificar que el texto del encabezado del pedido sea igual a '" + textoEsperado + "'")
                .isEqualTo(textoEsperado);
    }
}
