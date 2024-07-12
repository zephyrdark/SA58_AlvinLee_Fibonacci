package com.coin.sa58_alvinlee_fibonacci.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoinService {

    private final float[] availableCoins = {1000f, 100f, 50f, 10f, 5f, 2f, 1f, 0.5f, 0.2f, 0.1f, 0.05f, 0.01f};  //todo: consider alternative location/db

    public Map<Float, Integer> getMinimumCoins(float targetAmount) {
        Map<Float, Integer> minimumCoins = new HashMap<>();
        float remainingAmount = targetAmount;

        for (float coin : availableCoins) {
            while (remainingAmount >= coin) {
                if (!minimumCoins.containsKey(coin)) {
                    minimumCoins.put(coin, 1);
                } else {
                    minimumCoins.put(coin, minimumCoins.get(coin) + 1);
                }
                remainingAmount -= coin;
            }
        }
        return minimumCoins;
    }

}
