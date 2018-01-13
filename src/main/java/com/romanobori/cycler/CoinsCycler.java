package com.romanobori.cycler;

import com.binance.api.client.BinanceApiAsyncRestClient;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.NewOrder;
import com.binance.api.client.domain.market.BookTicker;
import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CoinsCycler {

    public CoinsCycler(BinanceApiAsyncRestClient client) {
        this.client = client;
    }

    BinanceApiAsyncRestClient client;

    Set<String> generatedCombintaions = new CombinationGenerator().findMarkets(
            ImmutableSet.of("BTC", "ETH", "USDT")
    );

    public void cycle(int amount){
        client.getBookTickers(bookTickerLst -> handleBookTicker(bookTickerLst));
    }

    private void handleBookTicker(List<BookTicker> bookTickerLst) {
        Map<String, BookTicker> relevantBookTicker =
                bookTickerLst.stream().filter(bookTicker ->
                        generatedCombintaions.contains(bookTicker.getSymbol()))
                        .collect(Collectors.toMap(bookTicker -> bookTicker.getSymbol(),
                                bookTicker -> bookTicker));

        double dollarsFromBTC = 0.9995 * 1 * (Double.parseDouble(relevantBookTicker.get("BTCUSDT").getAskPrice()) - 0.01);

        double ethFromDollars = 0.9995 * (dollarsFromBTC *
                Double.parseDouble(relevantBookTicker.get("ETHUSDT").getBidPrice() + 0.01));

        double btcFromETH = 0.9995 * (ethFromDollars *
                (Double.parseDouble(relevantBookTicker.get("ETHBTC").getAskPrice()) - 0.000001));


        double ethFromBTC = 0.9995 * 1 * ( Double.parseDouble(relevantBookTicker.get("ETHBTC").getBidPrice()) + 0.000001);

        double dollarsFromEth = 0.9995 * ethFromBTC * (Double.parseDouble(relevantBookTicker.get("ETHUSDT").getAskPrice()) - 0.01);

        double bitcoinsFromDollars = 0.9995 * dollarsFromEth * (Double.parseDouble(relevantBookTicker.get("BTCUSDT").getBidPrice() + 0.01));

        if(bitcoinsFromDollars > 1 || btcFromETH > 1 ){
            client.newOrder(new NewOrder("ETHBTC", OrderSide.BUY, OrderType.LIMIT, TimeInForce.GTC, "1"), response -> {});
        }



    }

}
