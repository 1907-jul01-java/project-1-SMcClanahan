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

function Login() {
    sessionStorage.setItem("username", document.getElementById('username').value);
    var username = sessionStorage.getItem("username");
    var password = document.getElementById("password").value;
    console.log('username:' + username);
    console.log(password);
    let xhttp = new XMLHttpRequest();
    xhttp.open('get', 'http://localhost:3000/logins');
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                login = xhttp.responseText;
                console.log('hello');
                console.log(login);
                for(var i; i < login.length(); i++) {
                    if (login[i].username == username) {
                        if (login[i].password == password) {
                            //return(<p>Logged in</p>);
                            console.log('logged in');
                            //window.location.href = "http://localhost:8080/project1";
                        }
                        else {
                            console.log('invalid password');
                        }
                    }
                    else {
                        console.log('invalid username');
                    }
            }
        }
};
xhttp.send();
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
    xhttp.open('post', 'http://localhost:3000/logins');
    xhttp.setRequestHeader('Content-type', 'application/json');
    xhttp.send(registration);
}
