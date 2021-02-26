
function loadDoc() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            var obj = JSON.parse(this.responseText);
            printUsuarios(obj);
        }
    };
    xhttp.open("GET", "http://localhost:8080/users", true);
    xhttp.send();
}

function procesarUsuarios(){

    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/users/process";

    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 201) {
            document.location.href = 'index.html';
        }
    };
    var data = JSON.stringify({ "user_ids": getUsuariosToProcess()});
    xhr.send(data);

}

function getUsuariosToProcess(){

    let idsToProcces = [];

    $(".values").each(function() {
        let value = $(this).val();
        let isChecked = $(this).is(':checked');
        if (isChecked) {
            idsToProcces.push(value);
        }
    });

    return idsToProcces;
}


function printUsuarios( usuariosList ) {
    
    let tb = document.getElementById('listUsuarios');

    usuariosList.forEach(function (item) {
        let tr = document.createElement('tr');
       
        tb.appendChild(tr);

        let tdId = document.createElement('td');
        let tdNombre = document.createElement('td');
        let tdApellido = document.createElement('td');
        let tdProcess = document.createElement('td');
        let checkToProcess = document.createElement('td');

        tr.appendChild(tdId);
        tr.appendChild(tdNombre);
        tr.appendChild(tdApellido);
        tr.appendChild(tdProcess);
        tr.appendChild(checkToProcess);

        /**
         * check
         */
        
         if(item.process == false){
             checkToProcess.appendChild(createCheck(item.user_id));
         }

        
        tdId.innerHTML += item.user_id;
        tdNombre.innerHTML += item.name;
        tdApellido.innerHTML += item.last_name;
        tdProcess.innerHTML += item.process;
        
    });

    function createCheck(id){
        let inputCheckToProcess = document.createElement('input');
        inputCheckToProcess.className = 'values';
        inputCheckToProcess.type = "checkbox";
        inputCheckToProcess.value = id;
        inputCheckToProcess.id = id;

        return inputCheckToProcess;
    }

}