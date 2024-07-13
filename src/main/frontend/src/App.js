import './App.css';
import CoinRequest from "./CoinRequest";
import {useEffect, useState} from "react";
import axios from "axios";

function App() {
    // retrieve CoinRequest from server
    const [myCoinRequestDetails, updateMyCoinRequestDetails] = useState([]);

    useEffect(() => {
        console.log("Retrieving course list from server");
        retrieveCoinRequest();
    }, []);

    const headers = {
        "Content-Type": "application/json",
        mode: "cors",
    };

    function retrieveCoinRequest() {
        axios
            .get("http://localhost:8080/api/coin-request", {headers})
            .then(response => {
                updateMyCoinRequestDetails(response.data);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    return (
        <div className="App">
            <header className="App-header">
                <div>
                    Select coin denominations:
                    <CoinRequest myCoinRequest={myCoinRequestDetails} />
                </div>

                <img src={"https://i.imgflip.com/8wsrx9.jpg"}
                     alt={"request for target-amount and coin-denominations, in exchange of list of coins"}/>

                <a className="App-link" href={"https://github.com/zephyrdark"}>By Alvin Lee - Github</a>

            </header>
        </div>
    );
}

export default App;
