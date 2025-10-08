package com.cristinagiraldo.steps;

import com.cristinagiraldo.pages.MensajeAlertaPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.JavascriptExecutor;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MensajeAlertaStep extends UIInteractionSteps {
    @Page
    public MensajeAlertaPage mensajeAlertaPage;
    private void scrollPageToTop() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0)");
    }
    @Step("Verificar que el mensaje de alerta sea visible")
    public void verificarMensajeAlertaVisible() {
        scrollPageToTop();
        mensajeAlertaPage.getMENSAJE_DE_ALERTA().waitUntilVisible();
        boolean esVisible = mensajeAlertaPage.getMENSAJE_DE_ALERTA().isVisible();
        assertThat(esVisible)
                .as("El mensaje de alerta (div[@role='alert']) debe estar visible en la página.")
                .isTrue();

    }
}
