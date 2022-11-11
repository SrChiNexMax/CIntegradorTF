/**
 * 
 */
 
 function getData(rowId) {
	var tabla= document.getElementById(rowId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombre = tabla[1].innerHTML
	var acceso = tabla[2].innerHTML
	var codigoInput = document.getElementById("idEmpleado")
	var nombreInput = document.getElementById("nombre")
	var accesoSelect = document.getElementById("acceso")
	codigoInput.value = codigo
	nombreInput.value = nombre
	accesoSelect.value = acceso
	var addb = document.getElementById('agregar')
	addb.setAttribute('disabled', '')
	var button = document.getElementById(rowId.replace("row", "button"))
	button.setAttribute("onClick", "removeData('"+rowId+"')")
	button.innerHTML = "Deseleccionar"

	var codigo2Input = document.getElementById("idEmpleadoSus")
	codigo2Input.value = codigo

	console.log(codigo)
	console.log(nombre)
	console.log(acceso)
}

function removeData(id) {
	var codigoInput = document.getElementById("idEmpleado")
	var nombreInput = document.getElementById("nombre")
	var accesoSelect = document.getElementById("acceso")
	codigoInput.value = ""
	nombreInput.value = ""
	accesoSelect.value = ""
	var addb = document.getElementById('agregar')
	addb.removeAttribute('disabled')
	var button = document.getElementById(id.replace("row", "button"))
	
	console.log(id)
	button.setAttribute("onClick", "getData('" + id + "')")
	button.innerHTML = "Seleccionar"
}