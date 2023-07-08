/**
 * Visualizar boletines mensuales y quincenales
 * @returns {undefined}
 */
$(function () {
    /**
     * 
     * Visualización inicial para el input del mes
     */
    var hoy = new Date();
    var dd = hoy.getDate();
    var mm = hoy.getMonth() + 1;
    var yyyy = hoy.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    hoy = yyyy + "-" + mm + "-" + dd;
    /**
     * Se realiza la configuración en español para los input date de los boletines mensuales y quincenales
     */
    $('#datefilter').daterangepicker({
        "locale": {
            "format": "YYYY/MM/DD",
            "separator": "-",
            "applyLabel": "Selecionar",
            "cancelLabel": "Cancelar",
            "fromLabel": "Desde",
            "toLabel": "Hasta",
            "customRangeLabel": "Personalizar",
            "daysOfWeek": [
                "Do",
                "Lu",
                "Ma",
                "Mi",
                "Ju",
                "Vi",
                "Sa"
            ],
            "monthNames": [
                "Enero",
                "Febrero",
                "Marzo",
                "Abril",
                "Mayo",
                "Junio",
                "Julio",
                "Agosto",
                "Setiembre",
                "Octubre",
                "Noviembre",
                "Diciembre"
            ],
            "firstDay": 1
        },
        "startDate": yyyy + "/" + mm + "/" + dd,
        "endDate": yyyy + "/" + mm + "/" + dd,
        "opens": "center",
        "maxDate": yyyy + "/" + mm + "/" + dd,
        "minDate": "2021/09/01"
    });


    /**
     * Validación mensual 
     */
    let minmensual = "2021-09";
    let mensual = document.getElementById("mensual");
    mensual.max = yyyy + "-" + mm;
    mensual.min = minmensual;
    /**
     * Validación quincenal para que solamente se visualice el mes inmediatamente anterior, 
     * y solo se active al pasar el día 17 del mes en curso
     */
    var hoyq = new Date();
    var ddq = hoyq.getDate();
    var mmq = "";
    var yyyyq = hoyq.getFullYear();
    if (ddq < 10) {
        ddq = '0' + ddq
    }
    if (ddq >= 17) {
        mmq = hoyq.getMonth() + 1;
    } else {
        mmq = hoyq.getMonth();
    }
    if (mmq < 10) {
        mmq = '0' + mmq
    }
    let minquincenal = "2021-09";
    let quincenal = document.getElementById("quincenal");

    quincenal.max = yyyyq + "-" + mmq;
    quincenal.min = minquincenal;
    /**
     * Esta función se ejecuta cuando cambia el valor del input mes quincena y se inactiva la segunda quincena
     * solamente cuando sea el mes actual .
     */
    $("#quincenal").change(function () {
        var fechaQuin = document.getElementById("quincenal").value;
        var fechaq = fechaQuin.split('-');
        var anio = fechaq[0];
        var mesq = fechaq[1];
        if (anio == yyyyq) {
            var optionElement;
            optionElement = document.querySelector('option[value="2"]');
            if (mesq == mm) {
                optionElement.disabled = true;
            } else {
                optionElement.disabled = false;
            }
        }
    });
    /**
     * Validar que se seleccione el valor correcto del mes y una de las quincenas,
     * para así poder cargar el archivo seleccionado
     */
    $("#quincena").click(function () {
        var fechaQuincenal = document.getElementById("quincenal").value;
        var select = document.getElementById("selectq");
        var quincenaValue = select.value;
        if (fechaQuincenal != "" && quincenaValue != "") {
            var fechaActual = new Date();
            var fechaCo = fechaQuincenal.split('-');
            var diaActual = fechaActual.getDate();
            var mesActual = fechaActual.getMonth() + 1;
            var anioActual = fechaActual.getFullYear();
            var anio = fechaCo[0];
            var mesi = fechaCo[1];
            var mes = "" + mesi.slice(1);
            if (anio <= anioActual) {
                if (mes <= mesActual) {
                    if (mes == mesActual && quincenaValue == 2 && diaActual >= 17) {
                        alert("Debe seleccionar la primera quincena del mes")
                    } else {
                        var pdf = "https://mapasbogota.sire.gov.co:8447/SAB/B_Quincenal/" + anio + "/" + mesi + "/" + quincenaValue + ".pdf";
                        window.open(pdf, '_blank');
                    }
                }
            }
        } else {
            alert("Debe seleccionar alguna fecha")
        }
    });
    /**
     * Validar que se seleccione el valor correcto del mes ,
     * para así poder cargar el archivo seleccionado
     */
    $("#getMensual").click(function () {
        var fecha = document.getElementById("mensual").value;
        if (fecha != "") {
            var fechaCo = fecha.split('-');
            var anio = fechaCo[0];
            var mes = fechaCo[1];
            var pdf = "https://mapasbogota.sire.gov.co:8447/SAB/B_Mensual/" + anio + "/" + mes + "/1.pdf";
            window.open(pdf, '_blank');
        } else {
            alert("Debe seleccionar alguna fecha")
        }
    });
    /**
     * Visualizar la ayuda de boletines
     */
    $("#tituloBoletin").click(function () {
        $("#div1").fadeToggle();
    });
    $("#tituloBoletin1").click(function () {
        $("#div2").fadeToggle();
    });
    

});
