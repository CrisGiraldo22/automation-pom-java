package stepDefinitions;

import com.cristinagiraldo.steps.SeleccionarCategoriaStep;
import io.cucumber.java.es.*;
import net.serenitybdd.annotations.Steps;


public class ProductosStepDefinitions {
    @Steps
    SeleccionarCategoriaStep seleccionarCategoriaStep;

    @Dado("que el usuario se encuentra en la pagina principal navega a la categoria {string}")
    public void queElUsuarioSeEncuentraEnLaPaginaPrincipalNavegaALaCategoria(String categoria) {
        seleccionarCategoriaStep.paginaPrincipalMundoFlor();
        seleccionarCategoriaStep.selectCategoria(categoria);
    }
}
