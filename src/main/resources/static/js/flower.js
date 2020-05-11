const flowersContainer = document.querySelector(".flowers");
const login = localStorage.getItem("login");
const searchBtn = document.querySelector(".searchBtn");
const searchName = document.querySelector(".searchName");
const priceFrom = document.querySelector(".priceFrom");
const priceTo = document.querySelector(".priceTo");
const searchPrice = document.querySelector(".searchBtnByPrice");

searchBtn.addEventListener("click", () => {
    event.preventDefault();
    console.log("Click");
    const flowerName = searchName.value.trim();
    console.log(flowerName);
    fetch(`/flowers/getflowerbyname/${flowerName}`)
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                flowersContainer.innerHTML = "No such flower";
                return;
            }
        })
        .then((data) => {
            flowersContainer.innerHTML = `<form class="flower" action=${login}/cart/addToCart>
                Flowername: <span name="name" class="flowerName"> ${data.name}</span>
                <br/>
                <span name="price" class="flowerPrice">Price: ${data.price}</span>₽
                <br/>
                <span  class="flowerAmount">Amount: ${data.amount}</span>
                <br/>
                <input name="amount" class="orderAmount" type="number"/>
                <button class="addBtn">Add to Cart</button>
                </form>`;
        })
        .then(() => {
            const addBtn = document.querySelectorAll(".flower");
            const orderAmount = document.querySelector(".orderAmount");
            addBtn.forEach((btn) => {
                btn.addEventListener("submit", (event) => {
                    event.preventDefault();
                    const formData = new FormData(event.target);
                    const obj = {};
                    obj.name = event.target
                        .querySelector(".flowerName")
                        .innerHTML.trim();
                    formData.forEach((value, key) => (obj[key] = value));

                    console.log(obj);
                    console.log(JSON.stringify(obj));

                    const request = new Request(event.target.action, {
                        method: "POST",
                        body: JSON.stringify(obj),
                        headers: {
                            "Content-Type": "application/json",
                        },
                    });

                    fetch(request);

                    console.log("click");
                });
            });
        });
});

fetch("/flowers")
    .then((response) => response.json())
    .then((data) => {
        data.forEach((flower) => {
            flowersContainer.innerHTML += `<form class="flower" action=${login}/cart/addToCart>
            Flowername: <span name="name" class="flowerName"> ${flower.name}</span>
            <br/>
            <span name="price" class="flowerPrice">Price: ${flower.price}</span>
            <br/>
            <span  class="flowerAmount">Amount: ${flower.amount}</span>
            <br/>
            <input name="amount" class="orderAmount" type="number"/>
            <button class="addBtn">Add to Cart</button>
            </form>`;
        });
    })
    .then(() => {
        const addBtn = document.querySelectorAll(".flower");
        const orderAmount = document.querySelector(".orderAmount");
        addBtn.forEach((btn) => {
            btn.addEventListener("submit", (event) => {
                event.preventDefault();
                const formData = new FormData(event.target);
                const obj = {};
                obj.name = event.target
                    .querySelector(".flowerName")
                    .innerHTML.trim();
                formData.forEach((value, key) => (obj[key] = value));

                console.log(obj);
                console.log(JSON.stringify(obj));

                const request = new Request(event.target.action, {
                    method: "POST",
                    body: JSON.stringify(obj),
                    headers: {
                        "Content-Type": "application/json",
                    },
                });

                fetch(request);

                console.log("click");
            });
        });
    });

searchPrice.addEventListener("click", () => {
    fetch(
        `/flowers/getflowerbyprice/?priceFrom=${priceFrom.value}&priceTo=${priceTo.value}`
    )
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                flowersContainer.innerHTML = "No such flower by price";
            }
        })
        .then((data) => {
            console.log(data);
            flowersContainer.innerHTML = "";
            if (data === undefined) {
                flowersContainer.innerHTML = "No such flower by price";
            } else {
                data.forEach((flower) => {
                    flowersContainer.innerHTML += `<form class="flower" action=${login}/cart/addToCart>
                Flowername: <span name="name" class="flowerName"> ${flower.name}</span>
                <br/>
                <span name="price" class="flowerPrice">Price: ${flower.price}</span>
                <br/>
                <span  class="flowerAmount">Amount: ${flower.amount}</span>
                <br/>
                <input name="amount" class="orderAmount" type="number"/>
                <button class="addBtn">Add to Cart</button>
                </form>`;
                });
            }
        })
        .then(() => {
            const addBtn = document.querySelectorAll(".flower");
            const orderAmount = document.querySelector(".orderAmount");
            addBtn.forEach((btn) => {
                btn.addEventListener("submit", (event) => {
                    event.preventDefault();
                    const formData = new FormData(event.target);
                    const obj = {};
                    obj.name = event.target
                        .querySelector(".flowerName")
                        .innerHTML.trim();
                    formData.forEach((value, key) => (obj[key] = value));

                    console.log(obj);
                    console.log(JSON.stringify(obj));

                    const request = new Request(event.target.action, {
                        method: "POST",
                        body: JSON.stringify(obj),
                        headers: {
                            "Content-Type": "application/json",
                        },
                    });

                    fetch(request);

                    console.log("click");
                });
            });
        });
});
