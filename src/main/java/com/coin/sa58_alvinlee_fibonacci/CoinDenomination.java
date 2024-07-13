package com.coin.sa58_alvinlee_fibonacci;

// TODO: explore using enum
public enum CoinDenomination {
    THOUSAND("1000"),
    HUNDRED("100"),
    FIFTY("50"),
    TEN("10"),
    FIVE("5"),
    TWO("2"),
    ONE("1"),
    FIFTY_CENTS("0.5"),
    TWENTY_CENTS("0.2"),
    TEN_CENTS("0.1"),
    FIVE_CENTS("0.05"),
    ONE_CENT("0.01");

    private final String value;

    CoinDenomination(String v) {
        value = v;
    }

    String getValue() {
        return value;
    }
}
