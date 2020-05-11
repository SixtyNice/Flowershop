const login = localStorage.getItem("login");
const userLogin = document.querySelector(".user__login");
const balance = document.querySelector(".balance");

fetch(`/home/${login}`)
    .then((response) => response.json())
    .then((data) => {
        console.log(data.login);
        userLogin.innerHTML = "Hello " + data.login;
        balance.innerHTML = "Balance " + data.balance + "₽";
    });
