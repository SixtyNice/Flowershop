const logoutBtn = document.querySelector(".logoutBtn");
logoutBtn.addEventListener("click", () => {
    fetch("/logout", {
        method: "POST",
    }).then(() => window.location.replace("/"));
    localStorage.clear();
});
