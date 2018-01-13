package com.romanobori.cycler;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CombinationGenerator {

    private Map<String, Integer> ordering =  ImmutableMap.of(
            "USDT", 0,
            "BTC", 1,
            "ETH", 2);;

    public Set<String> findMarkets(Set<String> coins) {
        Set<String> markets = new HashSet<>();

        for (List<String> coinCouple : Sets.cartesianProduct(coins, coins))
            if (! isSameCoin(coinCouple))
                markets.add(orderCouple(coinCouple));

        return markets;
    }

    private boolean isSameCoin(List<String> couple) {
        return couple.get(0).equals(couple.get(1));
    }


    private String orderCouple(List<String> couple) {
        String firstElement = couple.get(0);
        String secondElement = couple.get(1);

        return ordering.get(firstElement) > ordering.get(secondElement) ?
                firstElement + secondElement :
                secondElement + firstElement;


    }


}
