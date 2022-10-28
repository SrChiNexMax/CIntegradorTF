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