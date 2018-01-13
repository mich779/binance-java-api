package com.romanobori.cycler;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoinsCyclerTest {


    @Test
    public void shouldReturnTheRightCoinCombination(){
        Set<String> coins = ImmutableSet.of("BTC", "ETH", "USDT");

        Set<String> combined = new CombinationGenerator().findMarkets(coins);

        Assert.assertTrue(combined.contains("ETHBTC"));

        Assert.assertTrue(combined.contains("BTCUSDT"));

        Assert.assertTrue(combined.contains("ETHUSDT"));

        Assert.assertEquals(combined.size(), 3);

    }






}