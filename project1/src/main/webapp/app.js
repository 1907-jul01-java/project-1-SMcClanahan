let requests = [];
let requestElement = document.querySelector('#requests');
let login = [];

function ListRequests(requests) {
    return `<table>
    <tr>
        <th>Id</th>
        <th>Descriptor</th>
        <th>Image</th>
        <th>Amount</th>
    </tr>
    ${requests.map(ListRequest).join('')}
</table>`;
}

function ListRequest(request) {
    return `<tr>
                <td>${request.id}</td>
                <td>${request.descriptor}</td>
                <td>${request.image}</td>
                <td>${request.amount}</td>
            </tr>`;
}

function updateRequestElement() {
    requestElement.innerHTML = ListRequest(requests);
}

function getRequests() {
    let xhr = new XMLHttpRequest();
    xhr.open('get', 'http://localhost:8080/project1/v1/requests');
    xhr.onload = function () {
        requests = JSON.parse(xhr.responseText);
        updateRequestElement();
    };
    xhr.send();
}

function Login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var info = "username=" + username + "&password=" + password;
    let xhr = new XMLHttpRequest();
    xhr.open('post', 'http://localhost:8080/project1/v1/logins', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            if (xhr.responseText == 'invalidUser') {
                return '<p>Invalid Username</p>';
            }
            else if (xhr.responseText == 'invalidPass') {
                return '<p>Invalid Password</p>';
            }
            else {
                var result = JSON.parse(xhr.responseText);
                sessionStorage.setItem('username', result.username);
                sessionStorage.setItem('firstname', result.firstname);
                sessionStorage.setItem('lastname', result.lastname);
                sessionStorage.setItem('id', result.id);
                console.log(result);
                window.location.href = "http://localhost:8080/project1/requests.html";
            }
        }

    }
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(encodeURI(info));

}

function Register() {
    let registration = {
        "username": document.getElementById('username').value,
        "password": document.getElementById('password').value,
        "firstname": document.getElementById('firstname').value,
        "lastname": document.getElementById('lastname').value,
        "accounttype": 0
    };

    let xhttp = new XMLHttpRequest();
    xhttp.open('post', 'http://localhost:8080/project1/v1/requests');
    xhttp.setRequestHeader('Content-type', 'application/json');
    xhttp.send(registration);
}
