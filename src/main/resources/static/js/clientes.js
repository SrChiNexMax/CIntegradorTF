/**
 * 
 */
 
 function getData(rowId) {
	
	var codigo = document.getElementById(rowId).childNodes[1].innerText
    var dniRuc = document.getElementById(rowId).childNodes[3].innerText
	var nombre = document.getElementById(rowId).childNodes[5].innerText
	var telefono = document.getElementById(rowId).childNodes[7].innerText
	var direccion = document.getElementById(rowId).childNodes[9].innerText
	var codigoInput = document.getElementById("idCliente")
    var dniRucInput = document.getElementById("dniRuc")
	var nombreInput = document.getElementById("nombre")
	var telefonoInput = document.getElementById("telefono")
	var direccionInput = document.getElementById("direccion")
	codigoInput.value = codigo
    dniRucInput.value = dniRuc
	nombreInput.value = nombre
	telefonoInput.value = telefono
	direccionInput.value = direccion
	console.log(codigo)
    console.log(dniRuc)
	console.log(nombre)
	console.log(telefono)
	console.log(direccion)
	
}