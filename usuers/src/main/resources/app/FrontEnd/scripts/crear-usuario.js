function guardarUsuario() {
    let nombre = document.getElementById("inputNombre").value;
    let apellido = document.getElementById("inputapellido").value;

    if (nombre === "" || apellido === "") {
        alert("los campos no pueden ser vacios");
    } else {

        sendRequest(nombre, apellido);
    }

}

function sendRequest(nombre, apellido) {

    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/users";

    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            console.log(json.email + ", " + json.password);
            document.location.href = 'index.html';
        }
    };
    var data = JSON.stringify({ "name": nombre, "last_name": apellido });
    xhr.send(data);
}