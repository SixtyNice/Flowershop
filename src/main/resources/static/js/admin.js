const orders = document.querySelector(".orders");

fetch("/admin")
    .then((response) => response.json())
    .then((data) => {
        console.log(data);
        data.forEach((order) => {
            if (order.dateClose === null) {
                order.dateClose = "Order is not closed while";
            }
            orders.innerHTML += `
            <form class="order">
            Order Id: <span class="orderId">${order.orderId}</span>
            <br/>
            Status: <span class="orderStatus">${order.status}</span>
            <br/>
            Date create:<span class="dateCreate">${order.dateCreate}</span>
            <br/>
            Date close: <span class="dateClose">${order.dateClose}</span>
            <br/>
                <button type="submit" class="closeOrderBtn">Close Order</button>
            </form>
            `;
        });
    })
    .then(() => {
        const order = document.querySelectorAll(".order");
        order.forEach((item) => {
            item.addEventListener("submit", (event) => {
                event.preventDefault();
                const orderId = event.target.querySelector(".orderId");
                const dateClose = event.target.querySelector(".dateClose");
                fetch(`/admin/closeOrder/${orderId.innerHTML}`, {
                    method: "PUT",
                })
                    .then((response) => response.json())
                    .then((data) => {
                        data.forEach((item) => {
                            dateClose.innerHTML = item.dateClose;
                        });
                    });
            });
        });
    });
