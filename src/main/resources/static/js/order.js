const login = localStorage.getItem("login");
const orders = document.querySelector(".orders");

fetch(`${login}/order/list`)
    .then((response) => response.json())
    .then((data) => {
        data.forEach((item) => {
            orders.innerHTML += `
    <form class="order">
        Order Id:<span class="orderId">${item.orderId}</span> 
        Order Status:<span class="orderStatus">${item.status}</span> 
        Order Price:<span class="orderStatus">${item.price}</span> 
        <button class="payOrderBtn">Pay order</button>
    </form>
    `;
        });
    })
    .then(() => {
        const order = document.querySelectorAll(".order");
        order.forEach((item) => {
            item.addEventListener("submit", (event) => {
                event.preventDefault();

                const orderId = event.target.querySelector(".orderId")
                    .innerHTML;
                console.log(orderId);
                fetch(`${login}/order/payOrder/${orderId}`, {
                    method: "POST",
                })
                    .then((response) => response.json())
                    .then((data) => {
                        console.log(data);
                        data.forEach((item) => {
                            event.target.querySelector(
                                ".orderStatus"
                            ).innerHTML = item.status;
                        });
                    });
            });
        });
    });
