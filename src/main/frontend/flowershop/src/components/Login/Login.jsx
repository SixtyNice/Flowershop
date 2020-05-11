import React, { Component } from "react";
import { Switch, Route, Redirect } from "react-router-dom";
import User from "../User/User";

export default class Login extends Component {
    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);

        // Собираем данные формы в объект
        let obj = {};
        data.forEach((value, key) => (obj[key] = value));

        fetch("http://localhost:8080/login", {
            method: "POST",
            body: JSON.stringify(obj),
            headers: {
                "Content-Type": "application/json", // отправляемые данные
            },
        })
            .then((data) => data.json())
            .then((response) => {
                if (response === true) {
                    
                }
            })
            .catch((error) => console.error(error));
        console.log(obj.login);
        console.log(JSON.stringify(obj));
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="login">Enter login</label>
                <input id="login" name="login" type="text" />

                <label htmlFor="password">Enter your password</label>
                <input id="password" name="password" type="password" />

                <button>Login!</button>
            </form>
        );
    }
}
