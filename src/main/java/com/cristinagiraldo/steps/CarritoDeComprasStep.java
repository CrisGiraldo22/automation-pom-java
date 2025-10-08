package com.cristinagiraldo.steps;

import com.cristinagiraldo.pages.AgrgarProductoCarritoPage;
import com.cristinagiraldo.pages.CarritoDeComprasPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.JavascriptExecutor;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CarritoDeComprasStep extends UIInteractionSteps {
    @Page
    public CarritoDeComprasPage carritoDeComprasPage;

    @Page
    public AgrgarProductoCarritoPage  agrgarProductoCarritoPage;

    private void scrollPage() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 400)");
    }

    @Step("Clic en el botón finalizar Compra")
    public void clicBotonFinalizarCompra(){
        carritoDeComprasPage.clickFinalizarCompra();
    }
    @Step("Clic en el botón finalizar Compra")
    public void clicBotonAgragarCantidad(){
        agrgarProductoCarritoPage.getBTN_PlUS_VALUE().click();
    }


    @Step("Verificar pedido con el texto esperado: {0}")
    public void VerificarPedido(String textoEsperado){
        String textoActual = carritoDeComprasPage.getTXT_PEDIDO().waitUntilVisible().getText();

        assertThat(textoActual)
                .as("Verificar que el texto del encabezado del pedido sea igual a '" + textoEsperado + "'")
                .isEqualTo(textoEsperado);
    }

    @Step("El usuario agrega el producto {0} al carrito {1} veces")
    public void modificarYVerificarCantidad(String nombreProducto, String cantidadEsperada) {
        WebElementFacade elementoProductoEnCarrito = agrgarProductoCarritoPage.find(
                agrgarProductoCarritoPage.getNombreProductoSelector(nombreProducto)
        );
        String nombreProductoActual = elementoProductoEnCarrito.waitUntilVisible().getText();
        assertThat(nombreProductoActual)
                .as("Verificar que el producto presente en el carrito sea el esperado: " + nombreProducto)
                .containsIgnoringCase(nombreProducto);
        agrgarProductoCarritoPage.clickPlusButton(cantidadEsperada);
        String cantidadActualTexto = agrgarProductoCarritoPage.getTXT_QUANTITY_FIELD()
                .waitUntilVisible()
                .getValue();

        String cantidadEsperadaTexto = String.valueOf(cantidadEsperada);

        assertThat(cantidadActualTexto)
                .as("Verificar que el campo de cantidad muestre el valor esperado (" + cantidadEsperada + ").")
                .isEqualTo(cantidadEsperadaTexto);
    }

    @Step("Actualizar precio del carrito de compras")
    public void actualizarPrecioDelCarrito(){
        carritoDeComprasPage.getBTN_ACTUALIZAR_COMPRA();
    }
    @Step("Verificar que la tabla de subtotal y total sea visible")
    public void verificarTablaTotalVisible() {
        carritoDeComprasPage.getTBL_TOTAL_Y_SUBTOTAL().waitUntilVisible();
        boolean esVisible = carritoDeComprasPage.getTBL_TOTAL_Y_SUBTOTAL().isVisible();
        assertThat(esVisible)
                .as("La tabla que contiene el subtotal y el total de la compra debe ser visible.")
                .isTrue();
    }
    @Step("Clic en el botón Realizar Pedido")
    public void clicBotonRealizarPedido() {
        carritoDeComprasPage.clickRealizarPedido();
    }

}
