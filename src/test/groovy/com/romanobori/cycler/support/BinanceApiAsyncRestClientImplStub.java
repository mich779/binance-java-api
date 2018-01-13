package com.romanobori.cycler.support;

import com.binance.api.client.BinanceApiAsyncRestClient;
import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.domain.event.ListenKey;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.domain.market.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BinanceApiAsyncRestClientImplStub implements BinanceApiAsyncRestClient {

    private CloseableHttpClient httpclient = HttpClients.createDefault();

    @Override
    public void ping(BinanceApiCallback<Void> callback) {

    }

    @Override
    public void getServerTime(BinanceApiCallback<ServerTime> callback) {

    }

    @Override
    public void getExchangeInfo(BinanceApiCallback<ExchangeInfo> callback) {

    }

    @Override
    public void getOrderBook(String symbol, Integer limit, BinanceApiCallback<OrderBook> callback) {

    }

    @Override
    public void getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime, BinanceApiCallback<List<AggTrade>> callback) {

    }

    @Override
    public void getAggTrades(String symbol, BinanceApiCallback<List<AggTrade>> callback) {

    }

    @Override
    public void getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime, BinanceApiCallback<List<Candlestick>> callback) {

    }

    @Override
    public void getCandlestickBars(String symbol, CandlestickInterval interval, BinanceApiCallback<List<Candlestick>> callback) {

    }

    @Override
    public void get24HrPriceStatistics(String symbol, BinanceApiCallback<TickerStatistics> callback) {

    }

    @Override
    public void getAllPrices(BinanceApiCallback<List<TickerPrice>> callback) {

    }

    @Override
    public void getBookTickers(BinanceApiCallback<List<BookTicker>> callback) {
        HttpGet httpGet = new HttpGet("http://localhost:8081/api/v1/ticker/allBookTickers");
        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            Type listType = new TypeToken<ArrayList<BookTicker>>(){}.getType();

            String body = EntityUtils.toString(entity);

            List<BookTicker> lst =  new Gson().fromJson(body , listType);

            callback.onResponse(lst);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void newOrder(NewOrder order, BinanceApiCallback<NewOrderResponse> callback) {

    }

    @Override
    public void newOrderTest(NewOrder order, BinanceApiCallback<Void> callback) {
        HttpGet httpGet = new HttpGet("http://localhost:8081/api/v3/order");

        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getOrderStatus(OrderStatusRequest orderStatusRequest, BinanceApiCallback<Order> callback) {

    }

    @Override
    public void cancelOrder(CancelOrderRequest cancelOrderRequest, BinanceApiCallback<Void> callback) {

    }

    @Override
    public void getOpenOrders(OrderRequest orderRequest, BinanceApiCallback<List<Order>> callback) {

    }

    @Override
    public void getAllOrders(AllOrdersRequest orderRequest, BinanceApiCallback<List<Order>> callback) {

    }

    @Override
    public void getAccount(Long recvWindow, Long timestamp, BinanceApiCallback<Account> callback) {

    }

    @Override
    public void getAccount(BinanceApiCallback<Account> callback) {

    }

    @Override
    public void getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp, BinanceApiCallback<List<Trade>> callback) {

    }

    @Override
    public void getMyTrades(String symbol, Integer limit, BinanceApiCallback<List<Trade>> callback) {

    }

    @Override
    public void getMyTrades(String symbol, BinanceApiCallback<List<Trade>> callback) {

    }

    @Override
    public void withdraw(String asset, String address, String amount, String name, BinanceApiCallback<Void> callback) {

    }

    @Override
    public void getDepositHistory(String asset, BinanceApiCallback<DepositHistory> callback) {

    }

    @Override
    public void getWithdrawHistory(String asset, BinanceApiCallback<WithdrawHistory> callback) {

    }

    @Override
    public void getDepositAddress(String asset, BinanceApiCallback<DepositAddress> callback) {

    }

    @Override
    public void startUserDataStream(BinanceApiCallback<ListenKey> callback) {

    }

    @Override
    public void keepAliveUserDataStream(String listenKey, BinanceApiCallback<Void> callback) {

    }

    @Override
    public void closeUserDataStream(String listenKey, BinanceApiCallback<Void> callback) {

    }
}
