/* Utilizando una llamada AJAX */
document.addEventListener("DOMContentLoaded", function () {
        const btnEditarGuardar = document.getElementById("btnEditarGuardar");
        const inputFields = document.querySelectorAll(".custom-field");
        const selectMetodoPago = document.getElementById("inputMetodoPago");

        // deshabilita los campos de entrada al cargar la página.
        inputFields.forEach((input) => {
            input.disabled = true;
        });
        selectMetodoPago.disabled = true;

        let isEditing = false;

        btnEditarGuardar.addEventListener("click", function () {
            if (isEditing) {

                // recopila los valores de los campos
                const nombreCompleto = document.getElementById("inputNombreCompleto").value;
                const correo = document.getElementById("inputEmail").value;
                const cedula = document.getElementById("inputCedula").value;
                const numeroTelefono = document.getElementById("inputTelefono").value;
                const direccionResidencia = document.getElementById("inputDireccionResidencia").value;
                const contraseña = document.getElementById("inputContraseña").value;
                const metodoPago = selectMetodoPago.value;


                // cambia el texto del botón de vuelta a "Editar".
                btnEditarGuardar.textContent = "Editar Perfil";
                isEditing = false;

                // deshabilita los campos de entrada y el campo "Método de Pago"
                inputFields.forEach((input) => {
                    input.disabled = true;
                });
                selectMetodoPago.disabled = true;
            } else {
                // cambia el texto del boton a "Guardar" y permite la edición de campos
                btnEditarGuardar.textContent = "Guardar Cambios";
                isEditing = true;

                // habilita los campos de entrada y el campo del "Metodo de Pago".
                inputFields.forEach((input) => {
                    input.disabled = false;
                });
                selectMetodoPago.disabled = false;
            }
        });
    });






