var usuario = new URL(location.href).searchParams.get("usuario");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        $("#user-saldo").html("$" + user.saldo.toFixed());

        getAlquiladas(user.usuario);
    });

    $("#reservar-btn").attr("href", `home.html?usuario=${usuario}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
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

                $("#input-usuario").val(parsedResult.usuario);
                $("#input-contraseña").val(parsedResult.contraseña);
                $("#input-nombres").val(parsedResult.nombres);
                $("#input-apellidos").val(parsedResult.apellidos);
                $("#input-telefono").val(parsedResult.telefono); 
                $("#input-direccion_cliente").val(parsedResult.direccion_cliente); 
                $("#input-premium").prop("checked", parsedResult.premium);
                $("#input-saldo").val(parsedResult.saldo.toFixed(2));

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getAlquiladas(usuario) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletAlquilerListar",
        data: $.param({
            usuario: usuario
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult)

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarHistorial(inmuebless) {

    let contenido = "";

    if (inmuebless.length >= 1) {

        $.each(inmuebless, function (index, inmuebless) {

            inmuebless = JSON.parse(inmuebless);

            contenido += '<tr><th scope="row">' + inmuebless.id_inmueble + '</th>' +
                    '<td>' + imuebless.tipo_inmueble + '</td>' +
                    '<td>' + inmuebless.descripcion + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + inmuebless.id_inmueble 
                    + '" disabled ';
            if (inmuebless.descripcion) {
                contenido += 'checked'
            }
            contenido += '></td><td>' + inmuebless.fechaAlquiler + '</td>' +
                    '<td><button id="devolver-btn" onclick= "devolverpelicula(' + inmuebless.id_inmueble
                    + ');" class="btn btn-danger">Devolver pelicula</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function devolverPelicula(id_inmueble) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletPeliculaDevolver",
        data: $.param({
            usuario: usuario,
            id_inmueble: id_inmueble
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo el Pelicula");
            }
        }
    });

}

function modificarUsuario() {

    let usuario = $("#input-usuario").val();
    let contraseña = $("#input-contraseña").val();
    let nombres = $("#input-nombres").val();
    let apellidos = $("#input-apellidos").val();
    let telefono = $("#input-telefono").val();
    let direccion_cliente = $("#input-direccion_cliente").val();
    let premium = $("#input-premium").prop('checked');
    let saldo = $("#input-saldo").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            usuario: usuario,
            contraseña: contraseña,
            nombres: nombres,
            apellidos: apellidos,
            telefono: telefono, 
            premium: premium,
            saldo: saldo
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            usuario: usuario
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}



