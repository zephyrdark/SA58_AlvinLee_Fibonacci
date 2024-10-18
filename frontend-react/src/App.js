import './App.css';
import CoinRequest from "./CoinRequest";
import {useEffect, useState} from "react";
import axios from "axios";

function App() {
    // retrieve CoinRequest from server
    const backendUrl = process.env.REACT_APP_BACKEND_URL;
    const [myCoinRequestDetails, updateMyCoinRequestDetails] = useState([]);

    useEffect(() => {
        console.log("Retrieving course list from server");
        retrieveCoinRequest();
    });

    const headers = {
        "Content-Type": "application/json",
        mode: "cors",
    };

    function retrieveCoinRequest() {
        if (myCoinRequestDetails.length === 0) {
            axios
                .get(backendUrl, {headers})
                .then(response => {
                    updateMyCoinRequestDetails(response.data);
                    console.log(response.data);
                    console.log(JSON.stringify(response.data));
                })
                .catch(e => {
                    console.log(e);
                });
        }
    }

    return (
        <div className="App">
            <header className="App-header">
                <div>
                    Select coin denominations:
                    <CoinRequest myCoinRequest={myCoinRequestDetails} />
                </div>

                <a className="App-link" href={"https://github.com/zephyrdark"}>By Alvin Lee - Github</a>
            </header>
        </div>
    );
}

export default App;
