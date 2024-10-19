package com.coin.sa58_alvinlee_fibonacci.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinRequest {

    String targetAmount;
    List<String> coinDenominations;
    Map<BigDecimal, Integer> minimumCoins;

    public CoinRequest() {
        targetAmount = "0";
        coinDenominations = new ArrayList<>();
        minimumCoins = new HashMap<>();
    }

    @JsonProperty
    public String getTargetAmount() {
        return targetAmount;
    }

    @JsonProperty
    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
    }

    @JsonProperty
    public List<String> getCoinDenominations() {
        return coinDenominations;
    }

    @JsonProperty
    public void setCoinDenominations(List<String> coinDenominations) {
        this.coinDenominations = coinDenominations;
    }

    @JsonProperty
    public Map<BigDecimal, Integer> getMinimumCoins() {
        return minimumCoins;
    }

    @JsonProperty
    public void setMinimumCoins(Map<BigDecimal, Integer> minimumCoins) {
        this.minimumCoins = minimumCoins;
    }

}
