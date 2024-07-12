package com.coin.sa58_alvinlee_fibonacci.api;

import com.coin.sa58_alvinlee_fibonacci.model.CoinRequest;
import com.coin.sa58_alvinlee_fibonacci.service.CoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("api")
@RestController
public class ApiCoinController {

    private final List<Float> availableCoins = Arrays.asList(1000f,100f,50f,10f,5f,2f,1f,0.5f,0.2f,0.1f,0.05f,0.01f) ;  //todo: consider alternative location/db
    private final CoinService coinService;

    public ApiCoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @PostMapping("calculate")
    public ResponseEntity<?> calculate(@RequestParam String input) { //todo: consider Validation
//                                         @RequestBody List<Float> coinDenominations) { //todo: to implement receiving array/object as JSON, consider Validation
        float targetAmount = Float.parseFloat(input);
        CoinRequest coinRequest = new CoinRequest(availableCoins);
        coinRequest.setMinimumCoins(coinService.getMinimumCoins(targetAmount));
        return new ResponseEntity<> (coinRequest.getMinimumCoins(), HttpStatus.OK);
    }

}
