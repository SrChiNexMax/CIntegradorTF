/**
 * 
 */
 
 function getData(rowId) {
	var tabla= document.getElementById(rowId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombre = tabla[1].innerHTML
	var acceso = tabla[2].innerHTML
	var clave = tabla[3].innerHTML
	var codigoInput = document.getElementById("idUsuario")
	var nombreInput = document.getElementById("nombre")
	var claveInput = document.getElementById("clave")
	var accesoSelect = document.getElementById("acceso")
	codigoInput.value = codigo
	nombreInput.value = nombre
	claveInput.value = clave
	accesoSelect.value = acceso
	console.log(codigo)
	console.log(nombre)
	console.log(acceso)
	console.log(clave)
	
}