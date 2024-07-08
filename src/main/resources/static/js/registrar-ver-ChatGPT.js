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
    alert("La contraseña que escribiste es diferente");
    return;
  }

  try {
    const response = await fetch('api/usuarios', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos) //.stringify() conv obj JavaScript a String JSON
    });

    if (!response.ok) {
      // Si la respuesta no es ok, lanzamos un error con el estado HTTP
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    // Verificamos si la respuesta tiene contenido antes de parsear el JSON
    const responseText = await response.text();
    if (responseText) {
      const usuario = JSON.parse(responseText);
      console.log(usuario);
    } else {
      console.log('La respuesta no tiene contenido.');
    }
  } catch (error) {
    console.error('Error:', error);
  }
}
