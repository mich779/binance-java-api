package com.romanobori.cycler.support

import com.romanobori.cycler.CoinsCycler

class AppDriver {

    CoinsCycler cycler = new CoinsCycler(new BinanceApiAsyncRestClientImplStub());

    def cycle(amount){
        cycler.cycle(amount);
    }



}
