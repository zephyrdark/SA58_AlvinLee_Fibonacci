package com.coin.sa58_alvinlee_fibonacci.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CoinService {

    public Map<BigDecimal, Integer> calculateMinimum(String targetAmount, List<String> coinDenominations) {
        Map<BigDecimal, Integer> minimumCoins = new HashMap<>();
        List<BigDecimal> availableCoins = coinDenominations.stream().map(BigDecimal::new).sorted(Comparator.reverseOrder()).toList();
        BigDecimal remainingAmount = new BigDecimal(targetAmount);

        for (BigDecimal coin : availableCoins) {
            while (coin.compareTo(remainingAmount) <= 0) {
                if (!minimumCoins.containsKey(coin)) {
                    minimumCoins.put(coin, 1);
                } else {
                    minimumCoins.put(coin, minimumCoins.get(coin) + 1);
                }
                remainingAmount = remainingAmount.subtract(coin);
            }
        }
        return minimumCoins;
    }

}
