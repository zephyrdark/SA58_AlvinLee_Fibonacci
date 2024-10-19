package com.coin.sa58_alvinlee_fibonacci.api;

import com.coin.sa58_alvinlee_fibonacci.model.CoinRequest;
import com.coin.sa58_alvinlee_fibonacci.service.CoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiCoinController {

    private final List<String> availableCoins = List.of("1000", "100", "50", "10", "5", "2", "1", "0.5", "0.2", "0.1", "0.05", "0.01");  //todo: consider alternative location/db
    private final CoinService coinService;

    public ApiCoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @CrossOrigin
    @GetMapping("coin-request")
    public ResponseEntity<?> coinRequest() {
        CoinRequest cr = new CoinRequest();
        cr.setCoinDenominations(availableCoins);
        return new ResponseEntity<> (cr, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("coin-request")
    public ResponseEntity<?> coinRequest(@RequestBody CoinRequest cr) { //todo: to implement receiving array/object as JSON, consider Validation
        cr.setMinimumCoins(coinService.calculateMinimum(cr.getTargetAmount(), cr.getCoinDenominations()));
        return new ResponseEntity<> (cr, HttpStatus.OK);
    }

}
