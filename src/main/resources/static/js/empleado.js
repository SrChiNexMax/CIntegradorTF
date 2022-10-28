/**
 * 
 */
 
 function getData(rowId) {
	var tabla= document.getElementById(rowId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombre = tabla[1].innerHTML
	var dni = tabla[2].innerHTML
	var telefono = tabla[3].innerHTML
    var fechaNacimiento = tabla[4].innerHTML
    var fechaContratacion = tabla[5].innerHTML
    var direccion = tabla[6].innerHTML
    var correoEletronico = tabla[7].innerHTML
    var estado = tabla[8].innerHTML
	var codigoInput = document.getElementById("idEmpleado")
	var nombreInput = document.getElementById("nombre")
	var dniInput = document.getElementById("dni")
    var telefonoInput = document.getElementById("telefono")
    var fechaNacimientoInput = document.getElementById("fechaNacimiento")
    var fechaContratacionInput = document.getElementById("fechaContratacion")
    var direccionInput = document.getElementById("direccion")
    var correoEletronicoInput = document.getElementById("email")
	var estadoSelect = document.getElementById("estado")
	codigoInput.value = codigo
	nombreInput.value = nombre
	dniInput.value = dni
    telefonoInput.value = telefono
    fechaNacimientoInput.value = fechaNacimiento
    fechaContratacionInput.value = fechaContratacion
    direccionInput.value = direccion
    correoEletronicoInput.value = correoEletronico
	estadoSelect.value = estado
	console.log(codigo)
	console.log(nombre)
	console.log(dni)
	console.log(telefono)
	console.log(fechaNacimiento)
    console.log(fechaContratacion)
    console.log(direccion)
    console.log(correoEletronico)
    console.log(estado)
}