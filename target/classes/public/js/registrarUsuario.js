function showAlert() {
    Swal.fire({
        title: '¿Datos de registro correctos?',
        showDenyButton: true,
        confirmButtonText: `Registrar`,
        denyButtonText: `Cancelar`,
        }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            validarDatos();
            Swal.fire('Registro exitoso', '', 'success')
            document.getElementById('formulario-registro-usuario').reset();
        } else if (result.isDenied) {
            // Swal.fire('No publicado', '', 'info')
        }
    })
}

function validarDatos(){
    const nombre = document.getElementById("id_nombre").value;
    const apellido = document.getElementById("id_apellido").value;
    const fechaDeNacimiento = document.getElementById("id_fechaDeNacimiento").value;
    const tipoDoc = document.getElementById("id_tipodoc").value;
    const nroDoc = document.getElementById("id_nrodoc").value;
    const perfil = document.getElementById("id_perfil").value;
    const pass = document.getElementById("id_pass").value;
    const user = document.getElementById("id_user").value;
    const calle = document.getElementById("id_calle").value;
    const altura = document.getElementById("id_altura").value;
    const nombreContacto = document.getElementById("id_nombrec").value;
    const apellidoContacto = document.getElementById("id_apellidoc").value;
    const telefono = document.getElementById("id_telc").value;
    const email = document.getElementById("id_emailc").value;
//    const preferenciaWP = document.getElementById("id_pwp").checked = True;
//    const preferenciaSMS = document.getElementById("id_psms").checked;
//    const preferenciaEmail = document.getElementById("id_pemail").checked;

    var contador = 0;


    if(nombre == ""){
        document.getElementById("id_lnombre").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lnombre").style.display = "none";
    }

    if(apellido == ""){
        document.getElementById("id_lapellido").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lapellido").style.display = "none";
    }

    if(!isNaN(fechaDeNacimiento)){
        document.getElementById("id_lfechaDeNacimiento").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lfechaDeNacimiento").style.display = "none";
    }

    if(tipoDoc == ""){
        document.getElementById("id_ltipodoc").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_ltipodoc").style.display = "none";
    }

    if(nroDoc == ""){
        document.getElementById("id_lnrodoc").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lnrodoc").style.display = "none";
    }

    if(perfil == ""){
        document.getElementById("id_lperfil").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lperfil").style.display = "none";
    }

    if(pass == ""){
        document.getElementById("id_lpass").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lpass").style.display = "none";
    }

    if(user == ""){
        document.getElementById("id_luser").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_luser").style.display = "none";
    }

    if(calle == ""){
        document.getElementById("id_lcalle").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lcalle").style.display = "none";
    }

    if(altura == ""){
        document.getElementById("id_laltura").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_laltura").style.display = "none";
    }

    if(nombreContacto == ""){
        document.getElementById("id_lnombrec").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lnombrec").style.display = "none";
    }

    if(apellidoContacto == ""){
        document.getElementById("id_lapellidoc").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lapellidoc").style.display = "none";
    }

    if(telefono == ""){
        document.getElementById("id_ltelc").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_ltelc").style.display = "none";
    }

    if(email == ""){
        document.getElementById("id_lemailc").style.display = "block";
        contador = contador + 1;
    }
    else{
        document.getElementById("id_lemailc").style.display = "none";
    }

//    if(document.getElementById("id_pwp").checked){
//        document.getElementById("id_lpreferencia").style.display = "block";
//        contador = contador + 1;
//    }
//    else{
//        document.getElementById("id_lpreferencia").style.display = "none";
//    }


    if(contador > 0){
        window.scrollTo(0, 0);
        alert("Hay campos vacíos por completar");
        return false;
    }
    else{
        return "/registrarUsuario";
    }


}