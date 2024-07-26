//mc: file: registrar.js

// Call the dataTables jQuery plugin
$(document).ready(function() {
//on ready
});

async function registrarusuario() {

  let datos = {};
  datos.nombre = document.getElementById('txtNombre').value;
  datos.apellido = document.getElementById('txtApellido').value;
  datos.email = document.getElementById('txtEmail').value;
  //datos.telefono = document.getElementById('txtTelefono').value;
  datos.password = document.getElementById('txtPassword').value;

  let repetirPassword = document.getElementById('txtRepetirPassword').value;

  if (repetirPassword != datos.password) {
     alert ("La contraseña que escribiste es diferente");
     return;
  }


  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos) //.stringify() conv obj JavaScrit a String JSON
  });
  alert("La cuenta fué creada con éxito!");
  windows.location.href = "login.html";
}