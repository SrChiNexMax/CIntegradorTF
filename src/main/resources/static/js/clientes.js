/**
 * 
 */
 
 function getData(rowId) {
	var tabla= document.getElementById(rowId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
    var dniRuc = tabla[1].innerHTML
	var nombre = tabla[2].innerHTML
	var telefono = tabla[3].innerHTML
	var direccion = tabla[4].innerHTML
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