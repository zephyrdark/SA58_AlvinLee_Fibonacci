package com.coin.sa58_alvinlee_fibonacci.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinRequest {

    Map<Float, Integer> minimumCoins;
    List<Float> coinDenominations;

    public CoinRequest(List<Float> coinDenominations) {
        minimumCoins = new HashMap<>();
        this.coinDenominations = coinDenominations;
    }

    @JsonProperty
    public Map<Float, Integer> getMinimumCoins() {
        return minimumCoins;
    }

    @JsonProperty
    public void setMinimumCoins(Map<Float, Integer> minimumCoins) {
        this.minimumCoins = minimumCoins;
    }

}
