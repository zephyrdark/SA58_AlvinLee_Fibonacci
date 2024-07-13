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

    const coinDenominations = [1000, 100, 50, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.01]
    // const coinDenominations = [{"1": 1000}, {"2":100}, {"3":50}, {"4":10}, {"5":5},
    //     {"6":2}, {"7":1}, {"8":0.5}, {"9":0.2}, {"10":0.1}, {"11":0.05}, {"12":0.01}]

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
    // const listCoins = Object.entries(coinDenominations).map(([key,value]) =>
    //     <li className="CoinRequest-list-item">
    //         <label>
    //             <input
    //                 id={"coin-denomination-id-"+{key}}
    //                 type="checkbox"
    //                 checked={isChecked}
    //                 onChange={(event) => handleCheckboxChange({key}, event)}
    //             />
    //         </label>
    //         {value.toString()}
    //     </li>
    // );

    return (
        <div className="CoinRequest">
            <ul className="CoinRequest-list">
                {listCoins}
            </ul>
            <div className="input-group mb-3">
                <input type="number" aria-label="Target Amount" placeholder="Between 0 to 10000"></input>
                <Button variant="primary" as="input" type="submit" value="Submit"></Button>
            </div>
        </div>
    )
}

export default CoinRequest;