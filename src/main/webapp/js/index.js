$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });


});

function autenticarUsuario() {

    let usuario = $("#usuario").val();
    let contraseña = $("#contraseña").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            usuario: usuario,
            contraseña: contraseña
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let usuario = parsedResult['usuario'];
                document.location.href="home.html?usuario="+usuario;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
function registrarUsuario() {

    let usuario = $("#input-usuario").val();
    let contraseña = $("#input-contraseña").val();
    let contraseñaConfirmacion = $("#input-contraseña-repeat").val();
    let nombres = $("#input-nombres").val();
    let apellidos = $("#input-apellidos").val();
    let telefono = $("#input-telefono").val();
    let direccion_cliente = $("#input-direccion_cliente").val();
    let premium = $("#input-premium").prop("checked");
    let saldo = $("#input-saldo").val();


    if (contraseña == contraseñaConfirmacion) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                usuario: usuario,
                contraseña: contraseña,
                nombres: nombres,
                apellidos: apellidos,
                telefono: telefono,
                direccion_cliente: direccion_cliente,
                premium: premium,
                saldo: saldo
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let usuario = parsedResult['usuario'];
                    document.location.href = "home.html?usuario=" + usuario;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}

