
 document.addEventListener("DOMContentLoaded", function() {
  	let btn = document.getElementById("facturarbutton");
  	btn.setAttribute('disabled', '')
  	
});


 function getData(rowId) {
	let tabla= document.getElementById(rowId).getElementsByTagName("td")
	let codigo = tabla[0].innerHTML
	let codigoInput = document.getElementById("idComprobante")

	codigoInput.value = codigo
	var addb = document.getElementById('facturarbutton')
	addb.removeAttribute('disabled')
	let button = document.getElementById(rowId.replace("row", "button"))
	button.setAttribute("onClick", "removeData('"+rowId+"')")
	button.innerHTML = "Deseleccionar"

	console.log(codigo)
}

function removeData(id) {
	let codigoInput = document.getElementById("idComprobante")

	codigoInput.removeAttribute('value')
  	let btn = document.getElementById("facturarbutton");
  	btn.setAttribute('disabled', '')
	let button = document.getElementById(id.replace("row", "button"))
	
	console.log(id)
	button.setAttribute("onClick", "getData('" + id + "')")
	button.innerHTML = "Seleccionar"
}
