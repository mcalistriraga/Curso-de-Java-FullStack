//mc: file: login.js

// Call the dataTables jQuery plugin
$(document).ready(function() {
  //on ready
});

async function iniciarSesion() {
  let datos = {};
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;

  try {
    const request = await fetch('api/login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos) // .stringify() convierte obj JavaScript a String JSON
    });

    const respuesta = await request.text();
    console.log(respuesta);

    if (respuesta == "Ok") {
      window.location.href = "usuarios.html";
    } else {
      alert("Las credenciales son incorrectas. Por favor intente nuevamente");
    }
  } catch (error) {
    console.error('Error:', error);
  }
}
