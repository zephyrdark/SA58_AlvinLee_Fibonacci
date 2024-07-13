import './CoinRequest.css';
import {useEffect, useState} from "react";
import Button from "react-bootstrap/Button";
import axios from "axios";

function CoinRequest({myCoinRequest}) {
    // checkboxes
    const [isChecked, setIsChecked] = useState([]);
    const handleCheckboxChange = (id, event) => {
        const arr = [...isChecked]; // creates new copy of array so the same elements are not referenced
        const index = arr.indexOf(id);
        if(index === -1) {
            arr.push(id);
        }
        else {
            arr.splice(index, 1);
        }
        setIsChecked(arr);
        console.log(id);
        console.log(isChecked);
    };

    const headers = {
        "Content-Type": "application/json",
        mode: "cors",
    };

    const inputField = document.getElementById("targetAmount").value;

    const submit = (event) => {
        myCoinRequest = {
            targetAmount: parseFloat(inputField).toFixed(2),
            coinDenominations: isChecked.map(x => coinDenominations[x]),
            minimumCoins: {}
        }
        console.log(JSON.stringify(myCoinRequest));
        axios
            .post("http://localhost:8080/api/coin-request", {headers}, myCoinRequest)
            .then(response => {
                // updateMyCoinRequestDetails(response.data);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    const coinDenominations = [1000, 100, 50, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.01]

    const listCoins = coinDenominations.map(value =>
        <li className="CoinRequest-list-item">
            <label>
                <input
                    id={coinDenominations.indexOf(value)}
                    type="checkbox"
                    checked={isChecked.includes(coinDenominations.indexOf(value))}
                    onChange={(event) => handleCheckboxChange(coinDenominations.indexOf(value), event)}
                />
            </label>
            {value.toString()}
        </li>
    );

    return (
        <div className="CoinRequest">
            <ul className="CoinRequest-list">
                {listCoins}
            </ul>
            <div className="input-group mb-3">
                <input id="targetAmount" type="number" step=".01" aria-label="Target Amount" placeholder="Between 0 to 10000"></input>
                <Button variant="primary" as="input" type="submit" value="Submit" onClick={submit}></Button>
            </div>
        </div>
    )
}

export default CoinRequest;