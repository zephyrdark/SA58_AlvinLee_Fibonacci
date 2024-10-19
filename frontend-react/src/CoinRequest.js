import './CoinRequest.css';
import {useState} from "react";
import Button from "react-bootstrap/Button";
import axios from "axios";

function CoinRequest({myCoinRequest}) {
    // TODO: get available/validated coinDenominations from backend
    const coinDenominations = [1000, 100, 50, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.01]

    // Coin Denominations Checkboxes
    const [isChecked, setIsChecked] = useState([]);
    const handleCheckboxChange = (id, event) => {
        const arr = [...isChecked]; // creates new copy of array so the same elements are not referenced
        const index = arr.indexOf(id);
        (index === -1) ? arr.push(id) : arr.splice(index, 1);
        setIsChecked(arr);
        console.log(isChecked);
    };

    let outputHtml = document.getElementById("output");

    const handlePostResponse = (data) => {
        const minimumCoinsMap = new Map(Object.entries(data.minimumCoins));
        let outputArray = [];
        outputHtml.innerHTML = ''
        isChecked.sort(function(a, b){return b-a});
        isChecked.forEach(value => {
            let coin_denomination = coinDenominations[value].toFixed(2).toString()
            for (let i = 0; i < minimumCoinsMap.get(coin_denomination); i++) {
                outputArray.push(coin_denomination);
            }
        })
        outputHtml.innerHTML += '[' + outputArray.join(', ') + ']';
    }

    // Target Amount
    const inputField = document.getElementById("targetAmount");

    // Submit function
    const submit = (event) => {
        let value = inputField.value;
        if (value === '') {
            alert("Target Amount must be between 0 and 10,000.00.");
            return;
        }
        let targetAmountValue = parseFloat(value);
        if (targetAmountValue < 0 || targetAmountValue > 10000) {
            alert("Target Amount must be between 0 and 10,000.00.");
            return;
        }
        if (isChecked.length < 1) {
            alert("Please select at least 1 coin.");
            return;
        }
        if (coinDenominations[Math.max(...isChecked)] > targetAmountValue) {
            alert("Selected coin(s) cannot be larger than Target Amount");
            return;
        }

        let coinRequest = {
            targetAmount: parseFloat(inputField.value).toFixed(2),
            coinDenominations: isChecked.map(x => coinDenominations[x].toFixed(2)),
            minimumCoins: {}
        }
        const config = {
            "ContentType": "application/json",
            "Accept": "application/json",
            "mode": "cors",
        };
        axios
            .post("http://13.54.119.163:8080/api/coin-request", coinRequest, config)
            .then(response => {
                handlePostResponse(response.data);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    // const to list individual coinDenominations
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
            <div>
                <ul className="CoinRequest-list">
                    {listCoins}
                </ul>
            </div>
            <div className="input-group mb-3 container-sm">
                <label className="input-group-text">Target Amount:</label>
                <input className="form-control" id="targetAmount" required type="number" min="0" max="10000" step=".01"
                       aria-label="Target Amount" placeholder="Between 0 to 10,000.00"></input>
                <Button variant="primary" as="input" type="submit" value="Submit" onClick={submit}></Button>
            </div>
            <div>
                You will need these coins:
                <div>
                    <p id="output"></p>
                </div>
            </div>
        </div>
    )
}

export default CoinRequest;