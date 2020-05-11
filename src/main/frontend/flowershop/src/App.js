import React from "react";
import "./App.css";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Login from "./components/Login/Login";
import User from "./components/User/User";

function App() {
    return (
        <div>
            <Login />
        </div>
    );
}

export default App;
