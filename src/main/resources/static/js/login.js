const form = document.querySelector("form");
const submitBtn = document.querySelector("button");

form.addEventListener("submit", submitForm);

function submitForm(event) {
    event.preventDefault();

    const formData = new FormData(event.target);

    const obj = {};

    formData.forEach((value, key) => (obj[key] = value));

    console.log(obj);

    const request = new Request(event.target.action, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: {
            "Content-Type": "application/json",
        },
    });

    fetch(request)
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                alert("Wrong login or password");
            }
        })
        .then((data) => {
            console.log(data.login);
            if (data.login === "admin") {
                localStorage.setItem("admin", data.login);
                window.location.replace(`/admin.html`);
            } else {
                localStorage.setItem("login", data.login);
                window.location.replace(`/home.html`);
            }
        })
        .catch((error) => console.error(error));
}
