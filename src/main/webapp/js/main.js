var usuario = new URL(location.href).searchParams.get("usuario");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle ="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        $("#my-perfil-btn").attr("href", "profile.html?usuario=" + usuario);
        $("#user-saldo").html("$" + user.saldo.toFixed());//entre parentesis del tofixed le pone decimales ala cifra "toFixed(2)"2 decimales
        getInmuebles(false, "ASC");
        $("#ordenar-tipo").click(ordenarInmueble)


    });

    async function getUsuario() {
        await $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioPedir",
            data: $.param({
                usuario: usuario

            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult != false) {
                    user = parsedResult;

                } else {
                    console.log("Error recuperando los datos del usuario");
                }
            }
        });
    }
    function getInmuebles(ordenar, orden) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletInmuebleListado",
            data: $.param({
                ordenar: ordenar,
                orden: orden

            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult != false) {
                    mostrarInmuebles(parsedResult);

                } else {
                    console.log("Error recuperando los datos de los inmuebles");
                }
            }
        });
    }
    function mostrarInmuebles(inmuebless) {
        let contenido = "";
        $.each(inmuebless, function (index, inmuebless) {
            inmuebless = JSON.parse(inmuebless);
            let precioo;
            if (inmuebless.parqueadero > 0) {
                if (user.premium) {
                    if (inmuebless.descripcion) {
                        precioo = inmuebless.precio * 0.75;

                    } else {
                        precioo = inmuebless.precio;
                    }
                } else {
                    if (inmuebless.descripcion) {
                        precioo = 2;
                    } else {
                        precioo = 1;
                    }
                }
                contenido += '<tr><th scope="row">' + inmuebless.id_inmueble + '</th>' +
                        '<td>' + inmuebless.tipo_inmueble + '</td>' +
                        '<td>' + inmuebless.precio + '</td>' +
                        '<td>' + inmuebless.habitaciones + '</td>' +
                        '<td>' + inmuebless.banos + '</td>' +
                        '<td>' + inmuebless.area_total + '</td>' +
                        '<td>' + inmuebless.parqueadero + '</td>' +
                        '<td>' + inmuebless.direccion_inmueble + '</td>' +
                        '<td>' + inmuebless.descripcion + '</td>'

                if (inmuebless.descripcion) {
                    contenido += 'checked';
                }
                contenido += '></td>' +
                        '<td>' + precioo + '</td>' +
                        '<td><button onclick="alquilarInmueble(' + inmuebless.id_inmueble + ',' + precioo + ');" class="btn btn-success"';
                if (user.saldo < precioo) {
                    contenido += 'disabled';
                }

                contenido += '>Reservar</button></td></tr>'
            }
        });
        $("#inmuebles-garden-tbody").html(contenido);

    }
    function ordenarInmueble() {
        if ($("#icono-ordenar").hasClass("fa-sort")) {
            getInmuebles(true, "ASC");
            $("#icono-ordenar").removeClass("fa-sort");
            $("#icono-ordenar").addClass("fa-sort-down");
        } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
            getInmuebles(true, "DESC");
            $("#icono-ordenar").removeClass("fa-sort-down");
            $("#icono-ordenar").addClass("fa-sort-up");
        } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
            getInmuebles(false, "ASC");
            $("#icono-ordenar").removeClass("fa-sort-up");
            $("#icono-ordenar").addClass("fa-sort");

        }
    }
    });
    function alquilarInmueble(id_inmueble, precioo) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletInmuebleAlquilar",
            data: $.param({
                id_inmueble: id_inmueble,
                usuario: usuario

            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult != false) {
                    restarDinero(precioo).then(function () {
                        location.reload();
                    })

                } else {
                    console.log("Error en la reserva del inmueble");
                }
            }
        });
    }
    async function restarDinero(precioo) {
        await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRestarDinero",
        data: $.param({
            usuario: usuario,
            saldo: parseFloat(user.saldo - precioo)
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                console.log("Saldo actualizado")
            } else {
                console.log("Error en el proceso de pago");
            }
        }
    });
}