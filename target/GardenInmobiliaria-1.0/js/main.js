var usuario = new URL(location.href).searchParams.get("usuario");
var user;

$(document).ready(function () {

    $(function (){
        $('[data-toggle ="tooltip"]').tooltip;
    });

    getUsuario().then(function (){
//        $("#my-perfil-btn").attr("href","profile.html?usuario="+usuario);
        $("#user-saldo").html("$" + user.saldo.toFixed(2))
        getInmuebles(false,"ASC");
//        $("#ordenar-tipo").click(ordenarInmueble)
    })
        
});

async function getUsuario(){
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
