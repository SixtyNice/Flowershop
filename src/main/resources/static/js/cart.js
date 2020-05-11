const login = localStorage.getItem("login");
const cart = document.querySelector(".cart");
const createOrderBtn = document.querySelector(".createOrderBtn");

function loadCart() {
    fetch(`${login}/cart/`)
        .then((response) => response.json())
        .then((data) => {
            if (data.length === 0) {
                cart.innerHTML = "Your cart is empty";
            } else {
                console.log(data);
                data.forEach((element) => {
                    cart.innerHTML += `<div class="flower">
                    <div class="flowername">${element.flower.name}</div>
                    <div class="flowerPrice">${element.flower.price}</div>
                    <div class="flowerAmount">${element.amount}</div>
                    </div>
                    `;
                });
            }
        });
}

loadCart();

createOrderBtn.addEventListener("click", () => {
    fetch(`${login}/order/createOrder`, {
        method: "POST",
    })
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                cart.innerHTML = "Whoops something went wrong";
                throw new Error("Whoops something went wrong");
            }
        })
        .then((data) => {
            return data;
        })
        .then((data) => {
            if (data !== undefined) {
                cart.innerHTML =
                    "Order has been created go to <a href='./order.html'>Order</a> to pay";
            } else {
                cart.innerHTML = "Whoops someting went wrong";
            }
        })
        .catch((error) => console.error(error));
});
