function getDataMarca(rowId) {
	var tabla= document.getElementById(rowId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombreMarca = tabla[1].innerHTML
	var codigoInput = document.getElementById("idMarca")
	var nombreMarcaInput = document.getElementById("nombreMarca")
	codigoInput.value = codigo
	nombreMarcaInput.value = nombreMarca
	console.log(codigo)
	console.log(nombreMarca)
}

function getDataCategoria(rowId) {
	var tabla= document.getElementById(rowId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombreCategoria = tabla[1].innerHTML
	var codigoInput = document.getElementById("idCategoria")
	var nombreCategoriaInput = document.getElementById("nombreCategoria")
	codigoInput.value = codigo
	nombreCategoriaInput.value = nombreCategoria
	console.log(codigo)
	console.log(nombreCategoria)
	
}

function getDataProducto(rowId) {
	var tabla= document.getElementById(rowId).getElementsByTagName("td")
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
    var marcaInput = document.getElementById("nombreMarca")
    var categoriaInput = document.getElementById("nombreCategoria")
    var unidadesExistentesInput = document.getElementById("unidadesExistentes")
    var estaSuspendidoInput = document.getElementById("estaSuspendido")

	codigoInput.value = idProducto
	nombreProductoInput.value = nombreProducto
	precioUnidadInput.value = precioUnidad
    marcaInput.value = marca.nombreMarca
    categoriaInput.value = categoria.nombreCategoria
    unidadesExistentesInput.value = almacen.unidadesExistentes
    estaSuspendidoInput.value = almacen.estaSuspendido

	console.log(codigo)
	console.log(nombreProducto)
	console.log(precioUnidad)
	console.log(marca)
	console.log(categoria)
    console.log(unidadesExistentes)
    console.log(estaSuspendido)
}