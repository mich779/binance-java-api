package com.romanobori.cycler

import com.romanobori.cycler.support.AppDriver
import com.romanobori.cycler.support.BinanceStub
import spock.lang.Shared
import spock.lang.Specification

class cyclerSpec extends Specification {

    @Shared AppDriver app = new AppDriver();
    @Shared BinanceStub binance= new BinanceStub();
    def "should not cycle if ratio is not profitable"(){

        when:
        app.cycle(1);

        then:
        assert binance.getOrdersAmount().get() == 0

    }


}
