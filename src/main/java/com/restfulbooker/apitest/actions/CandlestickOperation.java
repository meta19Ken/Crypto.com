package com.restfulbooker.apitest.actions;

import com.restfulbooker.apitest.actions.CandlestickData;
import com.restfulbooker.apitest.restassuredFuntions.RestActions;

import java.util.List;

public class CandlestickOperation {

    private final String ENDPOINT = "/get-candlestick";

    RestActions restActions;

    public List<CandlestickData> getCandlestickDataAsList(String instrumentName, String timeframe) {
        RestActions.initialize();
        List<?> candlestickData = restActions.getDataAsList(ENDPOINT,
                CandlestickData.class, instrumentName, timeframe);
        return (List<CandlestickData>) candlestickData;
    }
}
