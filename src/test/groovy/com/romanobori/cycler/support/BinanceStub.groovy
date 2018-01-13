package com.romanobori.cycler.support

import com.binance.api.client.domain.market.BookTicker
import com.google.common.collect.ImmutableList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.rockm.blink.BlinkServer

import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicLong

class BinanceStub {

    protected AtomicLong ordersAmount = new AtomicLong(0);

    List<BookTicker> bookTickers = Arrays.asList(
            new BookTicker("BTCUSDT", "10", "0", "10", "0"),
            new BookTicker("ETHUSDT", "2", "0", "2", "0"),
            new BookTicker("ETHBTC", "0.2", "0", "0.2", "0")
    )
    private BlinkServer server = new BlinkServer(8081){{
        get("/api/v1/ticker/allBookTickers", { req, res -> return gsonBookTickers()})
        get("/api/v3/order", {req,res -> incAndReturnRes()})
    }

        def gsonBookTickers() {
            Type listType = new TypeToken<ArrayList<BookTicker>>(){}.getType();
            return new Gson().toJson(bookTickers)

        }
    }

    def incAndReturnRes() {
        orders.incrementAndGet()
        return "OK"
    }

    public AtomicLong getOrdersAmount() {
        return ordersAmount
    }
}
