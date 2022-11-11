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

	var addb = document.getElementById('addClienteB')
    addb.setAttribute('disabled', '')
    var button = document.getElementById(rowId.replace("row", "button"))
    button.setAttribute("onClick", "removeData('"+rowId+"')")
    button.innerHTML = "Deseleccionar"

	console.log(codigo)
    console.log(dniRuc)
	console.log(nombre)
	console.log(telefono)
	console.log(direccion)
	
}

function removeData(id) {

	var codigoInput = document.getElementById("idCliente")
    var dniRucInput = document.getElementById("dniRuc")
	var nombreInput = document.getElementById("nombre")
	var telefonoInput = document.getElementById("telefono")
	var direccionInput = document.getElementById("direccion")

	codigoInput.value = ""
    dniRucInput.value = ""
    nombreInput.value = ""
    telefonoInput.value = ""
    direccionInput.value = ""

	var addb = document.getElementById('addClienteB')
	addb.removeAttribute('disabled')
	var button = document.getElementById(id.replace("row", "button"))

	console.log(id)

	button.setAttribute("onClick", "getDataMarca('" + id + "')")
	button.innerHTML = "Seleccionar"
}

function limpiarCampos(){
	window.location='/clientes';
}