/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function descargardocumento(id) {
    let ubicacion = document.getElementById("ubicacion").value;
    window.open("/reportessab/ServletPDF?id="+id+"&ubicacion=" + ubicacion + "", '_blank');
}
function validarDocumento(nombre) {
    var fileInput = document.getElementById(nombre);
    var filePath = fileInput.value;
    var allowedExtensions = /(.pdf)$/i;
    if (!allowedExtensions.exec(filePath)) {
        alert('Debe subir archivos en formato .pdf');
        fileInput.value = '';
    } else {
        var input = document.getElementById("" + nombre + "");
        var file = input.files[0];
        if (file.size > 5388608) {
            alert("El archivo debe pesar menos de 5 MB");
            $("#" + nombre + "").val("");
        }
    }
}
function cargardocumento() {
   var fecha = document.getElementById("fechaIni").value;
   var fechai=document.getElementById("fechaInic").value=fecha;
   var descripcion = document.getElementById("iddescripcion").value;
   var descripcionI=document.getElementById("iddescripcionIn").value=descripcion;
   var idtipomantenimiento = document.getElementById("idtipomantenimiento").value;
   var idtipomantenimientoI=document.getElementById("idtipomantenimientoIn").value=idtipomantenimiento;
   var objO = document.getElementById("cargar");
   objO.click();
}
