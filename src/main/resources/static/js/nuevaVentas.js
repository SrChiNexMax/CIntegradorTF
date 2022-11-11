function obtenerDato() {
	var codigo= document.getElementById('idPro')
    codigo.addEventListener('keyup',(event) =>{

        console.log(event);

        var inputCodigo= event.path[0].value;
        
        var codigoInput = document.getElementById('idProducto')
	    codigoInput.value = inputCodigo
    });
    
}

