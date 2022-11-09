function getDataMarca(mId) {
	var tabla= document.getElementById(mId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombreMarca = tabla[1].innerHTML
	var codigoInput = document.getElementById("idMarca")
	var nombreMarcaInput = document.getElementById("nombreMarca")
	codigoInput.value = codigo
	nombreMarcaInput.value = nombreMarca
	console.log(codigo)
	console.log(nombreMarca)
}

function getDataCategoria(cId) {
	var tabla= document.getElementById(cId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombreCategoria = tabla[1].innerHTML
	var codigoInput = document.getElementById("idCategoria")
	var nombreCategoriaInput = document.getElementById("nombreCategoria")
	codigoInput.value = codigo
	nombreCategoriaInput.value = nombreCategoria
	console.log(codigo)
	console.log(nombreCategoria)
	
}

function getDataProducto(pId) {
	var tabla= document.getElementById(pId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombreProducto = tabla[1].innerHTML
	var precioUnidad = tabla[2].innerHTML
	var marca = tabla[3].innerHTML
    var categoria = tabla[4].innerHTML
    var unidadesExistentes = tabla[5].innerHTML
    var estaSuspendido = tabla[6].innerHTML

	var codigoInput = document.getElementById("idProducto")
	var nombreProductoInput = document.getElementById("nombreProducto")
	var precioUnidadInput = document.getElementById("precioUnidad")
    var marcaInput = document.getElementById("marca")
    var categoriaInput = document.getElementById("categoria")
    var unidadesExistentesInput = document.getElementById("unidadesExistentes")
    var estaSuspendidoInput = document.getElementById("estaSuspendido")

	codigoInput.value = codigo
	nombreProductoInput.value = nombreProducto
	precioUnidadInput.value = precioUnidad
    marcaInput.value = marca
    categoriaInput.value = categoria
    unidadesExistentesInput.value = unidadesExistentes
    estaSuspendidoInput.value = estaSuspendido

	console.log(codigo)
	console.log(nombreProducto)
	console.log(precioUnidad)
	console.log(marca)
	console.log(categoria)
    console.log(unidadesExistentes)
    console.log(estaSuspendido)
}

function limpiarCampos(){
	window.location='/almacen';
}