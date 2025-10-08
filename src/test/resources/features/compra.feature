#language: es
Característica: como  cliente me encuentro en la pagina principal de la floristeria Mundo Flor.
  quiero validar el proceso de compra y modificación de los productos.

  @ProcesoCompra #flujo basico
  Escenario: Compra exitosa de un producto
    Dado que el usuario se encuentra en la pagina principal navega a la categoria "Ramilletes y Cajas"
    Cuando el usuario selecciona el producto y lo agrega al carrito "MDF 00032"
    Y el usuario selecciona finalizar compra
    Entonces el usuario debe visualizar el formulario para llenar los datos de entrega con la información de 'Su pedido' a un lado.

  @ModificarProductos #flujo alterno
  Escenario: modificar la cantidad de productos en el carrito
    Dado que el cliente ha añadido el producto "MDF 00032" de la categoria "Ramilletes y Cajas"
    Cuando el usuario agrega el producto "MDF 00032" al carrito "2" veces
    Y el usuario hace clic en el botón Actualización de la compra
    Entonces el carrito de compras debe mostrar el subtotal y el total con el precio actualizado

  @IntentarComprar #flujo alterno
  Escenario: Comprar sin llenar aceptar los terminos y condiciones
    Dado que el usuario navega a la categoria "Ramilletes y Cajas"
    Cuando el usuario da clic en agregar al carrito "MDF 00032"
    Y el usuario navega al carrito de compras y da clic en finalizar compra
    Y el usuario selecciona el metodo de pago sin rellenar los datos de entrega
    Entonces el usuario visualiza el mensaje un alerta con los campos que debe llenar en la parte superior de la pagina


