package stepDefinitions;

import com.cristinagiraldo.steps.CarritoDeComprasStep;
import com.cristinagiraldo.steps.SeleccionarCategoriaStep;
import io.cucumber.java.es.*;
import net.serenitybdd.annotations.Steps;



public class ProductosStepDefinitions {
    @Steps
    SeleccionarCategoriaStep seleccionarCategoriaStep;

    @Steps
    CarritoDeComprasStep carritoDeComprasStep;

    @Dado("que el usuario se encuentra en la pagina principal navega a la categoria {string}")
    public void seEncuantraEnPaginaPrincipalNavegaACategoria(String categoria) {
        seleccionarCategoriaStep.paginaPrincipalMundoFlor();
        seleccionarCategoriaStep.selectCategoria(categoria);
    }

    @Cuando("el usuario selecciona el producto y lo agrega al carrito {string}")
    public void seleccionarProductoYAgregarAlCarrito(String codigoProducto) {
        seleccionarCategoriaStep.selectCodigoProducto(codigoProducto);

    }

    @Y("el usuario selecciona finalizar compra")
    public void elUsuarioSeleccionaFinalizarCompra() {
        carritoDeComprasStep.clicBotonFinalizarCompra();

    }

    @Entonces("el usuario debe visualizar el formulario para llenar los datos de entrega con la información de {string} a un lado.")
    public void elUsuarioDebeVisualizarElFormularioParaLlenarLosDatosDeEntregaConLaInformaciónDeSuPedidoAUnLado(String textoEsperado) {
        carritoDeComprasStep.VerificarPedido(textoEsperado);
    }
}
