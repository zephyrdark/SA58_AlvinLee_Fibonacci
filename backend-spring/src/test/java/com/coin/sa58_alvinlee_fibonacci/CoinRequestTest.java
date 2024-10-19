package com.coin.sa58_alvinlee_fibonacci;

import com.coin.sa58_alvinlee_fibonacci.model.CoinRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CoinRequestTest {

    @Test
    public void testGetTargetAmount() {
        CoinRequest cr = new CoinRequest();
        assertThat(cr.getTargetAmount()).isEqualTo("0");
    }

    @Test
    public void testSetTargetAmount() {
        CoinRequest cr = new CoinRequest();
        cr.setTargetAmount("1000");
        assertThat(cr.getTargetAmount()).isEqualTo("1000");
    }

    @Test
    public void testGetCoinDenominations() {
        CoinRequest cr = new CoinRequest();
        assertInstanceOf(ArrayList.class, cr.getCoinDenominations());
    }

    @Test
    public void testSetCoinDenominations() {
        CoinRequest cr = new CoinRequest();
        cr.setCoinDenominations(new ArrayList<>(Arrays.asList("100", "10")));
        assertThat(cr.getCoinDenominations()).containsExactly("100", "10");
    }

    @Test
    public void testGetMinimumCoins() {
        CoinRequest cr = new CoinRequest();
        assertInstanceOf(HashMap.class, cr.getMinimumCoins());
    }

    @Test
    public void testSetMinimumCoins() {
        CoinRequest cr = new CoinRequest();
        Map<BigDecimal, Integer> map = new HashMap<>();
        map.put(new BigDecimal("1000"), 5);
        cr.setMinimumCoins(map);
        assertThat(cr.getMinimumCoins().get(new BigDecimal("1000"))).isEqualTo(5);
    }

}
