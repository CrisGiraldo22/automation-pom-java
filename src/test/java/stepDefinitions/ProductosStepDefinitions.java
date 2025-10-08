package stepDefinitions;

import com.cristinagiraldo.steps.CarritoDeComprasStep;
import com.cristinagiraldo.steps.MensajeAlertaStep;
import com.cristinagiraldo.steps.SeleccionarCategoriaStep;
import io.cucumber.java.es.*;
import net.serenitybdd.annotations.Steps;


public class ProductosStepDefinitions {
    @Steps
    SeleccionarCategoriaStep seleccionarCategoriaStep;

    @Steps
    CarritoDeComprasStep carritoDeComprasStep;

    @Steps
    MensajeAlertaStep mensajeAlertaStep;

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

    @Dado("que el cliente ha añadido el producto {string} de la categoria {string}")
    public void queElClienteHaAñadidoElProductoYLaCategoria(String producto, String categoria) {
        seleccionarCategoriaStep.paginaPrincipalMundoFlor();
        seleccionarCategoriaStep.selectCategoria(categoria);
        seleccionarCategoriaStep.selectCodigoProducto(producto);
    }

    @Cuando("el usuario agrega el producto {string} al carrito {string} veces")
    public void elUsuarioAgregaElProductoAlCarritoVeces(String nombreProducto, String cantidad) {
        carritoDeComprasStep.modificarYVerificarCantidad(nombreProducto,cantidad);
    }

    @Y("el usuario hace clic en el botón Actualización de la compra")
    public void actualizacionTotalDeLaCompra() {
        carritoDeComprasStep.actualizarPrecioDelCarrito();
    }

    @Entonces("el carrito de compras debe mostrar el subtotal y el total con el precio actualizado")
    public void elCarritoDeComprasDebeMostrarElSubtotalYElTotalConElPrecioActualizado() {
        carritoDeComprasStep.verificarTablaTotalVisible();
    }

    @Dado("que el usuario navega a la categoria {string}")
    public void queElUsuarioNavegaALaCategoria(String categoria) {
        seleccionarCategoriaStep.paginaPrincipalMundoFlor();
        seleccionarCategoriaStep.selectCategoria(categoria);
    }

    @Cuando("el usuario da clic en agregar al carrito {string}")
    public void elUsuarioDaClicEnAgregarAlCarritoMDF(String producto) {
        seleccionarCategoriaStep.selectCodigoProducto(producto);
    }

    @Y("el usuario navega al carrito de compras y da clic en finalizar compra")
    public void elUsuarioNavegaAlCarritoDeComprasYDaClicEnFinbalizarCompra() {
        carritoDeComprasStep.clicBotonFinalizarCompra();
    }

    @Y("el usuario selecciona el metodo de pago sin rellenar los datos de entrega")
    public void elUsuarioSeleccionaElMetodoDePagoSinRellenarLosDatosDeEntrega() {
        carritoDeComprasStep.clicBotonRealizarPedido();

    }

    @Entonces("el usuario visualiza el mensaje un alerta con los campos que debe llenar en la parte superior de la pagina")
    public void elUsuarioVisualizaElMensajeUnAlertaConLosCamposQueDebeLlenarEnLaParteSuperiorDeLaPagina() {
        mensajeAlertaStep.verificarMensajeAlertaVisible();
    }
}

