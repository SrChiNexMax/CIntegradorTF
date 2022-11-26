window.addEventListener("load", function(){
    sumImportes();
})

function sumImportes(){
    let total =0;
    const table = document.getElementById("tablaDetalle");
    for(let i=1 ; i< table.rows.length;i++){
        let rowValue= table.rows[i].cells[5].innerHTML;
        total= total + Number(rowValue);
    }
    
    let importe = document.getElementById("importe")
    importe.value= total
}

function obtenerDato() {
	var codigo= document.getElementById('idPro')
    codigo.addEventListener('keyup',(event) =>{

        console.log(event);

        var inputCodigo= event.path[0].value;
        
        var codigoInput = document.getElementById('idProducto')
	    codigoInput.value = inputCodigo
    });
    
}

