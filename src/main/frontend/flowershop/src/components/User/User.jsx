import React, { Component } from "react";

export default class User extends Component {
    constructor(props) {
        this.state = {
            login: "",
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/home/" + this.state.login)
            .then((data) => data.json())
            .then((response) => console.log(response));
    }

    render() {
        return <div></div>;
    }
}
