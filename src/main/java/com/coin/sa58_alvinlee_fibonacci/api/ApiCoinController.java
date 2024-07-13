package com.coin.sa58_alvinlee_fibonacci.api;

import com.coin.sa58_alvinlee_fibonacci.model.CoinRequest;
import com.coin.sa58_alvinlee_fibonacci.service.CoinService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApiCoinController {

//    private final List<Float> availableCoins = Arrays.asList(1000f,100f,50f,10f,5f,2f,1f,0.5f,0.2f,0.1f,0.05f,0.01f) ;  //todo: consider alternative location/db
    private final List<String> availableCoins = List.of("1000", "100", "50", "10", "5", "2", "1", "0.5", "0.2", "0.1", "0.05", "0.01");  //todo: consider alternative location/db
    private final CoinService coinService;

    public ApiCoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("coin-request")
    public ResponseEntity<?> coinRequest() {
        CoinRequest cr = new CoinRequest();
        cr.setCoinDenominations(availableCoins);
        return new ResponseEntity<> (cr, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("coin-request")
    public ResponseEntity<?> coinRequest(@RequestBody CoinRequest coinRequest) { //todo: to implement receiving array/object as JSON, consider Validation
        coinRequest.setMinimumCoins(coinService.calculateMinimum(coinRequest.getTargetAmount(), coinRequest.getCoinDenominations()));
        return new ResponseEntity<> (coinRequest, HttpStatus.OK);
    }

}
