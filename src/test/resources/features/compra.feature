#language: es
Característica: como  cliente me encuentro en la pagina principal de la floristeria Mundo Flor.
  quiero validar el proceso de compra y modificación de los productos.

  @ProcesoCompra #flujo basico
  Escenario: Compra exitosa de un producto
    Dado que el usuario se encuentra en la pagina principal navega a la categoria "Ramilletes y Cajas"
    Cuando el usuario selecciona el producto y lo agrega al carrito "MDF 00032"
    Y el usuario selecciona finalizar compra
    Entonces el usuario debe visualizar el formulario para llenar los datos de entrega con la información de 'Su pedido' a un lado.



