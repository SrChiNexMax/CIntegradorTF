
function getDataMarca(mId) {
	var tabla= document.getElementById(mId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombreMarca = tabla[1].innerHTML

	var codigoInput = document.getElementById("idMarca")
	var nombreMarcaInput = document.getElementById("nombreMarca")

	codigoInput.value = codigo
	nombreMarcaInput.value = nombreMarca

	var addbm = document.getElementById('addMarcaB')
    addbm.setAttribute('disabled', '')
    var buttonm = document.getElementById(mId.replace("m", "buttonM"))
    buttonm.setAttribute("onClick", "removeDataM('"+mId+"')")
    buttonm.innerHTML = "Deseleccionar"

	console.log(codigo)
	console.log(nombreMarca)
}

function removeDataM(id) {
	var codigoInput = document.getElementById("idMarca")
	var nombreMarcaInput = document.getElementById("nombreMarca")

	codigoInput.value = ""
	nombreMarcaInput.value = ""

	var addbM = document.getElementById('addMarcaB')
	addbM.removeAttribute('disabled')
	var buttonm = document.getElementById(id.replace("m", "buttonM"))

	console.log(id)

	buttonm.setAttribute("onClick", "getDataMarca('" + id + "')")
	buttonm.innerHTML = "Seleccionar"
}



function getDataCategoria(cId) {
	var tabla= document.getElementById(cId).getElementsByTagName("td")
	var codigo = tabla[0].innerHTML
	var nombreCategoria = tabla[1].innerHTML

	var codigoInput = document.getElementById("idCategoria")
	var nombreCategoriaInput = document.getElementById("nombreCategoria")

	codigoInput.value = codigo
	nombreCategoriaInput.value = nombreCategoria

	var addbc = document.getElementById('addCategoriaB')
    addbc.setAttribute('disabled', '')
    var buttonc = document.getElementById(cId.replace("c", "buttonC"))
    buttonc.setAttribute("onClick", "removeDataC('"+cId+"')")
    buttonc.innerHTML = "Deseleccionar"

	console.log(codigo)
	console.log(nombreCategoria)
}

function removeDataC(id) {
	var codigoInput = document.getElementById("idCategoria")
	var nombreCategoriaInput = document.getElementById("nombreCategoria")

	codigoInput.value = ""
	nombreCategoriaInput.value = ""

	var addbC = document.getElementById('addCategoriaB')
	addbC.removeAttribute('disabled')
	var buttonc = document.getElementById(id.replace("c", "buttonC"))

	console.log(id)

	buttonc.setAttribute("onClick", "getDataCategoria('" + id + "')")
	buttonc.innerHTML = "Seleccionar"
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
    var marcaSelected = document.getElementById("marca")
    var categoriaInput = document.getElementById("categoria")
    var unidadesExistentesInput = document.getElementById("unidadesExistentes")
    var estaSuspendidoInput = document.getElementById("estaSuspendido")

	codigoInput.value = codigo
	nombreProductoInput.value = nombreProducto
	precioUnidadInput.value = precioUnidad
    marcaSelected.value = marca
    categoriaInput.value = categoria
    unidadesExistentesInput.value = unidadesExistentes
    estaSuspendidoInput.value = estaSuspendido

    var addbp = document.getElementById('addProductoB')
    addbp.setAttribute('disabled', '')
    var buttonp = document.getElementById(pId.replace("p", "buttonP"))
    buttonp.setAttribute("onClick", "removeDataP('"+pId+"')")
    buttonp.innerHTML = "Deseleccionar"

	console.log(codigo)
	console.log(nombreProducto)
	console.log(precioUnidad)
	console.log(marca)
	console.log(categoria)
    console.log(unidadesExistentes)
    console.log(estaSuspendido)
}

function removeDataP(id) {
	var codigoInput = document.getElementById("idProducto")
    var nombreProductoInput = document.getElementById("nombreProducto")
    var precioUnidadInput = document.getElementById("precioUnidad")
    var marcaInput = document.getElementById("marca")
    var categoriaInput = document.getElementById("categoria")
    var unidadesExistentesInput = document.getElementById("unidadesExistentes")
    var estaSuspendidoInput = document.getElementById("estaSuspendido")

	codigoInput.value = ""
    nombreProductoInput.value = ""
    precioUnidadInput.value = ""
    marcaInput.value = ""
    categoriaInput.value = ""
    unidadesExistentesInput.value = ""
    estaSuspendidoInput.value = ""

	var addbP = document.getElementById('addProductoB')
	addbP.removeAttribute('disabled')
	var buttonp = document.getElementById(id.replace("p", "buttonP"))

	console.log(id)
	buttonp.setAttribute("onClick", "getDataProducto('" + id + "')")
	buttonp.innerHTML = "Seleccionar"
}

function limpiarCampos(){
	window.location='/almacen';
}